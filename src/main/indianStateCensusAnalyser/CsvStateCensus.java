package main.indianStateCensusAnalyser;

public class CsvStateCensus extends Exception
{
    enum ExceptionType
    {
        CENSUS_FILE_PROBLEM,UNABLE_TO_PARSE;

        //public enum UNABLE_TO_PARSE {}
    }
    ExceptionType type;

    public CsvStateCensus(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public CsvStateCensus(String message, ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}