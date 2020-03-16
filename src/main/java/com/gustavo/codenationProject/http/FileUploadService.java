package com.gustavo.codenationProject.http;

import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class FileUploadService {
	
	String url = "https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token=d7578f4370796d622f47007f82ae5d54f966ee75";

	private RestTemplate restTemplate;

	public void postFile(String filename, byte[] someByteArray) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);

		MultiValueMap<String, String> fileMap = new LinkedMultiValueMap<>();
		ContentDisposition contentDisposition = ContentDisposition.builder("form-data").name("answer").filename(filename).build();
		fileMap.add(HttpHeaders.CONTENT_DISPOSITION, contentDisposition.toString());
		HttpEntity<byte[]> fileEntity = new HttpEntity<>(someByteArray, fileMap);

		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("answer", fileEntity);

		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
		try {
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
		} catch (HttpClientErrorException e) {
			e.printStackTrace();
		}
	}
}