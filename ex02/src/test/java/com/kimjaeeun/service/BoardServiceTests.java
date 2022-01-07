package com.kimjaeeun.service;

import static org.junit.Assert.assertNotNull;

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
public class BoardServiceTests {
	@Setter @Autowired
	private BoardService service;
	@Test
	public void testExist(){
		assertNotNull(service);
	}
	
	//게시글 작성
	@Test
	public void testRegister(){
		BoardVo board=new BoardVo();
		board.setTitle("서비스 테스트 등록글 제목");
		board.setContent("서비스 테스트 등록글 내용");
		board.setWriter("서비스 테스터");
		service.register(board);
	}
	
	@Test
	public void testGetList(){
		service.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testGet(){
		log.info(service.get(261L));
	}
	
	@Test
	public void testRemove(){
		log.info(service.get(261L));
		log.info(service.remove(261L));
		log.info(service.get(261L));
	}
	
	@Test
	public void testModify(){
		BoardVo boardVo = new BoardVo();
		boardVo.setTitle("서비스 테스트 수정글 제목");
		boardVo.setContent("서비스 테스트 수정글 제목");
		boardVo.setWriter("서비스 테스터");
		boardVo.setBno(261L);
		service.modify(boardVo);
	}
	
	
}
