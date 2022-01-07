package com.kimjaeeun.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kimjaeeun.domain.BoardVo;
import com.kimjaeeun.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	private BoardMapper boardMapper;
	
	@Override @Transactional
	   public void register(BoardVo boardVo) {
	      boardMapper.insertSelectKey(boardVo);
	}

	@Override
	public BoardVo get(Long bno) {
		log.info("get.."+bno);
		return boardMapper.read(bno);
	}

	@Override
	public boolean modify(BoardVo board) {
		log.info("modify.."+board);
		return boardMapper.update(board) >0;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove.."+bno);
		return boardMapper.delete(bno) > 0;
	}

	@Override
	public List<BoardVo> getList() {
		log.info("getList...");
		return boardMapper.getList();
	}
}
