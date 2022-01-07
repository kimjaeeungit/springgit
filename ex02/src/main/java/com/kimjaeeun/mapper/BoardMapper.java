package com.kimjaeeun.mapper;

import java.util.List;

import com.kimjaeeun.domain.BoardVo;

public interface BoardMapper {
	List<BoardVo> getList();
	//insert만 처리되고 생성된 pk값을 알 필요가 없는 경우
	void insert(BoardVo board);
	//insert문이 실행되고 생성된 pk값을 알아햐 하는 경우
	void insertSelectKey(BoardVo board);
	BoardVo read(Long bno);
	int delete(Long bno);
	int update(BoardVo board);
}
