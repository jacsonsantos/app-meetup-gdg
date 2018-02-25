package br.com.jsmaker.thesimpsons.callback;

import android.util.Log;
import android.widget.ListView;

import java.util.List;

import br.com.jsmaker.thesimpsons.MainActivity;
import br.com.jsmaker.thesimpsons.adapter.PersonagemAdapter;
import br.com.jsmaker.thesimpsons.model.Personagem;
import retrofit2.Call;
import retrofit2.Response;

public class PersonagemCallBack implements retrofit2.Callback<List<Personagem>> {

    private MainActivity activity;
    private List<Personagem> listPersonagens;

    public PersonagemCallBack(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onResponse(Call call, Response response) {

        if(response.isSuccessful()) {
            listPersonagens = (List<Personagem>) response.body();
            activity.carregarLista(listPersonagens);
        }
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        Log.e("onFailure", "Erro ao carregar lista");
    }
}
