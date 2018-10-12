/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import java.io.*;
import java.util.ArrayList;
import business.*;
import java.util.StringTokenizer;

public class PizzaFileIO {
    public static final String DEFAULT_FILE_NAME = "order.dat";
    public static final String DELIMTER = ",";
    
    private String fileName;
    
    public PizzaFileIO() {
        fileName = DEFAULT_FILE_NAME;
    }
    public PizzaFileIO(String fileName) {
        setFileName(fileName);
    }
    public final void setFileName(String fileName) {
        if (fileName != null && !fileName.trim().isEmpty())
        {
            this.fileName = DEFAULT_FILE_NAME;
        }
        else {
            this.fileName = fileName;
        }
    }
    public String getFileName() {
        return fileName;
    }
    public int writeData(ArrayList<PizzaOrder> orderList) throws IOException {
        StringBuilder recordList = new StringBuilder();
        int count = 0;
        
        if(!orderList.isEmpty()) {
            for(PizzaOrder aOrder:orderList) {
                count++;
                recordList.append(aOrder.getFirstName());
                recordList.append(DELIMTER);
                recordList.append(aOrder.getLastName());
                recordList.append(DELIMTER);
                recordList.append(aOrder.getPizzaSize());
                recordList.append(DELIMTER);
                recordList.append(aOrder.getCheese());
                recordList.append(DELIMTER);
                //TODO, write the code to: (remember to separate the fields by the delimiter)
                //1.  add the statement to add the sausage value to the record
                //2.  add the statement to add the ham value to the record
                //3.  add the statements to add the total value to the record
                recordList.append(aOrder.getSausage());
                recordList.append(DELIMTER);
                recordList.append(aOrder.getHam());
                recordList.append(DELIMTER);
                recordList.append(aOrder.getTotal());
                recordList.append(DELIMTER);
                
                if (count < orderList.size())
                    recordList.append("\r\n");
            }
            FileStream.writeData(recordList.toString(), fileName);
        }
        return count;
    }
    public ArrayList<PizzaOrder> readData() throws IllegalArgumentException, IOException {
        PizzaOrder aOrder;
        ArrayList<String> recordList;
        ArrayList<PizzaOrder> orderList = new ArrayList<>();
        StringTokenizer row;
        
        recordList = FileStream.readList(fileName);
        if (!recordList.isEmpty()) {
            for(String record:recordList) {
                row = new StringTokenizer(record, DELIMTER);
                if (row.countTokens() == 7) {
                    aOrder = new PizzaOrder();
                    aOrder.setFirstName(row.nextToken());
                    aOrder.setLastName(row.nextToken());
                    aOrder.setPizzaSize(row.nextToken());
                    aOrder.setCheese(Boolean.valueOf(row.nextToken()));
         
                    //TODO:  add statements to:
                    //1.  add the sausage value to the order object
                    //2.  add the ham order to the object
                    //3.  add the total value to the order (keeping in mind you have to "parse" the value into a double
                    //4.  add the order to the array list
                    
                    aOrder.setSausage(Boolean.valueOf(row.nextToken()));
                    aOrder.setHam(Boolean.valueOf(row.nextToken()));
                    aOrder.setTotal(Double.parseDouble(row.nextToken()));
                    
                    orderList.add(aOrder);
                }
            }
        }
        return orderList;
    }

}
