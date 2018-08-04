package bg.games.waroffame.controller;/*
package bg.games.waroffame.controller;

import bg.games.lostheavenapi.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
@RestController
public class CustomExceptionAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity handleConflict(MethodArgumentNotValidException e, HttpServletResponse response) throws IOException {
        return new ResponseEntity("errr", HttpStatus.BAD_REQUEST);
    }
}*/
