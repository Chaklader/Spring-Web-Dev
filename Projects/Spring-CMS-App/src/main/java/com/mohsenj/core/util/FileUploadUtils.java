package com.mohsenj.core.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadUtils {

	private static final String[] ALLOWED_FILE_TYPES = {"image/jpeg", "image/jpg", "image/gif"};
    private static final Long MAX_FILE_SIZE = 5048576L; //5MB
 //   private static String UPLOAD_FILE_PATH = "/opt/images/";
    
    public String process(MultipartFile file, String upload_file_path) {
        if (!file.isEmpty()) {
            String contentType = file.getContentType().toString().toLowerCase();
            if (isValidContentType(contentType)) {
                if (belowMaxFileSize(file.getSize())) {
                	
                	String randomStr = StringUtils.randomString(20).toLowerCase();
                	String extension =  getExtension(file.getOriginalFilename());	                	
                //    String newFileName = file.getOriginalFilename();//randomStr +"."+extension;
                    Path uploadDir = Paths.get(upload_file_path);
                  //  String newFile = UPLOAD_FILE_PATH + file.getOriginalFilename();
                    try {
                       // file.transferTo(new File(uploadDir.resolve(newFileName).toString()));
                        Files.copy(file.getInputStream(), uploadDir.resolve(randomStr+"."+extension));
                        System.out.println( "You have successfully uploaded " + file.getOriginalFilename() + "!");

                        return randomStr+"."+extension;
                    } catch (IllegalStateException e) {
                    	System.out.println( "There was an error uploadingg " + file.getOriginalFilename() + " => " + e.getMessage());
                    	return "";
                    } catch (IOException e) {
                    	System.out.println( "There was an error uploadingg " + file.getOriginalFilename() + " => " + e.getMessage());
                    	return "";
                    }
                } else {
                	System.out.println( "Error. " + file.getOriginalFilename() + " file size (" + file.getSize() + ") exceeds " + MAX_FILE_SIZE + " limit.");

                	return "";
                }
            } else {
            	System.out.println( "Error. " + contentType + " is not a valid content type.");

            	return "";
            }
        } else {
        	System.out.println("Error. No file choosen.");

        	return "";
        }
    }
    
    private Boolean isValidContentType(String contentType) {
       /* if (!Arrays.asList(ALLOWED_FILE_TYPES).contains(contentType)) {
            return false;
        }*/
        
        return true;
    }
    
    private Boolean belowMaxFileSize(Long fileSize) {
      /*  if (fileSize > MAX_FILE_SIZE) {
            return false;
        }
        */
        return true;
    }
    
    private String getExtension(String fileName) {
    	
		return fileName.substring(fileName.lastIndexOf(".") + 1);
    	
    }
}
