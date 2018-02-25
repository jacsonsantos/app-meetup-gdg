package br.com.jsmaker.thesimpsons.server;

import java.util.List;

import br.com.jsmaker.thesimpsons.model.Personagem;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jacson on 25/02/18.
 */

public interface PersonagemServe {
    @GET("quotes?count=10")
    Call<List<Personagem>> listarPersonagens();
}
