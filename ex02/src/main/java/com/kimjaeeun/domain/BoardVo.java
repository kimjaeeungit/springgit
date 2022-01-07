package com.kimjaeeun.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("board") //매퍼파일에서 별칭으로 해당 클래스 매핑해줌
public class BoardVo {
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;
}
