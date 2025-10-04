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
public class Hand {
    
private final List<Card> cards = new ArrayList<>();

    public void add(Card c) { cards.add(c); }
    public List<Card> getCards() { return Collections.unmodifiableList(cards); }

    public int value() {
        int total = 0, aces = 0;
        for (Card c : cards) {
            switch (c.getRank()) {
                case TWO: total += 2; break;
                case THREE: total += 3; break;
                case FOUR: total += 4; break;
                case FIVE: total += 5; break;
                case SIX: total += 6; break;
                case SEVEN: total += 7; break;
                case EIGHT: total += 8; break;
                case NINE: total += 9; break;
                case TEN: case JACK: case QUEEN: case KING: total += 10; break;
                case ACE: aces++; total += 11; break;
            }
        }
        while (total > 21 && aces > 0) { total -= 10; aces--; }
        return total;
    }

    public boolean isBlackjack() { return cards.size() == 2 && value() == 21; }
    public boolean isBust() { return value() > 21; }
}
