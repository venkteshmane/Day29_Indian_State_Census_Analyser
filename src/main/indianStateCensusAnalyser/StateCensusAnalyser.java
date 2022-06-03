package main.indianStateCensusAnalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyser {
	private String CSV_FILE_PATH = "";

	public StateCensusAnalyser() {

	}

	public StateCensusAnalyser(String SAMPLE_CSV_FILE_PATH) {
		this.CSV_FILE_PATH = SAMPLE_CSV_FILE_PATH;
	}

	/**
	 * @return the number of data read from the csv file
	 * 
	 */
	public int readStateRecord() throws CsvException {
		int count = 0;
		try {
			Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
			@SuppressWarnings("unchecked")
			CsvToBean<CsvStateCensus> csvToBean = new CsvToBeanBuilder(reader).withType(CsvStateCensus.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			Iterator<CsvStateCensus> csvUserIterator = csvToBean.iterator();
			while (csvUserIterator.hasNext()) {
				CsvStateCensus state = csvUserIterator.next();
				count++;

				if (state.getState() == null || state.getPopulation() == 0 || state.getAreaInSqKm() == 0) {
					throw new CsvException(CsvException.ExceptionType.INCORRECT_HEADER, "Header doesn't match");
				}
			}
		}

		catch (NoSuchFileException e) {
			if (CSV_FILE_PATH.contains(".csv")) {
				throw new CsvException(CsvException.ExceptionType.FILE_NOT_FOUND, "File not found");
			}
			throw new CsvException(CsvException.ExceptionType.INCORRECT_TYPE, "Wrong Type");

		} catch (RuntimeException e) {

			throw new CsvException(CsvException.ExceptionType.DELEMETER_NOT_FOUND, "Wrong Delimiter");
		} catch (IOException e) {
			System.out.println(e);
		}

		return count;
	}
}