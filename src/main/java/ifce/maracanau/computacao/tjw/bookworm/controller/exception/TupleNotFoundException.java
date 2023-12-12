package ifce.maracanau.computacao.tjw.bookworm.controller.exception;

import java.util.Date;

public class TupleNotFoundException extends RuntimeException {
    private final String entityName;
    private final Date timestamp;

    public TupleNotFoundException(String entityName, String message) {
        super(message);
        timestamp = new Date();
        this.entityName = entityName;
    }

    public TupleNotFoundException(String entityName, String message, Throwable cause) {
        super(message, cause);
        timestamp = new Date();
        this.entityName = entityName;
    }

    public TupleNotFoundException(String entityName, Throwable cause) {
        super(cause);
        timestamp = new Date();
        this.entityName = entityName;
    }

    public String getEntity() {
        return entityName;
    }
    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "TupleNotFoundException{" +
                "entityName='" + entityName + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
