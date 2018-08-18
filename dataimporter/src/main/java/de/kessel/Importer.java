package de.kessel;

import java.util.ArrayList;

// TODO add javadoc
public interface Importer {

    // TODO add javadoc
    void setRowsAndColum(ArrayList<String> transactions);

    // TODO add javadoc
    int getColumCount();

    // TODO add javadoc
    ArrayList<String[]> getTransactionList();

    // TODO add javadoc
    void setData(String dataRoot);
}
