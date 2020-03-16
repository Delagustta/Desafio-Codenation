package com.gustavo.codenationProject.converter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileToByteArray {
	
	File file = new File("C:\\Users\\Delag\\OneDrive\\Documentos\\Codenation\\answer.json");
	
	public byte[] toByteArray() throws IOException {
		int length = (int) file.length();
		byte[] sendbuf = new byte[length];
		
		FileOutputStream in = new FileOutputStream(file);
		in.write(sendbuf);
		in.close();
		return sendbuf;
		
		
		
		
		
		
		/*
		FileInputStream inFile = new FileInputStream(file);
		inFile.read(sendbuf, 0, length);
		inFile.close();
		return sendbuf;*/
		
	}

}
