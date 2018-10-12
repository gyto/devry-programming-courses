/* Week 5 File IO  */
package business;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import data.*;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

public class OrderList {
    private ArrayList<PizzaOrder> orderList;
    private static final NumberFormat CF = NumberFormat.getCurrencyInstance(Locale.US);
    private final PizzaFileIO streamFile;
       
    public OrderList() {
        orderList = new ArrayList<>();
        streamFile = new PizzaFileIO();
    }
    public String getFileName() {
        return streamFile.getFileName();
    }
    public void add(PizzaOrder aOrder) {
        if (aOrder != null) {
             orderList.add(aOrder);
        }
    }
    public void remove(PizzaOrder aOrder) {
        if (aOrder != null) {
            //TODO:  remove the order object from the arraylist
            orderList.remove(aOrder);
        }
    }
    public int save() throws IOException {
        int count = 0;
        //TODO:  write the array list to file
        streamFile.writeData(orderList);
        
        return count;
    }
    public int retrieve(DefaultListModel<PizzaOrder> listModel) throws IllegalArgumentException, IOException {
        int count  = 0;
        orderList = streamFile.readData();
       
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
