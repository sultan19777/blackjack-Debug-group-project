/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgamemodified;

/**
 *
 * @author win 11
 */
public class BlackjackRules {
    
 private final boolean hitSoft17;
    public BlackjackRules() { this(true); } // hit soft 17 by default
    public BlackjackRules(boolean hitSoft17) { this.hitSoft17 = hitSoft17; }

    public boolean dealerShouldHit(Hand dealerHand) {
        int value = dealerHand.value();
        if (value < 17) return true;
        if (value > 17) return false;
        boolean soft = dealerHand.getCards().stream()
                         .anyMatch(c -> c.getRank() == Card.Rank.ACE) && value == 17;
        return hitSoft17 && soft;
    }

    public String outcome(Hand player, Hand dealer) {
        if (player.isBust()) return "Player busts — Dealer wins";
        if (dealer.isBust()) return "Dealer busts — Player wins";
        int pv = player.value(), dv = dealer.value();
        if (pv > dv) return "Player wins";
        if (pv < dv) return "Dealer wins";
        return "Push (tie)";
    }
}
