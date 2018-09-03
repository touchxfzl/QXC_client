package com.yd.QXC_client.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yd.QXC_client.domain.QXC;
import com.yd.QXC_client.repository.QXCRepository;

@Service
public class QXCService {
	@Resource
	private QXCRepository qxcRepository;

	public boolean findOne(Integer preDrawIssue) {
		QXC qxc = qxcRepository.findOne(preDrawIssue);
		if (qxc==null) {
			return false;
		}
		return true;
	}

	public void add(QXC nationwide) {
		qxcRepository.save(nationwide);
		
	}

	public List<QXC> findAll() {
		// TODO Auto-generated method stub
		return qxcRepository.findAllQXC();
	}
	
	
	
}
