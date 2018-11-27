package com.spring.demo.error;

import org.springframework.boot.web.servlet.error.ErrorController;

public class MyErrorController implements ErrorController {

    @Override
    public String getErrorPath() {
        return null;
    }


}
