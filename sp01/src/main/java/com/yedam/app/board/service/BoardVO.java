package com.yedam.app.board.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVO {
	private Integer bno;
	private String title;
	private String contents;
	private String writer;
	//<input type="date">
	@DateTimeFormat(pattern= "yyyy년MM월dd일")
	private Date regdate;
	private Date updatedate; // @DateTimeFormat 을 사용하지 않을 경우 yyyy/MM/dd
	private String image;
}
