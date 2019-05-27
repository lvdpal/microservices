package org.jduchess.set.containssetservice.service;

import org.jduchess.set.containssetservice.model.Card;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ContainsSetController {

    @RequestMapping(method = RequestMethod.POST, value="/containsSet", consumes="application/json; charset=UTF-8", produces = "application/json; charset=UTF-8")
    public boolean containsSet(@RequestBody List<Card> board) {
        List<List<Card>> sets = createPossibleCombos(board);
        return sets.stream().anyMatch(this::checkIfSet);
    }

    private List<List<Card>> createPossibleCombos(List<Card> board) {
        List<List<Card>> combos = new ArrayList<>();
        for (int i=0; i<(board.size()-2);i++) {
            List<Card> combo = new ArrayList<>(3);
            combo.add(board.get(i));
            for (int j=1; j<(board.size()-1);j++) {
                combo.add(board.get(j));
                for(int k=2; k<board.size();k++){
                    combo.add(board.get(k));
                    combos.add(combo);
                }
            }
        }
        return combos;
    }

    private boolean checkIfSet(List<Card> set) {
        Card card1 = set.get(0);
        Card card2 = set.get(1);
        Card card3 = set.get(2);

        return (checkAmount(card1, card2, card3)
                && checkColor(card1, card2, card3)
                && checkFilling(card1, card2, card3)
                && checkShape(card1, card2, card3));
    }

    private boolean checkShape(Card card1, Card card2, Card card3) {
        if (card1.getShape() == card2.getShape()
                && card2.getShape() == card3.getShape()) {
            return true;
        }
        return (card1.getShape() != card2.getShape()
                && card1.getShape() != card3.getShape()
                && card2.getShape() != card3.getShape());
    }

    private boolean checkFilling(Card card1, Card card2, Card card3) {
        if (card1.getFilling() == card2.getFilling()
                && card2.getFilling() == card3.getFilling()) {
            return true;
        }
        return (card1.getFilling() != card2.getFilling()
                && card1.getFilling() != card3.getFilling()
                && card2.getFilling() != card3.getFilling());
    }

    private boolean checkColor(Card card1, Card card2, Card card3) {
        if (card1.getColor() == card2.getColor()
                && card2.getColor() == card3.getColor()) {
            return true;
        }
        return (card1.getColor() != card2.getColor()
                && card1.getColor() != card3.getColor()
                && card2.getColor() != card3.getColor());
    }

    private boolean checkAmount(Card card1, Card card2, Card card3) {
        if (card1.getAmount() == card2.getAmount()
                && card2.getAmount() == card3.getAmount()) {
            return true;
        }
        return (card1.getAmount() != card2.getAmount()
                && card1.getAmount() != card3.getAmount()
                && card2.getAmount() != card3.getAmount());
    }
}
