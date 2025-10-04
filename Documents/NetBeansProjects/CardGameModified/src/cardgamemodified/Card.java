/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgamemodified;

/**
 *
 * @author win 11
 */
import java.util.Objects;

public class Card {// high  cohesion already stisifed 
    //reuse UNO deck
    // special class, constants, user define datatype
    public enum Suit{DIAMONDS, SPADES, CLUBS, HEARTS};//colors
    
    public enum Rank{ACE, TWO, THREE, FOUR, FIVE,SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING};
    
    private Rank rank; // datatype
    private Suit suit;
    
  public Card(Rank rank, Suit suit) {
        this.rank = Objects.requireNonNull(rank);
        this.suit = Objects.requireNonNull(suit);
    }

    public Suit getSuit() { return suit; }
    public Rank getRank() { return rank; }

    @Override public String toString() { return rank + " of " + suit; }
}

