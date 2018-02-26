package br.com.jsmaker.thesimpsons;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.jsmaker.thesimpsons.adapter.PersonagemAdapter;
import br.com.jsmaker.thesimpsons.callback.PersonagemCallBack;
import br.com.jsmaker.thesimpsons.model.Personagem;
import br.com.jsmaker.thesimpsons.server.RetrofitBoot;
import butterknife.BindView;
import butterknife.ButterKnife;
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
        call.enqueue(new PersonagemCallBack(MainActivity.this));
    }

    public void carregarLista(final List<Personagem> listPersonagens) {
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
}