package org.jduchess.set.shuffledeckservice.service;

import org.jduchess.set.shuffledeckservice.model.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/cards")
public class ShuffleDeckController {
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value="/createGame", produces = "application/json; charset=UTF-8")
    public List<Card> createGame() {
        List<Card> newCards = allCardsInOrder();
        Collections.shuffle(newCards);
        return newCards;
    }

    private List<Card> allCardsInOrder() {
        List<Card> cards = new ArrayList<>();
        int id = 0;
        for (CardAmount amount : CardAmount.values()) {
            for(CardFilling filling: CardFilling.values()) {
                for(CardColor color: CardColor.values()) {
                    for (CardShape shape: CardShape.values()) {
                        cards.add(new Card(id, amount, filling, color, shape));
                        id++;
                    }
                }
            }
        }
        return cards;
    }

}
