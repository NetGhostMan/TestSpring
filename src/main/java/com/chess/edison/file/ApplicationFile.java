package com.chess.edison.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ApplicationFile")
public class ApplicationFile {

	@Autowired
	FileWriterService fileWriterService;

	public void doWriterFile() {
		fileWriterService.write("胡志强");
	}
}
