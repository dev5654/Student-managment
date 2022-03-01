package uz.aktamov.sudentmenegment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice("uz.aktamov.studentmenegment")
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<AppError> invalidTokenExceptionHandler(RuntimeException e, WebRequest request) {
        return new ResponseEntity<>(AppError.builder()
                .message(e.getMessage())
                .request(request)
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
