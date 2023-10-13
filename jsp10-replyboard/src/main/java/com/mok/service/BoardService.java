package com.mok.service;

import java.util.List;

import com.mok.dto.BoardDto;

public interface BoardService {
	int write(BoardDto boardDto);
	List<BoardDto> list();
	int getMaxRegroup();
	
	
}
