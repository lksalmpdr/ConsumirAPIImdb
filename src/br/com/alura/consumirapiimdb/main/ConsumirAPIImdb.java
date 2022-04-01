package br.com.alura.consumirapiimdb.main;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ConsumirAPIImdb {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		final String API_KEY_IMDB = "yourkeyhere";
		final String urlRecurso = "https://imdb-api.com/en/API/Top250Movies/" + API_KEY_IMDB;

		HttpClient client = HttpClient.newBuilder()
			      .version(Version.HTTP_2)
			      .build();
		
		HttpRequest request = HttpRequest.newBuilder()
			      .uri(URI.create(urlRecurso))
			      .header("Content-Type", "application/json")
			      .GET()
			      .build();
		
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		
		if(response.statusCode()!=200) {
			throw new RuntimeException("Resposta da página: " + response.statusCode()) ;
		}else {
			String resp = response.body();
			System.out.println(resp);
		}
	}

}
