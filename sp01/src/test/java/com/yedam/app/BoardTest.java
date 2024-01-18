package com.yedam.app;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/database-context.xml")
public class BoardTest {
	
	@Autowired
	BoardMapper boardMapper;
	
	//전체조회
	@Test
	public void selectBoardList() {
		List<BoardVO> list = boardMapper.selectBoardList();
		assertTrue(!list.isEmpty());
	}
	
	//단건조회
	@Test
	public void selectInfo() {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(1);
		boardMapper.selectBoard(boardVO);
	}
	
//	//등록
//	@Test
//	public void insertInfo() {
//		BoardVO boardVO = new BoardVO();
//		boardVO.setTitle("제목2");
//		boardVO.setContents("내용3");
//		boardVO.setWriter("작성자2");
//		boardVO.setImage("이미지2");
//		
//		int result = boardMapper.insertBoard(boardVO);
//		assertNotEquals(result, 0);
//	}
	
//	//수정
//	//@Test
//	public void updateInfo() {
//		EmpVO empVO = new EmpVO();
//		empVO.setEmployeeId(207);
//		EmpVO findVO = empMapper.selectEmpInfo(empVO);
//		findVO.setLastName("Kang");
//		int result = empMapper.updateEmpInfo(findVO);
//		assertNotEquals(result, 0);
//	}
//	
//	//수정
//	//@Test
//	public void updateInfoDynamic() {
//		EmpVO empVO = new EmpVO();
//		empVO.setEmployeeId(207);
//		empVO.setSalary(5200);
//		int result = empMapper.updateEmpInfoDynamic(empVO);
//		assertNotEquals(result, 0);
//	}
//	
//	//삭제
//	@Test
//	public void deleteInfo() {
//		int result = empMapper.deleteEmpInfo(207);
//		assertNotEquals(result, 0);
//	}
//	
}
