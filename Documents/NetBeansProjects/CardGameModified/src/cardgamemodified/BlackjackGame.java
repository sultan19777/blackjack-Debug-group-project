/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgamemodified;

/**
 *
 * @author win 11
 */
import java.util.Scanner;
public class BlackjackGame {
    
private final Deck deck = new Deck();
    private final BlackjackRules rules = new BlackjackRules();
    private final Scanner in = new Scanner(System.in);

    public void playRound() {
        Hand player = new Hand();
        Hand dealer = new Hand();

        player.add(deck.draw()); dealer.add(deck.draw());
        player.add(deck.draw()); dealer.add(deck.draw());

        System.out.println("Dealer shows: " + dealer.getCards().get(0));
        System.out.println("Your hand: " + player.getCards() + " (" + player.value() + ")");

        while (!player.isBust()) {
            System.out.print("Hit or Stand (h/s)? ");
            String ans = in.nextLine().trim().toLowerCase();
            if (ans.startsWith("h")) {
                Card c = deck.draw();
                player.add(c);
                System.out.println("You drew: " + c + " → total " + player.value());
            } else break;
        }

        System.out.println("Dealer hand: " + dealer.getCards() + " (" + dealer.value() + ")");
        while (!player.isBust() && rules.dealerShouldHit(dealer)) {
            Card c = deck.draw();
            dealer.add(c);
            System.out.println("Dealer draws: " + c + " → total " + dealer.value());
        }

        System.out.println(rules.outcome(player, dealer));
    }
}
