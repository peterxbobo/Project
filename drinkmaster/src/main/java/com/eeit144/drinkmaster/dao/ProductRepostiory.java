package com.eeit144.drinkmaster.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eeit144.drinkmaster.bean.ProductBean;

public interface ProductRepostiory extends JpaRepository<ProductBean, Integer> {

	
}
