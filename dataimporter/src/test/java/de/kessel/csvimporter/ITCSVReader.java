package de.kessel.csvimporter;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ITCSVReader {

    private CSVReader csvReader;

    @Before
    public void setUp(){
        csvReader = new CSVReader();
    }

    @Test
    public void readingOfCVSFile() {
       csvReader.setFieldDelimiter(",");
       csvReader.setData("src/test/resources/test.csv");
       assertEquals("Colum count should be 6", 6, csvReader.getColumCount());
    }
}
