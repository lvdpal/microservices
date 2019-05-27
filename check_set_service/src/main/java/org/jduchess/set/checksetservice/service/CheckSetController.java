package org.jduchess.set.checksetservice.service;

import org.jduchess.set.checksetservice.model.Card;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CheckSetController {
    @RequestMapping(method = RequestMethod.POST, value="/check", consumes="application/json; charset=UTF-8", produces = "application/json; charset=UTF-8")
    public boolean isValidSet(@RequestBody List<Card> cards) {
        Card card1 = cards.get(0);
        Card card2 = cards.get(1);
        Card card3 = cards.get(2);

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
