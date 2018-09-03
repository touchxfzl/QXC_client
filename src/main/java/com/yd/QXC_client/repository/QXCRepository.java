package com.yd.QXC_client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.yd.QXC_client.domain.QXC;

public interface QXCRepository extends CrudRepository<QXC, String>{
	@Query(value = "select * from qxc where pre_draw_issue = ?", nativeQuery = true)
	QXC findOne(Integer preDrawIssue);
	
	@Query(value = "select * from qxc ", nativeQuery = true)
	List<QXC> findAllQXC();

}
