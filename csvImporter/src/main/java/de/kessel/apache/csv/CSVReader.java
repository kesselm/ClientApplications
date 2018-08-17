package de.kessel.apache.csv;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CSVReader {

    private String csvFile;
    private String fieldDelimiter;
    private BufferedReader br;
    private boolean withHeader;
    private ArrayList<String[]> transactionList = new ArrayList<>();


    public CSVReader(String csvFile, String fieldDelimiter, boolean withHeader) {
        Logger.getLogger(CSVReader.class.getName()).log(Level.INFO, "CSVReader constructor");
        this.csvFile = csvFile;
        this.fieldDelimiter = fieldDelimiter;
        this.withHeader = withHeader;
        try {
            br = new BufferedReader(new FileReader(this.csvFile));
            String line;
            while((line = br.readLine()) != null){
                String[] fields = line.split(fieldDelimiter, -1);
                System.out.println("=== Transaction ===");
                for ( String field : fields){
                    System.out.println(field);
                }
                transactionList.add(fields);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getColumCount(){
        String[] firstRow = new String[0];
        try {
            firstRow = br.readLine().split(fieldDelimiter, -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return firstRow.length;
    }



    public ArrayList<String[]> getTransactionList() {
        return transactionList;
    }

}
