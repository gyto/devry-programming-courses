/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roman.week5lab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Roman K
 */
public class StockIO {
    
    // attributes
    private String fileName;
    
    // constractos
    public StockIO() {
        fileName = "stocks.txt";
    }
    
    public StockIO(String fileName)
    {
        this.fileName = fileName;
    }
    
    // reads data from file, returns data in array list of stock objects
    public ArrayList<Stock> getData() throws IOException, FileNotFoundException
    {
        
        // create an arrayList so I have something to return
        ArrayList<Stock> list = new ArrayList<Stock>();
        
        BufferedReader inbuffer = new BufferedReader(new FileReader (fileName));
        String inputString = "";
        StringTokenizer tokens;
        System.out.println("Reading the file");

        // get first line
        inputString = inbuffer.readLine();
        while (inputString != null)
        {
            System.out.println("\n" + inputString);
            // break the line into pieces
            tokens = new StringTokenizer(inputString, "#");
            // fields are companyName, numberOfShares, purchasePrice, currentPrice;

            String stockName = tokens.nextToken();
            double numShares = Double.parseDouble(tokens.nextToken());
            double purchasePrice = Double.parseDouble(tokens.nextToken());
            double currentPrice = Double.parseDouble(tokens.nextToken());

            // create the stock and add it to the ArrayList
            Stock stk = new Stock(stockName, numShares, purchasePrice, currentPrice);
            list.add(stk);

            inputString = inbuffer.readLine();
        }
        inbuffer.close();
        
        //return the arrayList
        return list;
    }

    // write data from an array list to the file in proper format
    public void saveData( ArrayList<Stock> stockList ) throws IOException
    {
        // fields are companyName, numberOfShares, purchasePrice, currentPrice;
        // Create first Object
        BufferedWriter outfile = new BufferedWriter(new FileWriter (fileName, true));

        for (Stock stk : stockList)
        {
            outfile.write(stk.getCompanyName() + "#");
            outfile.write(stk.getNumberOfShares() + "#");
            outfile.write(stk.getPurchasePrice() + "#");
            outfile.write("" + stk.getCurrentPrice());
            outfile.newLine();
        }

        outfile.close();
    }
    
    
    // gettors and setters
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
