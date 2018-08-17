package de.kessel.apache.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class BasicCSVReader {

    private String path;
    private CSVParser csvParser;

    public BasicCSVReader(String path){
        this.path = path;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(this.path));
            //CSVFormat csvFormat = CSVFormat.DEFAULT.withDelimiter(';');
            //csvParser = csvFormat.parse(reader);
            csvParser = new CSVParser(reader, CSVFormat.EXCEL.withRecordSeparator(";"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CSVParser getCsvParser(){
        return csvParser;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static void showTransactions() throws IOException {
        BasicCSVReader csvReader = new BasicCSVReader("/home/sifu/Downloads/test2.csv");
        List<CSVRecord> csvRecords = csvReader.getCsvParser().getRecords();

        for (CSVRecord csvRecord : csvRecords) {
            String buchung = csvRecord.get(0);
            String valuta = csvRecord.get(1);
            String auftraggeber = csvRecord.get(2);
            String buchungstext = csvRecord.get(3);
            String verwendungszweck = csvRecord.get(4);
            String saldo = csvRecord.get(5);
            String betrag = csvRecord.get(6);
            String waehrung = csvRecord.get(7);

            System.out.println("Buchung: " + buchung + ", Valuta: "+ valuta+ ", Auftraggeber: " + auftraggeber
                    +", Buchungstext: " + buchungstext+", Verwendungszweck: " + verwendungszweck + ", saldo: "
                    + saldo + ", Betrag: " + betrag + ", Währung: " + waehrung);
        }
    }

    public static void main(String[] args) throws IOException {
        showTransactions();
    }


}
