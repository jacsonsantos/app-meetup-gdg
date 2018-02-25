package br.com.jsmaker.thesimpsons.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Personagem implements Serializable {

    @JsonProperty("quote")
    private String quote;

    @JsonProperty("character")
    private String character;

    @JsonProperty("image")
    private String image;

    @JsonProperty("characterDirection")
    private String characterDirection;

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCharacterDirection() {
        return characterDirection;
    }

    public void setCharacterDirection(String characterDirection) {
        this.characterDirection = characterDirection;
    }
}
