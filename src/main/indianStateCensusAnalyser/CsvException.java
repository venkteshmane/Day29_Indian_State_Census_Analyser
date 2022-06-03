package main.indianStateCensusAnalyser;

public class CsvException extends Exception{
	
	public enum ExceptionType {
        FILE_NOT_FOUND,INCORRECT_TYPE,DELEMETER_NOT_FOUND,INCORRECT_HEADER,BINDING_BROBLEM_AT_RUNTIME
    }
	
	 public ExceptionType type;
	 public CsvException(ExceptionType type, String message) {
	        super(message);
	        this.type = type;
	    }
	 
	 public CsvException(ExceptionType type) {
	        this.type = type;
	    }
}