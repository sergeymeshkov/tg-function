package com.meshkov.tgfunction;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import com.pengrad.telegrambot.BotUtils;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
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

		final var update = BotUtils.parseUpdate(request.getReader());
		log.info("Update : " + update);

		final var chatId = update.message().chat().id();
		final var message = new SendMessage(chatId, "It works!").toWebhookResponse();

		response.setStatusCode(200);
		response.setContentType("application/json");
		try (final var writer = response.getWriter()) {
			writer.write(message);
		}
	}

}
