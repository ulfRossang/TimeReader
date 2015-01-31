package se.rosscom.timereader.exception;

public class TimeReaderServiceException extends Exception {

    public TimeReaderServiceException(String message, Exception e) {
        super(message, e);
    }

    public TimeReaderServiceException(String message) {
        super(message);
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(super.toString());
        if (getCause() != null && !getCause().equals(this)) {
            s.append("\nCaused by: ");
            s.append(getCause().toString());
        }
        return s.toString();
    }

}
