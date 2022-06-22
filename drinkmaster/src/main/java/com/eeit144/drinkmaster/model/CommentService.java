package com.eeit144.drinkmaster.model;

import java.util.List;

import org.springframework.data.domain.Page;

import com.eeit144.drinkmaster.bean.CommentBean;

public interface CommentService {
	
	public CommentBean findById(Integer id);

	public List<CommentBean> findAll();

	public void insertComment(CommentBean comment);

	public void deleteById(Integer id);
	
	public Page<CommentBean> findByPage(Integer pageNumber);
	
	public CommentBean getLastest();
		
	public List<CommentBean> findCommentByStoreid(Integer storeId);

	public CommentBean getScoreAsc();
	
	public CommentBean getScoreDesc();
	
	public CommentBean getCreateTimeAsc();
	
	public CommentBean getCreateTimeDesc();
	
	

	
}
