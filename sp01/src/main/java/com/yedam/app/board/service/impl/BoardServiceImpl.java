package com.yedam.app.board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;
import com.yedam.app.emp.mapper.EmpMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	@Autowired
	EmpMapper empMapper;
	
	// 전체조회
	@Override
	public List<BoardVO> getBoardAll() {
		// TODO Auto-generated method stub
		return boardMapper.selectBoardList();
	}
	
	// 단건조회
	@Override
	public BoardVO getBoardInfo(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return boardMapper.selectBoard(boardVO);
	}
	
	// 등록
	@Override
	public int insertBoardInfo(BoardVO boardVO) {
		// TODO Auto-generated method stub
		int result = boardMapper.insertBoard(boardVO);
		
//		if(result == 1) {
//			return boardVO.getBno();
//		}else {
//			return -1;			
//		}
//		
		return result == 1 ? boardVO.getBno() : -1;
	}
	
	// 수정
	@Override
	public Map<String, Object> updateBoardInfo(BoardVO boardVO) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		
		int result = boardMapper.updateBoard(boardVO);
		if(result == 1) {
			isSuccessed = true;
		}
		
		map.put("result", isSuccessed);
		map.put("target", boardVO);
		return map;
	}
	
	// 삭제 
	@Override
	public boolean deleteBoardInfo(int boardVO) {
		// TODO Auto-generated method stub
		int result = boardMapper.deleteBoard(boardVO);
		
//		if(result == 1) {
//			return true;
//		}else {
//			return false;
//		}
		return result == 1 ? true : false;
	}
}
