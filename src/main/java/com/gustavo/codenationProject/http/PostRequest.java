package com.gustavo.codenationProject.http;

import java.io.File;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpEntity;

public class PostRequest {

	String uri = "https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token=d7578f4370796d622f47007f82ae5d54f966ee75";
	String arquivo ="C:\\Users\\Delag\\OneDrive\\Documentos\\Codenation\\answer.json";

	public void submitAnswer() throws Exception {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost uploadFile = new HttpPost(uri);
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.addTextBody("answer", "answer", ContentType.MULTIPART_FORM_DATA);

		// Anexando o arquivo ao post:
		builder.addBinaryBody("answer", new File(arquivo));

		HttpEntity multipart = builder.build();
		uploadFile.setEntity(multipart);
		CloseableHttpResponse response = httpClient.execute(uploadFile);
		HttpEntity responseEntity = response.getEntity();
		responseEntity.getBody().toString();
		

	}
	
	
	
	
	/**
	WebClient webClient = WebClient.builder().baseUrl(uri).build();

	public Object process() throws MalformedURLException {
		final UrlResource resource = new UrlResource("C:\\Users\\Delag\\OneDrive\\Documentos\\Codenation\\answer.json");

		MultiValueMap<String, UrlResource> data = new LinkedMultiValueMap<>();
		data.add("answer", resource);

		return webClient.post().contentType(MediaType.MULTIPART_FORM_DATA).body(BodyInserters.fromMultipartData(data))
				.exchange().flatMap(response -> response.bodyToMono(String.class)).flux();
	}*/

}
