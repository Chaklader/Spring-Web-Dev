package org.privatechat.shared.http;

import com.google.gson.GsonBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class JSONResponseHelper {
  public static <T> ResponseEntity<String> createResponse(T responseObj, HttpStatus stat) {
    return new ResponseEntity<String>(
      new GsonBuilder()
        .disableHtmlEscaping()
        .create()
        .toJson(responseObj)
        .toString(),
      stat
    );
  }
}