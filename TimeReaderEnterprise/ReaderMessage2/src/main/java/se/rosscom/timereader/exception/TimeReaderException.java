package se.rosscom.timereader.exception;

public class TimeReaderException extends Exception {

    public TimeReaderException(String message, Exception e) {
        super(message, e);
    }

    public TimeReaderException(String message) {
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
