package se.rosscom.timereader.exception;

public class ReaderMessageException extends TimeReaderException {

    public ReaderMessageException(String message) {
        super(message);
    }

    public ReaderMessageException(String message, Exception e) {
        super(message, e);
    }
}
