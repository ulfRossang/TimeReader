package se.rosscom.timereader.exception;

public class ReaderServiceException extends TimeReaderServiceException {

    public ReaderServiceException(String message) {
        super(message);
    }

    public ReaderServiceException(String message, Exception e) {
        super(message, e);
    }
}
