/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgamemodified;
import java.util.*;

/**
 *
 * @author win 11
 */

public class Deck {
    private final Deque<Card> cards = new ArrayDeque<>();

    public Deck() { this(1); }

    public Deck(int decks) {
        for (int d = 0; d < decks; d++) {
            for (Card.Suit s : Card.Suit.values()) {
                for (Card.Rank r : Card.Rank.values()) {
                    cards.addLast(new Card(r, s));
                }
            }
        }
        shuffle();
    }

    public void shuffle() {
        List<Card> tmp = new ArrayList<>(cards);
        Collections.shuffle(tmp);
        cards.clear();
        for (Card c : tmp) cards.addLast(c);
    }

    public Card draw() {
        if (cards.isEmpty()) throw new NoSuchElementException("Deck empty");
        return cards.removeFirst();
    }

    public int size() { return cards.size(); }
}

