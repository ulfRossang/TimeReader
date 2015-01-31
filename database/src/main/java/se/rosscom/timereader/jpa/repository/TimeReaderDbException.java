package se.rosscom.timereader.jpa.repository;

public class TimeReaderDbException extends Exception {

    public TimeReaderDbException(String message, Exception e) {
        super(message, e);
    }

    public TimeReaderDbException(String message) {
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
