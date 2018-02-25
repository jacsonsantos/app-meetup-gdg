package br.com.jsmaker.thesimpsons.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.jsmaker.thesimpsons.R;
import br.com.jsmaker.thesimpsons.adapter.Image.DownloadImageTask;
import br.com.jsmaker.thesimpsons.model.Personagem;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jacson on 25/02/18.
 */

public class PersonagemAdapter extends BaseAdapter {

    private Activity activity;
    private List<Personagem> personagens;
    private TextView nome;
    private TextView descricao;
    private ImageView avatar;

    public PersonagemAdapter(Activity activity, List<Personagem> personagens) {
        this.activity = activity;
        this.personagens = personagens;
    }

    @Override
    public int getCount() {
        return personagens.size();
    }

    @Override
    public Object getItem(int i) {
        return personagens.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = LayoutInflater.from(activity);
        if(view == null) {
            view = inflater.inflate(R.layout.personagem_adapter, viewGroup, false);
        }

        Personagem personagem = personagens.get(i);
        nome = view.findViewById(R.id.nome_personagem);
        nome.setText(personagem.getCharacter());

        descricao = view.findViewById(R.id.desc_personagem);
        descricao.setText(personagem.getQuote());

        avatar = view.findViewById(R.id.avatar);
        String url = personagem.getImage();
        new DownloadImageTask(avatar).execute(url);

        return view;
    }
}
