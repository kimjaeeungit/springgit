package com.kimjaeeun.mapper;

import java.util.List;

import com.kimjaeeun.domain.BoardVO;

public interface BoardMapper {
	public List<BoardVO> getList();
	//insert만 처리되고 생성된 pk값을 알 필요가 없는 경우
	public void insert(BoardVO board);
	//insert문이 실행되고 생성된 pk값을 알아햐 하는 경우
	public void insertSelectKey(BoardVO board);
	public BoardVO read(Long bno);
	public int delete(Long bno);
	public int update(BoardVO board);
}
