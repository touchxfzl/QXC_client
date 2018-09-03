package com.yd.QXC_client.schedule;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.annotation.Resource;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.yd.QXC_client.domain.QXC;
import com.yd.QXC_client.service.QXCService;


@Component
public class QXCScheduledTasks {
	
	@Resource
	private QXCService qxcService;
	// 体彩七星彩
	@Scheduled(cron = "*/5 * * * * *")
	private void parse() throws Exception {
		String url = "https://api.api68.com/QuanGuoCai/getLotteryInfo.do?issue=&lotCode=10045";
		final int timeout = 5 * 1000;// httpclient超时时间
		RequestConfig config = RequestConfig.custom().setConnectTimeout(timeout).setConnectionRequestTimeout(timeout)
				.setSocketTimeout(timeout).build();
		CloseableHttpClient httpclient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
		HttpGet httpGet = new HttpGet(url);
		try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {// 请求成功返回200
				HttpEntity entity = response.getEntity();
				String json = EntityUtils.toString(entity);
				JSONObject jsonObject = new JSONObject(json);
				JSONObject result = jsonObject.getJSONObject("result");
				int businessCode = result.getInt("businessCode");
				if (businessCode == 0) {// 业务代码等于0表示成功
					// 获取josn
					JSONObject data = result.getJSONObject("data");
					final Integer preDrawIssue = data.getInt("preDrawIssue");

					final String drawTimeStr = data.getString("drawTime");
					DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					LocalDateTime drawTime = LocalDateTime.parse(drawTimeStr, dateTimeFormatter);
					boolean isExisted = qxcService.findOne(preDrawIssue);
					
					// JSONObject data=result
					if (!isExisted) {// 数据库不存在则添加
						final String preDrawCode = data.getString("preDrawCode");
						int sum = 0;
						String[] nums = preDrawCode.split(",");
						Integer[] winningNums = new Integer[nums.length];
						for (int i = 0; i < nums.length; i++) {
							int num = Integer.parseInt(nums[i]);
							winningNums[i] = num;
							sum += num;
						}

						final String preDrawTimeStr = data.getString("preDrawTime");
						LocalDateTime preDrawTime = LocalDateTime.parse(preDrawTimeStr, dateTimeFormatter);
						// Kuai3DiceEnum numForm = Kuai3DiceEnum.parseDice(winningNums);

						/*
						 * Colorful colorful= new Colorful(preDrawIssue, colorNumber, preDrawTime,
						 * preDrawTime, lotteryType, colorNumber, sum, numForm);
						 */

						QXC nationwide = new QXC(null, drawTime, preDrawCode, preDrawTime, preDrawIssue);
						qxcService.add(nationwide);
						

					}
					// 请求成功后无论有没有添加都要睡眠到下次开奖时间，如果请求到上期的数据睡眠秒数为负数
					long millis = ChronoUnit.MILLIS.between(LocalDateTime.now(), drawTime);
					if (millis > 0) {
						Thread.sleep(millis);
					}
				}
			}
		}

	}

}