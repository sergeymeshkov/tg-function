package com.meshkov.tgfunction;

import com.google.cloud.functions.Context;
import com.google.cloud.functions.RawBackgroundFunction;
import lombok.extern.java.Log;

@Log
public class TgFunction implements RawBackgroundFunction {

	@Override
	public void accept(String json, Context context) {
		log.info(json);
		log.info(context.toString());
	}

}
