package com.chess.edison.file;

public interface FileWriterService {

	public void openFile();

	public void closeFlie();

	public void write(String content);
}
