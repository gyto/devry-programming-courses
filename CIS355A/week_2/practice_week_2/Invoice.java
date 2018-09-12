package business;

import java.text.NumberFormat;
import java.util.Locale;

public class Invoice {
        
    private String productName;
    private int quantityPurchased;
    private double pricePerItem;

    public Invoice() {
        setProductName("");;
        setQuantityPurchased(1);
        setPricePerItem(10);
    }
    public Invoice(String productName, int quantityPurchased, double pricePerItem) {
        setProductName(productName);
        setQuantityPurchased(quantityPurchased);
        setPricePerItem(pricePerItem);
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        if(productName != null && !productName.trim().isEmpty()) {
              this.productName = productName;
        }
        else {
            this.productName = "Unknown product";
        } 
    }
    public int getQuantityPurchased() {
        return quantityPurchased;
    }
    public void setQuantityPurchased(int quantityPurchased) {
        if (quantityPurchased >= 1 && quantityPurchased <= 1000) {
            this.quantityPurchased = quantityPurchased;
        }
        else if (quantityPurchased < 1) {
           this.quantityPurchased = 1;
        }
        else {
            this.quantityPurchased = 1000;
        }
    }
    public double getPricePerItem() {
        return pricePerItem;
    }
    public void setPricePerItem(double pricePerItem) {
        if (pricePerItem >= 10 && pricePerItem <= 10000) {
            this.pricePerItem = pricePerItem;
        }
        else if (pricePerItem < 10) {
            this.pricePerItem = 10;
        }
        else {
            this.pricePerItem = 10000;
        } 
    }
    public double getTotalCost() {
        return pricePerItem * quantityPurchased;
    }
    @Override
    public String toString() {
        NumberFormat cf = NumberFormat.getCurrencyInstance(Locale.US);
        StringBuilder str = new StringBuilder();
        str.append("Invoice Information:");
        str.append("\nProduct Name: ");
        str.append(productName);
        str.append("\nNumber of items: ");
        str.append(quantityPurchased);
        str.append("\nPrice Per Item: ");
        str.append(cf.format(pricePerItem));
        str.append("\nTotal cost: ");
        str.append(cf.format(getTotalCost()));
        return str.toString();
    }
}
