package br.com.jsmaker.thesimpsons;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import br.com.jsmaker.thesimpsons.adapter.PersonagemAdapter;
import br.com.jsmaker.thesimpsons.callback.PersonagemCallBack;
import br.com.jsmaker.thesimpsons.event.PersonagemEvent;
import br.com.jsmaker.thesimpsons.model.Personagem;
import br.com.jsmaker.thesimpsons.server.RetrofitBoot;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity {
    private ListView listaPersonagens;
    private PersonagemAdapter adapter;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Call call = new RetrofitBoot().getPersonagemServe().listarPersonagens();
        call.enqueue(new PersonagemCallBack());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCarregarLista(PersonagemEvent event) {

        final List<Personagem> listPersonagens = event.getListaPersonagens();

        adapter = new PersonagemAdapter(MainActivity.this,listPersonagens);
        listaPersonagens = (ListView) findViewById(R.id.personagens);
        listaPersonagens.setAdapter(adapter);
        listaPersonagens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Personagem personagem = listPersonagens.get(i);
                Intent intent = new Intent(MainActivity.this, PersonagemActivity.class);
                intent.putExtra("personagem", personagem);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}