/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OpenPay;

/**
 *
 * @author Equipo1
 */
public class CardCharge {
    private String tokenId;
    private double amount;
    private String description;

    public CardCharge(String tokenId, double amount, String description) {
        this.tokenId = tokenId;
        this.amount = amount;
        this.description = description;
    }

    public String getTokenId() {
        return tokenId;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
    
}
