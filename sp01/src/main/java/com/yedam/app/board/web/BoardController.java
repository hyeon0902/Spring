package com.yedam.app.board.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	// 전체조회 : URI - boardList / RETURN - board/boardList
	@GetMapping("boardList")
	public String getBoardList(Model model) {
		List<BoardVO> list = boardService.getBoardAll();
		model.addAttribute("boardList", list);
		return "board/boardList";
	}
	
	// 단건조회 : URI - boardInfo / PARAMETER - BOARDVO 
	// 		  / RETRUN - board/boardInfo 
	@GetMapping("boardInfo")
	public String getBoardInfo(BoardVO boardVO, Model model) {
		BoardVO findVO = boardService.getBoardInfo(boardVO);
		model.addAttribute("boardInfo",findVO);
		return "board/boardInfo";
		
		// servlet-context.xml 에 prefix 잘 보면..
		// WEB_INF/views 가 prefix로 되어있음
	}
	
	// 등록 - 페이지 : URI - boardInsert / RETURN - board/boardInsert
	@GetMapping("boardInsert")
	public String insertBoardForm() {
		return "board/boardInsert";
	}
	
	// 등록 - 처리 : URI - boardInsert / PARAMETER - BoardVO
	//        / RETRUN - 전체조회 다시 호출
	@PostMapping("boardInsert")
	public String insertBoardProcess(BoardVO boardVO) {
//		int bno = boardService.insertBoardInfo(boardVO);
		boardService.insertBoardInfo(boardVO);
//		String path = null;
//		
//		if(bno > -1) {
//			path = "redirect:boardInfo?bno=" + bno;
//		}else {
//			path = "redirect:boardList";
//		}
//		return path;
		return "redirect:boardList";
	}
	
	// 수정 - 페이지 : URI - boardUpdate / PARAMETER - BoardVO
	//		  / RETURN - board/boardUpdate
	@GetMapping("boardUpdate")
	public String updateBoardForm(BoardVO boardVO, Model model) {
		BoardVO findVO = boardService.getBoardInfo(boardVO);
		model.addAttribute("boardInfo",findVO);
		return "board/boardUpdate";
	}
		
	// 수정 - 처리 : URI - boardUpdate / PARAMETER - BoardVO
	//			 / RETURN - 수정결과 데이터(Map)
	// => Ajax
	@PostMapping("boardUpdate")
	@ResponseBody
	public Map<String, Object> updateBoardProcess(@RequestBody BoardVO boardVO, Model model){
		return boardService.updateBoardInfo(boardVO);
	}
	// 삭제
	@GetMapping("boardDelete")
	public String deleteBoard(@RequestParam Integer bno) {
		boardService.deleteBoardInfo(bno);
		return "redirect:boardList";
	}
	
}
