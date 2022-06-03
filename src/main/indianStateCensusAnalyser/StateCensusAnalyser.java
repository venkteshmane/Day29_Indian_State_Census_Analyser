package main.indianStateCensusAnalyser;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import indianstatecensusAnalyser.CsvException;
import indianstatecensusAnalyser.StateCensusAnalyser;

public class StateCensusAnalyserTest {

	/**
	 * This test case pass when a file with 4rows is read.
	 */
	@Test
	public void givenCsvFile_with8rowscomparingwith8_returnstrue() {
		try {
			StateCensusAnalyser analyser = new StateCensusAnalyser(
					"C:\\Users\\user\\Desktop\\LFP_Batch\\Day29_IndianstatecensusAnalyser\\data\\Data3.csv");
			Assert.assertEquals(4, analyser.readStateRecord());
		} catch (CsvException e) {
			System.out.println(e);
		}
	}

	/*
	 * given csv file that doesn't exist
	 */
	@Test
	public void givenCsvFile_whichIsIncorrect_Exception() {
		try {
			StateCensusAnalyser analyser = new StateCensusAnalyser(
					"C:\\Users\\user\\Desktop\\LFP_Batch\\Day29_IndianstatecensusAnalyser\\data\\Data4.csv");
			analyser.readStateRecord();
		} catch (CsvException e) {
			Assert.assertEquals("File not found", e.getMessage());
			System.out.println(e);
		}

	}

	/*
	 * given csv file other .csv format
	 */
	@Test
	public void givenCsvFile_whichIsWrongType_returnsFalse() {
		try {
			StateCensusAnalyser analyser = new StateCensusAnalyser(
					"C:\\Users\\user\\Desktop\\LFP_Batch\\Day29_IndianstatecensusAnalyser\\data\\Data.txt");
			analyser.readStateRecord();
		} catch (CsvException e) {
			Assert.assertEquals("Wrong Type", e.getMessage());
			System.out.println(e);
		}
	}

	/*
	 * given csv file with wrong delimiter
	 */
	@Test
	public void givenCsvFile_withwrongdelimiter_returnsFalse() {
		try {
			StateCensusAnalyser analyser = new StateCensusAnalyser(
					"C:\\Users\\user\\Desktop\\LFP_Batch\\Day29_IndianstatecensusAnalyser\\data\\Data2.csv");
			analyser.readStateRecord();
		} catch (CsvException e) {

			System.out.println(e);
			Assert.assertEquals("Wrong Delimiter", e.getMessage());
		}
	}

	/*
	 * given csv file with wrong header
	 */
	@Test
	public void givenCsvFile_withwrongdHeader_returnsFalse() {
		try {
			StateCensusAnalyser analyser = new StateCensusAnalyser(
					"C:\\Users\\user\\Desktop\\LFP_Batch\\Day29_IndianstatecensusAnalyser\\data\\Data1.csv");
			analyser.readStateRecord();
		} catch (CsvException e) {

			System.out.println(e);
			Assert.assertEquals("Header doesn't match", e.getMessage());
		}
	}

}