package br.com.jsmaker.thesimpsons.server;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by jacson on 25/02/18.
 */

public class RetrofitBoot {

    private static final String URLBASE = "https://thesimpsonsquoteapi.glitch.me/";
    private final Retrofit retrofit;

    public RetrofitBoot() {
        retrofit = new Retrofit.Builder().baseUrl(URLBASE).addConverterFactory(JacksonConverterFactory.create()).build();
    }

    public PersonagemServe getPersonagemServe() {
        return retrofit.create(PersonagemServe.class);
    }
}
