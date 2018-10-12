/* Week 5 File IO  */
package business;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import data.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;

public class OrderList {
    private ArrayList<PizzaOrder> orderList;
    private static final NumberFormat CF = NumberFormat.getCurrencyInstance(Locale.US);
    private final DataIO dataIO;
       
    public OrderList()  {
        orderList = new ArrayList<>();
        dataIO = new DataIO();
    }
    private void getList()  {
        orderList.clear();
        orderList = dataIO.getList();
    }
   
     public boolean add(PizzaOrder aOrder)  {
        boolean success = false;
        if (aOrder != null) {
             orderList.add(aOrder);
             success = dataIO.add(aOrder);
        }
        return success;
    }
    public boolean remove(PizzaOrder aOrder)  {
        boolean success = false;
        if (aOrder != null) {
            orderList.remove(aOrder);
            success = dataIO.delete(aOrder);
        }
        return success;
    }
    public boolean update(PizzaOrder aOrder)  {
        boolean success = false;
        if (aOrder != null) {
            success = dataIO.update(aOrder);
        }
        return success;
    }
    public int setList(DefaultListModel<PizzaOrder> listModel)  {
        int count  = 0;
        getList();
        
        if (!orderList.isEmpty()) {
            listModel.clear();
            count = orderList.size();
            for(PizzaOrder order : orderList) {
                listModel.addElement(order);
            }
        }
        return count;
    }
     public String getOrderSummary() {
        double totalOrder = 0;
        double averagePrice = 0;
        int count = 0;
        if (!orderList.isEmpty()) {
            for(PizzaOrder aOrder:orderList) {
                totalOrder += aOrder.getTotal();
                count++;
            }
            if (count > 0) {
                averagePrice = totalOrder/count;
            }
        }
         StringBuilder str = new StringBuilder();
         str.append("Pizza Order Summary:\n");
         str.append("Number of total orders: ");
         str.append(count);
         str.append("\n");
         str.append("Total Price of Orders: ");
         str.append(CF.format(totalOrder));
         str.append("\n");
         str.append("Average Price of Orders: ");
         str.append(CF.format(averagePrice));
         
         return str.toString();
    }
}
