package com.yd.QXC_client.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.yd.QXC_client.domain.Sorder;

public interface SorderRepository extends CrudRepository<Sorder, Integer>{
	
	@Query(value = "SELECT product.`name` FROM product,sorder,forder where sorder.pid=product.id and forder.id=sorder.fid order by sorder.fid;", nativeQuery = true)
	List<String> findName();
	
	@Query(value = "SELECT sorder.fid FROM product,sorder,forder where sorder.pid=product.id and forder.id=sorder.fid order by sorder.fid;", nativeQuery = true)
	List<Integer> findOrderNum();
	
	@Query(value = "SELECT sorder.number FROM product,sorder,forder where sorder.pid=product.id and forder.id=sorder.fid order by sorder.fid;", nativeQuery = true)
	List<Integer> findCount();
	
	@Query(value = "SELECT forder.date FROM product,sorder,forder where sorder.pid=product.id and forder.id=sorder.fid order by sorder.fid;", nativeQuery = true)
	List<Date> findTime();

	

}
