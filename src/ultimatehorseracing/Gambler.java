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
public class Gambler {
    
    public String name;
    int money;
    private int betWon;
    private int betLoss;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }

    public int getBetWon() {
        return betWon;
    }
    public void setBetWon(int betWon) {
        this.betWon = betWon;
    }

    public int getBetLoss() {
        return betLoss;
    }
    public void setBetLoss(int betLoss) {
        this.betLoss = betLoss;
    }

    public Gambler(String name) {
        this.setName(name);
        this.setMoney(20000);
        this.setBetWon(0);
        this.setBetLoss(0);
    }
   
    public void makeBet(String horseName, double moneyToBet){
        
    }
}
