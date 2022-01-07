package com.kimjaeeun.service;

import java.util.List;

import com.kimjaeeun.domain.BoardVo;

public interface BoardService {
	void register(BoardVo board);
	BoardVo get(Long bno);
	boolean modify(BoardVo board);
	boolean remove(Long bno);
	List<BoardVo> getList();
}
