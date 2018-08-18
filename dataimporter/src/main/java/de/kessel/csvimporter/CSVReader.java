package de.kessel.csvimporter;

import de.kessel.Importer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

// TODO add javadoc
public class CSVReader implements Importer {

    private String fieldDelimiter = ";";
    private boolean withHeader;
    private ArrayList<String[]> transactionList = new ArrayList<>();


    // TODO add javadoc
    public CSVReader() {
        // TODO add logger
        Logger.getLogger(CSVReader.class.getName()).log(Level.INFO, "CSVReader constructor");
    }

    // TODO add javadoc
    public void setFieldDelimiter(String fieldDelimiter){
        this.fieldDelimiter = fieldDelimiter;
    }

    // TODO add javadoc
    public void setWithHeader(boolean withHeader){
        this.withHeader = withHeader;
    }

    @Override
    public void setData(String dataRoot){
        ArrayList<String> transactions = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(dataRoot))) {
            stream.forEach(transactions::add);
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (UncheckedIOException e2){
            // TODO logger
            System.out.println("=== ");
        }
        setRowsAndColum(transactions);
    }

    @Override
    public void setRowsAndColum(ArrayList<String> transactions){
        // TODO java8 functional
        for(String transaction: transactions){
            String[] fields = transaction.split(fieldDelimiter, -1);
            transactionList.add(fields);
        }
    }

    @Override
    public int getColumCount(){
        return transactionList.get(0).length;
    }

    @Override
    public ArrayList<String[]> getTransactionList() {
        return transactionList;
    }

}
