package data;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/** 
 * @author Tevis Boulware
 * @version 1.0
 * <p><b>Class Description</b></p>
 * <p>
 * This class contains static/shared methods for working with streaming, sequential text files.
 * </p>
 */
public class FileStream 
{
    /**
     * Given the string of delimited string records, the method will write the string to the given file and overwrite existing data.
     * @param data
     * @param fileName
     * @return boolean, with true = writing was successful and the file is updated, false = file write failure and file is not updated.
     * @exception IOException
     */
    public static Boolean writeData(String data, String fileName) throws IOException
    {
        Boolean success;
        try
        {
            FileWriter dataFile = new FileWriter(fileName, false);
            try (PrintWriter output = new PrintWriter(dataFile)) {
                //TODO:  provide the statement to write the entire data string to the file
                output.write(data);
            }
            success = true;
        }
        catch (IOException ioe)
        {
            JOptionPane.showMessageDialog(null, ioe.getMessage(), "File Write Error", JOptionPane.ERROR);
            success = false;
        }
        return success;
    }
    /**
     * Checks to see if the file exists, if not will prompt the user to select a file. If file exists, then the file records
     * are read in one line at a time and stored in an encapsulating string file.
     * @param fileName
     * @return string that contains all the records, separated by a line separator.
     * @exception FileNotFoundException
     * @exception IllegalArgumentException
     * @exception IOException
     */
    public static String readData(String fileName) throws FileNotFoundException, IllegalArgumentException, IOException
    {
        String str;
        StringBuilder contents = new StringBuilder();
        try
        {
            String file = checkFile(fileName);
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                while ((str = br.readLine()) != null)
                {
                    contents.append(str).append(System.getProperty("line.separator"));
                }
            }
        }
        catch (FileNotFoundException | IllegalArgumentException ioe)
        {
            JOptionPane.showMessageDialog(null, ioe.getMessage(), "File Read Error", JOptionPane.ERROR);
            contents.append("No data");
        }
        catch (IOException ioe)
        {
            JOptionPane.showMessageDialog(null, ioe.getMessage(), "File Read Error", JOptionPane.ERROR);
            contents.append("No data");
        }
        return contents.toString();
    }
    /**
     * Checks to see if a the file exists, if not then allows the user to select the file.
     * If file exists, then the file records are read in one line at a time and stored in the array list, where
     * each string element is a delimited record.
     * @param fileName name of the file to read
     * @return array list of string records
     * @exception FileNotFoundException
     * @exception IllegalArgumentException
     * @exception IOException 
     */
    public static ArrayList<String> readList(String fileName) throws FileNotFoundException, IllegalArgumentException, IOException
    {
        ArrayList<String> dataList = new ArrayList<>();
        String str;
        try {
            String file = checkFile(fileName);
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                while ((str = br.readLine()) != null)
                {
                    //TODO:  write the statement to add the string to the arrayList
                    dataList.add(str);
                }
            }
        }
        catch (IOException ioe)
        {
            JOptionPane.showMessageDialog(null, ioe.getMessage(), "File Read Error", JOptionPane.ERROR);
            dataList = null;
        }
        return dataList;
    }
    /**
     * Determine if the file exists, if not it will prompt the user to select a file.
     * @param fileName string name of the file
     * @return the file name as a string.
     */
    public static String checkFile(String fileName) {
        String aFile;
        File theFile = new File(fileName);
        if (theFile.exists()) {
            aFile = fileName;
        }
        else {
            aFile = selectFile();
        }
        return aFile;
    }
    /**
     * Uses the JFileChooser to find a file.
     * @return the absolute, complete path of the file as a string
     * @exception HeadlessException thrown when code that is dependent on a keyboard, display, or mouse is called in an environment that does not support a keyboard, display, or mouse
     */
    public static String selectFile() throws HeadlessException
    {
        String fileName = "";
        JFileChooser fileChooser = new JFileChooser();
        int returnValue;
        File selectedFile;

        try {
            returnValue = fileChooser.showDialog(null, "Select File");
            if (returnValue == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = fileChooser.getSelectedFile();
                fileName = selectedFile.getAbsolutePath();
            }
            else
            {
                fileName = "File not found";
            }
        }
        catch (HeadlessException ex) {
            String message = "Environment doesn't support mouse or keyboard actions";
            JOptionPane.showMessageDialog(null, message + ": " + ex.getMessage(), "Illegal action", JOptionPane.ERROR);
        }
    
        return fileName;
    }
}
