package com.meshkov.tgfunction;

import com.google.cloud.functions.Context;
import org.junit.jupiter.api.Test;

class TgFunctionTest {

	TgFunction tgFunction = new TgFunction();

	@Test
	void accept() {
		final var json = "{\"test\" : \"test\"}";
		tgFunction.accept(json, createDummyContext());
	}

	private Context createDummyContext() {
		return new Context() {

			@Override
			public String eventId() {
				return null;
			}

			@Override
			public String timestamp() {
				return null;
			}

			@Override
			public String eventType() {
				return null;
			}

			@Override
			public String resource() {
				return null;
			}

		};
	}

}