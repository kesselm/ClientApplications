package de.kessel.Banking;

import de.kessel.apache.csv.CSVReader;
import de.kessel.entities.Transaction;
import de.kessel.services.TransactionService;
import javafx.stage.FileChooser;
import javafx.stage.Stage;;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BankingController {

    public void openFileChooser() throws IOException {
        Logger.getLogger(CSVReader.class.getName()).log(Level.INFO, "BankingController.openFileChooser()");
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)","*.csv");
        fileChooser.getExtensionFilters().add(extFilter);
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile != null) {
            CSVReader csvReader = new CSVReader(selectedFile.getPath(), ";", true);
            ArrayList<String[]> transactionList = csvReader.getTransactionList();
            for(String[] transaction : transactionList){
                TransactionService transactionService = new TransactionService();
                Date date = null;
                try {
                    date = new SimpleDateFormat("dd.MM.yyyy").parse(transaction[0]);
                } catch (ParseException e) {
                   e.printStackTrace();
                }

                DecimalFormat df = (DecimalFormat) NumberFormat.getInstance(Locale.GERMAN);

                BigDecimal saldo = new BigDecimal(transaction[4].replace(',','.'));
                BigDecimal betrag = new BigDecimal(transaction[5].replace(',','.'));

                Transaction trans= new Transaction(date, transaction[1],transaction[2], transaction[3], saldo , betrag, transaction[6]);
                Logger.getLogger(CSVReader.class.getName()).log(Level.INFO, "Transaction persist");
                transactionService.persist(trans);

            }

        }
    }
}
