package de.kessel.csvimporter;

import de.kessel.Importer;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * CVReader class reads an imported csv file.
 */
public class CSVReader implements Importer {

    private final static Logger logger = Logger.getLogger(CSVReader.class);

    private String fieldDelimiter = ";";
    private boolean withHeader;
    private ArrayList<String[]> transactionList = new ArrayList<>();


    public CSVReader() {
        if(logger.isDebugEnabled()){
            logger.debug("Constructor");
        }
    }

    /**
     * Setter for the field delimiter.
     *
     * @param fieldDelimiter
     */
    public void setFieldDelimiter(String fieldDelimiter){
        this.fieldDelimiter = fieldDelimiter;
    }

    /**
     * Set a boolean for the header. If csv has headers
     * then set true.
     *
     * @param withHeader
     */
    public void setWithHeader(boolean withHeader){
        this.withHeader = withHeader;
    }

    @Override
    public void setData(String dataLocation){

        List<String> transactions = new ArrayList<>();
        BufferedReader br;
        String line = "";
        try{
            br = new BufferedReader(new FileReader(dataLocation));
            while((line = br.readLine()) != null){
                transactions.add(line);
            }
        } catch (IOException e) {
            if(logger.isDebugEnabled()){
                logger.debug("CSV parsing problem!");
            }
            e.printStackTrace();
        }
        setRowsAndColum(transactions);
    }

    @Override
    public void setRowsAndColum(List<String> transactions){
        for(String transaction: transactions){
            String[] fields = transaction.split(fieldDelimiter, -1);
            transactionList.add(fields);
        }
    }

    @Override
    public int getColumCount(){
        return transactionList.get(0).length;
    }

    /**
     * This method returns each line as a list.
     *
     * @return
     */
    public List<String[]> getLineList() {
        return transactionList;
    }

}
