package com.kimjaeeun.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
@WebAppConfiguration
public class BoardControllerTests {
	@Autowired @Setter
	private WebApplicationContext ctx;
	private MockMvc mvc;
	
	@Before //@Before가 적용된 메서드는 모든 테스트 전에 매번 실행됨
	public void setup(){
		//가짜로 url과 파라미터등을 부라우저에서 사용하는것처럼 만들어서 Controller를 실행해볼 수 있음
		mvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() throws Exception{
		log.info(
				mvc.perform(MockMvcRequestBuilders.get("/board/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}
	
	@Test
	public void testRegister() throws Exception{
		String resultPage = mvc.perform(MockMvcRequestBuilders.post("/board/register")
				.param("title","컨트롤러 테스트 새글 제목")
				.param("content","컨트롤러 테스트 새글 내용")
				.param("writer","user00")
				).andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}
	
	@Test
	public void testGet() throws Exception{
		log.info(mvc.perform(MockMvcRequestBuilders
				.get("/board/get")
				.param("bno", "265"))
				.andReturn()
				.getModelAndView().getModelMap());
	}
	
	@Test
	public void testModify() throws Exception{
		ModelAndView mav =mvc.perform(
				MockMvcRequestBuilders.post("/board/modify")
				.param("title", "컨트롤러테스트 글 제목 수정12")
				.param("content","컨트롤러 테스트 글 내용 수정12")
				.param("writer", "컨트롤러 테스터122")
				.param("bno","265"))
			.andReturn()
			.getModelAndView();
		
		log.info(mav.getViewName());
	}
	
	@Test
	public void testRemove() throws Exception{
		ModelAndView mav = mvc.perform(MockMvcRequestBuilders.post("/board/remove")
				.param("bno", "20"))
				.andReturn()
				.getModelAndView();
		
		log.info(mav.getViewName());
	}

}
