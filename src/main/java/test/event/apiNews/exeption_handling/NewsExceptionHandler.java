package test.event.apiNews.exeption_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NewsExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<NewsIncorrectData> handelException(NoSuchNewsException exception) {
        NewsIncorrectData data = new NewsIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<NewsIncorrectData> handelException(Exception exception) {
        NewsIncorrectData data = new NewsIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

}
