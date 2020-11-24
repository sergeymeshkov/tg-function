package com.meshkov.tgfunction;

import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class TgFunctionTest {

	TgFunction tgFunction = new TgFunction();

	@Test
	void service() throws Exception {
		tgFunction.service(makeHttpRequest(), makeHttpResponse());
	}

	private HttpRequest makeHttpRequest() {


		return new HttpRequest() {

			@Override
			public Optional<String> getContentType() {
				return Optional.of("application/json");
			}

			@Override
			public long getContentLength() {
				return 0;
			}

			@Override
			public Optional<String> getCharacterEncoding() {
				return Optional.empty();
			}

			@Override
			public InputStream getInputStream() {
				return null;
			}

			@Override
			public BufferedReader getReader() {
				final var in = new StringReader("{\"update_id\":968762031,\"message\":{\"message_id\":7,\"from\":{\"id\":42794330,\"is_bot\":false,\"first_name\":\"sergey\",\"last_name\":\"mshkv\",\"username\":\"smshkv\",\"language_code\":\"en\"},\"chat\":{\"id\":42794330,\"first_name\":\"sergey\",\"last_name\":\"mshkv\",\"username\":\"smshkv\",\"type\":\"private\"},\"date\":1606245616,\"sticker\":{\"width\":512,\"height\":512,\"emoji\":\"\\u263a\\ufe0f\",\"set_name\":\"Honey_boo_boo\",\"is_animated\":false,\"thumb\":{\"file_id\":\"AAMCBAADGQEAAwdfvVzwRmF0kdSKQXnxphh74jpm8wACKgEAAnCwNwJ_bOK6mWpqsuSYjDAABAEAB20AAxwFAAIeBA\",\"file_unique_id\":\"AQAD5JiMMAAEHAUAAg\",\"file_size\":5098,\"width\":128,\"height\":128},\"file_id\":\"CAACAgQAAxkBAAMHX71c8EZhdJHUikF58aYYe-I6ZvMAAioBAAJwsDcCf2ziuplqarIeBA\",\"file_unique_id\":\"AgADKgEAAnCwNwI\",\"file_size\":30566}}}");
				return new BufferedReader(in);
			}

			@Override
			public Map<String, List<String>> getHeaders() {
				return Collections.emptyMap();
			}

			@Override
			public String getMethod() {
				return "POST";
			}

			@Override
			public String getUri() {
				return "http://test.net/";
			}

			@Override
			public String getPath() {
				return "/";
			}

			@Override
			public Optional<String> getQuery() {
				return Optional.empty();
			}

			@Override
			public Map<String, List<String>> getQueryParameters() {
				return Collections.emptyMap();
			}

			@Override
			public Map<String, HttpPart> getParts() {
				return Collections.emptyMap();
			}
		};
	}

	private HttpResponse makeHttpResponse() {
		return new HttpResponse() {

			private int statusCode;
			private String statusMessage;
			private String contentType;
			private Map<String, List<String>> headers = new HashMap<>();
			private BufferedWriter writer = new BufferedWriter(new StringWriter());
			private OutputStream os = new ByteArrayOutputStream();

			@Override
			public void setStatusCode(int code) {
				this.statusCode = code;
			}

			@Override
			public void setStatusCode(int code, String message) {
				this.statusCode = code;
				this.statusMessage = message;
			}

			@Override
			public void setContentType(String contentType) {
				this.contentType = contentType;
			}

			@Override
			public Optional<String> getContentType() {
				return Optional.ofNullable(contentType);
			}

			@Override
			public void appendHeader(String header, String value) {
				headers.put(header, Collections.singletonList(value));
			}

			@Override
			public Map<String, List<String>> getHeaders() {
				return headers;
			}

			@Override
			public OutputStream getOutputStream() {
				return os;
			}

			@Override
			public BufferedWriter getWriter() {
				return writer;
			}
		};
	}


}