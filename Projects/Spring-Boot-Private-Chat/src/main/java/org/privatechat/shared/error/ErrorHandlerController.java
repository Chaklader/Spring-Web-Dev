package org.privatechat.shared.error;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.privatechat.shared.exceptions.ValidationException;
import org.privatechat.shared.http.JSONResponseHelper;
import org.privatechat.shared.interfaces.IErrorHandlerController;
import org.privatechat.user.exceptions.IsSameUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ErrorHandlerController implements IErrorHandlerController {
  @RequestMapping(value="/error", method=RequestMethod.GET, produces="text/html")
  @ResponseBody
  public ResponseEntity<String> error() {
    return new ResponseEntity<String>(routeToIndexFallBack(), HttpStatus.NOT_FOUND);
  }

  private String routeToIndexFallBack() {
    Scanner scanner;
    StringBuilder result = new StringBuilder("");
    ClassLoader classLoader = getClass().getClassLoader();

    try {
      scanner = new Scanner(new File(classLoader.getResource("static/index.html").getFile()));

      while (scanner.hasNextLine()) {
        String curLine = scanner.nextLine();
        result.append(curLine).append("\n");
      }

      scanner.close();
      return result.toString();
    } catch (FileNotFoundException e) {
      return "Not found.";
    }
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> exception(Exception exception) {
    if (isExceptionInWhiteList(exception)) {
      return JSONResponseHelper.createResponse(
        exception.getMessage(),
        HttpStatus.INTERNAL_SERVER_ERROR
      );
    }

    return JSONResponseHelper.createResponse(
      "Error. Contact your administrator",
      HttpStatus.INTERNAL_SERVER_ERROR
    );  
  }

  // There's no way to iterate over exceptions with the 'instanceof' operator
  private Boolean isExceptionInWhiteList(Exception exception) {
    if (exception instanceof IsSameUserException) return true;
    if (exception instanceof ValidationException) return true;
    // TODO: if (exception instanceof UserNotFoundException) return true;

    return false;
  }
}