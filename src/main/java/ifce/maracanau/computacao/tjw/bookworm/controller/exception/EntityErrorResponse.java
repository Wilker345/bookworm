package ifce.maracanau.computacao.tjw.bookworm.controller.exception;

import java.util.Date;

public class EntityErrorResponse {
    private final String entityName;
    private final Date timestamp;
    private final String message;

    public EntityErrorResponse(String entityName, Date timestamp, String message) {
        this.entityName = entityName;
        this.timestamp = timestamp;
        this.message = message;
    }

    public String getEntityName() {
        return entityName;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }
}
