package com.yedam.app.aop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.aop.mapper.AaaMapper;
import com.yedam.app.aop.service.AaaService;

@Service
public class AaaServiceImpl implements AaaService{
	
	@Autowired
	AaaMapper aaaMapper;


	//@Transactional
	public void insert() {
		// TODO Auto-generated method stub
		aaaMapper.insertAaa("101");
		aaaMapper.insertAaa("a101");
		
		// 둘중 한개라도 실패하는 경우 롤백
	}
}
