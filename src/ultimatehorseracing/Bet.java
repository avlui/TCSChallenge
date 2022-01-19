/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultimatehorseracing;

/**
 *
 * @author avlui
 */
public class Bet {
    private int playerId;
    private String bet;
    private int betMoney;

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getBet() {
        return bet;
    }

    public void setBet(String bet) {
        this.bet = bet;
    }

    public int getBetMoney() {
        return betMoney;
    }

    public void setBetMoney(int betMoney) {
        this.betMoney = betMoney;
    }

    public Bet(int playerId, String bet, int betMoney) {
        this.playerId = playerId;
        this.bet = bet;
        this.betMoney = betMoney;
    }
    
    
}
