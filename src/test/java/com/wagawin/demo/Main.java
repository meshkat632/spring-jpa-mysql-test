package com.wagawin.demo;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.client.fluent.Request;
import org.json.JSONException;
import org.json.JSONObject;

public class Main {

	private final static Logger LOGGER = Logger.getLogger("Main");
	
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		CompletionStage<List<String>> twoJokesAsync =  getTwoJokes().whenComplete((jokes,s2) -> {
			jokes.stream().forEach(item -> {
				LOGGER.log(Level.INFO, item);
			});
		});
		twoJokesAsync.toCompletableFuture().get();		 
	}
	 

	public static CompletableFuture<List<String>> getTwoJokes() {

		CompletableFuture<String> firstJokeAsync = CompletableFuture.supplyAsync(() -> getChuckNorrisJoke());
		CompletableFuture<String> secondJokeAsync = CompletableFuture.supplyAsync(() -> getChuckNorrisJoke());

		return firstJokeAsync.thenCombine(secondJokeAsync, (s1, s2) -> Arrays.asList(s1, s2));

	}

	private static String getChuckNorrisJoke() {
		try {
			return new JSONObject(Request.Get("http://api.icndb.com/jokes/random").execute().returnContent().asString())
					.getJSONObject("value").getString("joke");

		} catch (JSONException | IOException e) {
			throw new IllegalStateException("Smith is wrong: ", e);
		}
	}
}
