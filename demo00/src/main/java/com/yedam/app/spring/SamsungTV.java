package com.yedam.app.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")
public class SamsungTV implements TV {

	@Autowired
	Speaker speaker;
	
	// 생성자 방식
	SamsungTV(){}
	
	@Autowired
	SamsungTV(Speaker speaker){
		this.speaker = speaker;
	}
	
	
	// 생성자가 없는 경우 자동으로 생성
	// 하나라도 존재하는 경우  예시) SamsungTV(){} 정의 해주어야함
	
//	// setter 방식
//	public void setSpeaker(Speaker speaker) {
//		this.speaker = speaker;
//	}
	
	@Override
	public void on() {
		// TODO Auto-generated method stub
		System.out.println("삼성 TV를 켰습니다.");
		speaker.on();
	}
	
	
}
