package com.gustavo.codenationProject;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.gustavo.codenationProject.converter.Java2Json;
import com.gustavo.codenationProject.criptografias.CifraDeCesar;
import com.gustavo.codenationProject.criptografias.SHA1;
import com.gustavo.codenationProject.http.PostRequest;
import com.gustavo.codenationProject.resposta.Resposta;

@SpringBootApplication
public class CodenationprojectApplication {

	public static void main(String[] args) throws Exception {

		String url = "https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=d7578f4370796d622f47007f82ae5d54f966ee75";
		
		PostRequest enviar = new PostRequest();

		RestTemplate rest = new RestTemplate();
		Resposta resposta = rest.getForObject(url, Resposta.class);
		
		System.out.println(resposta);
		
		Java2Json converter = new Java2Json();
		converter.java2Json(resposta);

		
		String fraseDecifrada = CifraDeCesar.decifrar(resposta.getNumero_casas(), resposta.getCifrado());
		
		resposta.setDecifrado(fraseDecifrada);
		resposta.setResumo_criptografico(SHA1.sha1(fraseDecifrada));
		
		
		converter.java2Json(resposta);
		
		System.out.println(resposta);
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(enviar.submitAnswer());
		
		
		
		
		
		
		

		

	}

}
