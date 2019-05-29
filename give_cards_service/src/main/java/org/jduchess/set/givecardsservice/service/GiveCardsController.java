package org.jduchess.set.givecardsservice.service;

import org.jduchess.set.givecardsservice.model.Card;
import org.jduchess.set.givecardsservice.model.GiveCardsResponse;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cards")
public class GiveCardsController {

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value="/draw", consumes="application/json; charset=UTF-8", produces = "application/json; charset=UTF-8")
    public GiveCardsResponse drawThreeCards(@RequestParam("numberOfCards") Integer numberOfCards, @RequestBody List<Card> gameCardsIn) {
        List<Card> drawnCards = new ArrayList<>(numberOfCards);
        List<Card> gameCards = new ArrayList<>(gameCardsIn);
        if(!CollectionUtils.isEmpty(gameCards)) {
            for (int i = 0; i < numberOfCards; i++) {
                drawnCards.add(gameCards.get(0));
                gameCards.remove(0);
            }
        }
        return new GiveCardsResponse(drawnCards, gameCards);
    }

}
