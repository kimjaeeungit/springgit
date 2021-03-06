package com.kimjaeeun.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kimjaeeun.domain.BoardVo;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	@Setter @Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList(){
		mapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testInsert(){
		BoardVo board = new BoardVo();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		mapper.insertSelectKey(board);
		
		log.info(board);
	}
	
	@Test
	public void testRead(){
		//존재하는 게시물 번호로 테스트
		BoardVo board = mapper.read(262L);
		log.info(board);
	}
	
	@Test
	public void testDelete(){
		log.info("DELETE COUNT : " + mapper.delete(263L));
	}
	
	@Test
	public void testUpdate(){
		BoardVo board = new BoardVo();
		board.setBno(261L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("user00");
		
		int count = mapper.update(board);
		log.info("UPDATE COUNT: " + count);
	}
}
