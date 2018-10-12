/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roman.week5lab;

/**
 *
 * @author Roman K
 */

public class Stock {
    // attrubuters
    
    private String companyName;
    private Double numberOfShares;
    private Double purchasePrice;
    private Double currentPrice;
    
    // constractors
    
    /// Default constractor
    public Stock() {
        companyName = "N/A";
        numberOfShares = 0.0;
        purchasePrice = 0.0;
        currentPrice = 0.0;
    }
    
    public Stock(String companyName, Double numberOfShares, Double purchasePrice, Double currentPrice) {
        this.companyName = companyName;
        this.numberOfShares = numberOfShares;
        this.purchasePrice = purchasePrice;
        this.currentPrice = currentPrice;
    }
    
    // behaviors
    public double calculateProfitLoss()
    {
        return numberOfShares * (currentPrice - purchasePrice);
    }

    @Override
    public String toString() {
        return companyName + ": " + numberOfShares + " shares"; 
    }
    
    // accessors and mutators
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(Double numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

}
