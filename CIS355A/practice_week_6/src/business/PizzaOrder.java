
package business;

import java.text.NumberFormat;
import java.util.Locale;

public class PizzaOrder {
    private static final NumberFormat CF = NumberFormat.getCurrencyInstance(Locale.US);
    
    public enum PizzaSize {
        Small, Medium, Large
    }
    public static final double DEFAULT_PRICE = 12.99;
    public static final double MIN_PRICE = 0;
    public static final double MAX_PRICE = 12.99;
    public static final String DEFAULT_TYPE = "Item";
    
    private static final double SMALL_PRICE = 6.99;
    private static final double MEDIUM_PRICE = 9.99;
    private static final double LARGE_PRICE = 12.99;
    
    private static final double CHEESE_COST = 1.50;
    private static final double SAUSAGE_COST = 2.25;
    private static final double HAM_COST = 2.5;
    
    private final Person customer = new Person();
    
    private boolean cheeseSelected = false;
    private boolean sausageSelected = false;
    private boolean hamSelected = false;
    
    private PizzaSize pizzaSize;
    private double sizeCost;
    
    private double total = 0;
    private boolean overrideTotal = false;
    private int id =-1;
    
    public PizzaOrder() {
        clearOrder();
    }
    public PizzaOrder(int id) {
        this.id= id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setFirstName(String firstName){
        customer.setFirstName(firstName); 
    }
    public String getFirstName() {
        return customer.getFirstName();
    }
    public void setLastName(String lastName) {
        customer.setLastName(lastName); 
    }
    public String getLastName() {
        return customer.getLastName();
    }
    public String getFullName() {
        return customer.getFullName();
    }
    public void setCheese(boolean selected) {
        cheeseSelected = selected;
    }
    public Boolean getCheese() {
        return cheeseSelected;
    }
    public void setSausage(boolean selected) {
        sausageSelected = selected;
    }
    public Boolean getSausage() {
        return sausageSelected;
    }
    public void setHam(boolean selected) {
        hamSelected = selected;
    }
    public Boolean getHam() {
        return hamSelected;
    }
    public void setTotal(double total) {
        this.total = total;
        overrideTotal = true;
    }
    public double getTotal() {
        if (!overrideTotal) {
            calculateTotalCost();
        }
        return total;
    }
    public String getTotalCost() {
        calculateTotalCost();
        return CF.format(total);
    }
    public void setPizzaSize(PizzaSize size) {
         pizzaSize = size;
    }
    public String getPizzaSize() {
        String str;
        switch (pizzaSize) {
             case Small:
                 str = "Small";
                 break;
             case Medium:
                 str = "Medium";
                 break;
             case Large:
                 str = "Large";
                 break;
             default:
                str = "Large";
                 break; 
         }
        return str;
    }
    private void calculateTotalCost() {
        total = 0;
        switch (pizzaSize) {
             case Small:
                 sizeCost = SMALL_PRICE;
                 break;
             case Medium:
                 sizeCost = MEDIUM_PRICE;
                 break;
             case Large:
                 sizeCost = LARGE_PRICE;
                 break;
             default:
                sizeCost = LARGE_PRICE;
                break; 
         }
        total = sizeCost;
        if (cheeseSelected) {
            total += CHEESE_COST;
        }
        if (sausageSelected) {
             total += SAUSAGE_COST;
        }
        if (hamSelected) {
            total += HAM_COST;
        }
    }
    public void setPizzaSize(String size) {
        if(size.compareToIgnoreCase("small") == 0) {
            pizzaSize = PizzaSize.Small;
        }
        else if (size.compareToIgnoreCase("medium") == 0) {
            pizzaSize = PizzaSize.Medium;
        }
        else if (size.compareToIgnoreCase("large") == 0) {
            pizzaSize = PizzaSize.Large;
        }
        else {
            pizzaSize = PizzaSize.Large;
        }
    }
    public void clearOrder() {
        setPizzaSize(PizzaSize.Large);
        setCheese(false);
        setHam(false);
        setSausage(false);
    }
    public String getOrderInformation() {
        StringBuilder str = new StringBuilder();
        getTotal();
        str.append("Pizza order for:\n");
        str.append(customer.getFullName());
       
        if (cheeseSelected) {
            str.append("\nExtra cheese: ");
            str.append(CF.format(CHEESE_COST));
        }
        if (sausageSelected) {
            str.append("\nSausage: ");
            str.append(CF.format(SAUSAGE_COST));
        }
        if (hamSelected) {
            str.append("\nHam: ");
            str.append(CF.format(HAM_COST));
        }
        str.append ("\nSize: ");
        str.append(getPizzaSize());
        str.append(": ");
        str.append(CF.format(sizeCost));
        str.append("\nTotal: ");
        str.append(CF.format(total));
        return str.toString();
    }
    @Override
    public String toString() {
        return customer.toString();
    }
    
}
