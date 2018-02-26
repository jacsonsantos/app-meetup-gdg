package br.com.jsmaker.thesimpsons.event;

import java.util.List;

import br.com.jsmaker.thesimpsons.model.Personagem;

/**
 * Created by jacson on 26/02/18.
 */

public class PersonagemEvent {

    private List<Personagem> listaPersonagens;

    public PersonagemEvent(List<Personagem> listaPersonagens){
        this.listaPersonagens = listaPersonagens;
    }

    public List<Personagem> getListaPersonagens() {
        return listaPersonagens;
    }

    public void setListaPersonagens(List<Personagem> listaPersonagens) {
        this.listaPersonagens = listaPersonagens;
    }
}
