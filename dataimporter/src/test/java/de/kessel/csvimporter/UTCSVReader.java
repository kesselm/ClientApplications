package de.kessel.csvimporter;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class UTCSVReader {

    private CSVReader csvReader;

    @Before
    public void setUp() {
        csvReader = new CSVReader();
    }

    @Test
    public void columCount (){
        csvReader.setFieldDelimiter(",");
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList("2018-08-18, My Test 1", "2018-08-18, My Test 2"));
        csvReader.setRowsAndColum(stringList);
        assertEquals("The colum count should be 2", 2, csvReader.getColumCount());
    }

    @Test
    public void delimiterSemikolon(){
        csvReader.setFieldDelimiter(";");
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList("2018-08-18; My Test 1", "2018-08-18; My Test 2"));
        csvReader.setRowsAndColum(stringList);
        assertEquals("The colum count should be 2", 2, csvReader.getColumCount());

    }

    @Test
    public void wrongDelimiter() {
        csvReader.setFieldDelimiter(",");
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList("2018-08-18; My Test 1", "2018-08-18; My Test 2"));
        csvReader.setRowsAndColum(stringList);
        assertEquals("The colum count should be 1", 1, csvReader.getColumCount());
    }

    @Test
    public void germanNumberFormat() {
        csvReader.setFieldDelimiter(",");
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList("2018-08-18, My Test 1", "2018-08-18, \"3,4\" "));
        csvReader.setRowsAndColum(stringList);
        assertEquals("The colum count should be 2", 2, csvReader.getColumCount());
    }

    @Test
    public void noPath(){
        csvReader.setData("");
    }

}