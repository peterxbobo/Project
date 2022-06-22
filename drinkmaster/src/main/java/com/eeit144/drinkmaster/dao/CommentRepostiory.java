package com.eeit144.drinkmaster.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eeit144.drinkmaster.bean.CommentBean;


@Repository
public interface CommentRepostiory extends JpaRepository<CommentBean, Integer> {

	public CommentBean findFirstByOrderByCreateTimeDesc();
	
	@Query(value="select * from comment where storeid = :storeId",nativeQuery = true)
	public List<CommentBean> findCommentByStoreid(@Param(value="storeId")Integer storeId);
	
//	@Query(value="select * from comment order by score DESC",nativeQuery = true)
//	public List<CommentBean> findCommentOrderByScoreDesc();
//	
//	@Query(value="select * from comment order by score ASC",nativeQuery = true)
//	public List<CommentBean> findCommentOrderByScoreAsc();
	
	
	public CommentBean findAllByOrderByScoreAsc();
	
	public CommentBean findAllByOrderByScoreDesc();
	
	public CommentBean findAllByOrderByCreateTimeAsc();
	
	public CommentBean findAllByOrderByCreateTimeDesc();
	
	
}
