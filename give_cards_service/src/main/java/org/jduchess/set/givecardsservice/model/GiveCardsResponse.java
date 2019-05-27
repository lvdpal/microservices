package org.jduchess.set.givecardsservice.model;

import java.io.Serializable;
import java.util.List;

public class GiveCardsResponse implements Serializable {
    private List<Card> drawnCards;
    private List<Card> gameCardsOut;

    public GiveCardsResponse() {
        // empty constructor for json
    }

    public GiveCardsResponse(List<Card> drawnCards, List<Card> gameCardsOut) {
        this.drawnCards = drawnCards;
        this.gameCardsOut = gameCardsOut;
    }

    public List<Card> getDrawnCards() {
        return drawnCards;
    }

    public void setDrawnCards(List<Card> drawnCards) {
        this.drawnCards = drawnCards;
    }

    public List<Card> getGameCardsOut() {
        return gameCardsOut;
    }

    public void setGameCardsOut(List<Card> gameCardsOut) {
        this.gameCardsOut = gameCardsOut;
    }
}
