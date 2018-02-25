package br.com.jsmaker.thesimpsons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import br.com.jsmaker.thesimpsons.adapter.Image.DownloadImageTask;
import br.com.jsmaker.thesimpsons.model.Personagem;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PersonagemActivity extends AppCompatActivity {

    @BindView(R.id.nome_detalhe_personagem)
    TextView nome;

    @BindView(R.id.avatar_personagem)
    ImageView avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personagem);
        ButterKnife.bind(this);
    }

    private void carregarPersonagem(Personagem personagem) {
        nome.setText(personagem.getCharacter());
        new DownloadImageTask(avatar).execute(personagem.getImage());
    }

    @Override
    protected void onResume() {
        super.onResume();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Personagem personagem = (Personagem) extras.getSerializable("personagem");
            carregarPersonagem(personagem);
        }
    }
}
