package com.kh.spring_project_chap1.web;

public class NewFileController {
	//html, jsp, view 공간과 db를 연결하는 역할
	//파일경로를 설정할 때 항상 run하는 java파일 밑에다가 파일 하위 폴더에다가 설정해준다
	//만약에 하위로 두지 않고 따로 만들어서 사용할 경우에는 컴포넌트 스캔(폴더를 바라보는 위치를)을 별도로 지정해줘야 하기 때문이다.
	
	@GetMapping
	public String hello() {
		return "Hello, world";
	}

}
