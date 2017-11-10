package edu.wit.dcsn.comp2000.listapp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PlayerHand extends PileOfCards{

    ArrayList<Card> currentHand = new ArrayList();

    int cardCap = 5;

    public void PlayerHand()
    {
        for (int i = 0; i < 5; i++) {
            currentHand.add(topCard);
        }
    }

    public void drawCard()
    {
        if (currentHand.size() < cardCap)
        {
            currentHand.add(topCard);
        }
        else
            {
                System.out.println("Can't draw card! You already have 5!");
            }
    }

    public Card releaseCard(Card card)
    {
        if (currentHand.contains(card))
        {
            currentHand.remove(card);
            return card;
        }
        return null;
    }

    public void retrieveCard(PlayerHand selectedHand, Card card)
    {
        if (currentHand.contains(card) && selectedHand.currentHand.contains(card))
        {
            selectedHand.releaseCard(card);
            currentHand.add(card);
        }
    }

    public boolean combineCards()
    {
        Set<Card> dupes = new HashSet<>();
        for (Card card : currentHand)
        {
            if (!dupes.add(card))
            {
                currentHand.remove(card);
                currentHand.remove(card);
                return true;
            }
        }
        return false;
    }
}
