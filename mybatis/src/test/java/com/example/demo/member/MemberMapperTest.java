package com.example.demo.member;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.member.mapper.MemberMapper;

@SpringBootTest
public class MemberMapperTest {
	@Autowired 
	MemberMapper mapper;
	
	@Test
	public void 회원단건조회() { 
		String id = "M001";
		
		MemberVO vo = mapper.getMemberList(id);
		System.out.println(vo + " " + "단건조회");
		assertThat(vo.getMid()).isEqualTo(id);
	}
	
}