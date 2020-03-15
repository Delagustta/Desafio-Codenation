package com.gustavo.codenationProject.converter;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.gustavo.codenationProject.resposta.Resposta;

public class Java2Json {

	public void java2Json(Resposta res) {
		
		FileWriter writer;
		
		Gson gson = new Gson();
		
		String json = gson.toJson(res);

		try {
			writer = new FileWriter("C:\\Users\\Delag\\OneDrive\\Documentos\\Codenation\\answer.json");
			writer.write(json);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Arquivo gerado com sucesso !");

	}

}
