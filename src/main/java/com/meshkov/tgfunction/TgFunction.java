package com.meshkov.tgfunction;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import lombok.extern.java.Log;

import java.util.stream.Collectors;

@Log
public class TgFunction implements HttpFunction {

	@Override
	public void service(HttpRequest request, HttpResponse response) throws Exception {
		log.info("Method : " + request.getMethod());
		log.info("Path : " + request.getPath());
		log.info("Uri : " + request.getUri());
		log.info("Query param : " + request.getQueryParameters());
		log.info("Headers : " + request.getHeaders());
		log.info("Content type : " + request.getContentType());
		try (final var reader = request.getReader()) {
			final var body = reader.lines().collect(Collectors.joining());
			log.info("Body : " + body);
		}

		final var statusCode = 200;
		final var contentType = "application/json";
		final var message = "" +
				"{\n" +
				"\"method\" : \"sendMessage\",\n" +
				"\"chat_id\" : \"?\",\n" +
				"\"text\" : \"Ok, I got you!\"\n" +
				"}";

		response.setStatusCode(statusCode);
		response.setContentType(contentType);
		try (final var writer = response.getWriter()) {
			writer.write(message);
		}
	}

}
