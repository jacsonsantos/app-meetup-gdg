package br.com.jsmaker.thesimpsons.callback;

import android.util.Log;
import android.widget.ListView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import br.com.jsmaker.thesimpsons.MainActivity;
import br.com.jsmaker.thesimpsons.adapter.PersonagemAdapter;
import br.com.jsmaker.thesimpsons.event.PersonagemEvent;
import br.com.jsmaker.thesimpsons.model.Personagem;
import retrofit2.Call;
import retrofit2.Response;

public class PersonagemCallBack implements retrofit2.Callback<List<Personagem>> {

    private List<Personagem> listPersonagens;

    @Override
    public void onResponse(Call call, Response response) {

        if(response.isSuccessful()) {
            listPersonagens = (List<Personagem>) response.body();
            EventBus.getDefault().post(new PersonagemEvent(listPersonagens));
        }
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        Log.e("onFailure", "Erro ao carregar lista");
    }
}
