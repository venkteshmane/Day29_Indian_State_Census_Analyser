package test.indianStateCensusAnalyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {

    private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String WRONG_TYPE_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.pdf";
    private static final String WRONG_DELIMITER_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusDataWrongDelimiter.csv";
    private static final String WRONG_HEADER_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusDataWrongHeader.csv";
    @Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords() {
        try {
            CsvException censusAnalyser = new CsvException();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            System.out.println(numOfRecords);
            Assert.assertEquals(29,numOfRecords);
        } catch (CsvStateCensus e)
        {
            System.out.println("Exception Occurs");
        }
    }

    @Test
    public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
        try {
            CsvException censusAnalyser = new CsvException();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CsvStateCensus.class);
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (CsvStateCensus e) {
            Assert.assertEquals(CsvStateCensus.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }
    @Test
    public void givenIndiaCensusData_WithWrongType_ShouldThrowException()
    {
        try {
            CsvException censusAnalyser = new CsvException();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CsvStateCensus.class);
            censusAnalyser.loadIndiaCensusData(WRONG_TYPE_CSV_FILE_PATH);
        } catch (CsvStateCensus e) {
            Assert.assertEquals(CsvStateCensus.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }
    @Test
    public void givenIndiaCensusData_WithWrongDelimiter_ShouldThrowException() {
        try {
            CsvException censusAnalyser = new CsvException();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CsvStateCensus.class);
            censusAnalyser.loadIndiaCensusData(WRONG_DELIMITER_CSV_FILE_PATH);
        } catch (CsvStateCensus e) {
            Assert.assertEquals(CsvStateCensus.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }
    @Test
    public void givenIndiaCensusData_WithWrongHeader_ShouldThrowException() {
        try {
            CsvException censusAnalyser = new CsvException();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CsvStateCensus.class);
            censusAnalyser.loadIndiaCensusData(WRONG_HEADER_CSV_FILE_PATH);
        } catch (CsvStateCensus e) {
            Assert.assertEquals(CsvStateCensus.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }
}