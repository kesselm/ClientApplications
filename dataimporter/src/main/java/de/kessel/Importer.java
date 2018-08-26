package de.kessel;

import java.util.List;

// TODO add javadoc
public interface Importer {

    /**
     * This method is creating the colums and rows
     * from a data source.
     *
     * @param transactions
     */
    void setRowsAndColum(List<String> transactions);

    /**
     * This method returns the count of colums of a data source.
     *
     * @return colum count.
     */
    int getColumCount();


    /**
     * This method gives the path of the input data.
     *
     * @param dataRoot
     */
    void setData(String dataRoot);
}
