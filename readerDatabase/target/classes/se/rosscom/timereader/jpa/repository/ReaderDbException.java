package se.rosscom.timereader.jpa.repository;


public class ReaderDbException extends TimeReaderDbException {

    public ReaderDbException(String message) {
        super(message);
    }

    public ReaderDbException(String message, Exception e) {
        super(message, e);
    }
}
