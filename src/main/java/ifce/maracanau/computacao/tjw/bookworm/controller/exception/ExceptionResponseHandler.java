package ifce.maracanau.computacao.tjw.bookworm.controller.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionResponseHandler {
    @ExceptionHandler
    public ResponseEntity<EntityErrorResponse> tupleNotFoundResponse(TupleNotFoundException exception) {
        EntityErrorResponse error = new EntityErrorResponse(exception.getEntity(), exception.getTimestamp(),
                exception.getMessage());
        return new ResponseEntity<>(error, HttpStatusCode.valueOf(404));
    }

}
