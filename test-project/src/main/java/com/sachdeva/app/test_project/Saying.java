package com.sachdeva.app.test_project;

import org.hibernate.validator.constraints.Length;

public class Saying {

	public long id;
	
	@Length(max=3)
	public String content;
	
	public Saying(){
		
	}
	
	public Saying(Long id,String content){
		this.id=id;
		this.content=content;
	}
	
	
	public Long getId(){
		return id;
	}
	
	public String getContent(){
		return content;
	}
}
