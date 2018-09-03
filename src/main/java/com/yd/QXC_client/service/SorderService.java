package com.yd.QXC_client.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yd.QXC_client.domain.Data;
import com.yd.QXC_client.repository.SorderRepository;

@Service
public class SorderService {
	@Resource
	private SorderRepository sorderRepository;
	
	
	
	public List<Data> findOrderDetail() {
		List<Data> list=new ArrayList<>();
		List<String> names=sorderRepository.findName();
		List<Integer> orderNums=sorderRepository.findOrderNum();
		List<Integer> counts = sorderRepository.findCount();
		List<Date> times = sorderRepository.findTime();
		for(int i=0;i<counts.size();i++) {
			Data data = new Data();
			data.setDcount(counts.get(i));
			data.setDfid(orderNums.get(i));
			data.setDpname(names.get(i));
			data.setTime(times.get(i));
			list.add(data);
		}
		return list;
	}
}
