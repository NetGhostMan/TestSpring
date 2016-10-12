package com.chess.edison.file;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("FileWriterService")
public class FileWriterServiceImpl implements FileWriterService {

	@Value("${path}")
	private String path;

	private PrintWriter printWriter;
	private BufferedWriter bufferedWriter;
	private OutputStreamWriter outputStreamWriter;
	private FileOutputStream fileOutputStream;

	//@PostConstruct
	@Override
	public void openFile() {
		// TODO Auto-generated method stub
		try {
			fileOutputStream = new FileOutputStream(path);
			outputStreamWriter = new OutputStreamWriter(fileOutputStream);
			bufferedWriter = new BufferedWriter(outputStreamWriter);
			printWriter = new PrintWriter(bufferedWriter);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("服务已开启");
	}

	//@PreDestroy
	@Override
	public void closeFlie() {
		// TODO Auto-generated method stub
		try {
			if (printWriter != null)
				printWriter.close();
			if (bufferedWriter != null)
				bufferedWriter.close();
			if (outputStreamWriter != null)
				outputStreamWriter.close();
			if (fileOutputStream != null)
				fileOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("服务已关闭");
	}

	@Override
	public void write(String content) {
		// TODO Auto-generated method stub
		openFile();
		
		printWriter.println(content);
	
		closeFlie();
	}

}
