package ch.swisshimmel.website.base.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import core.framework.web.exception.ResourceNotFoundException;
import core.framework.web.exception.UserAuthorizationException;

@ControllerAdvice
public class SpringControllerAdvice {

    @ExceptionHandler(UserAuthorizationException.class)
    public ModelAndView unauthorized(UserAuthorizationException e) {
        Map<String, Throwable> map = new HashMap<String, Throwable>();
        map.put("authorizationException", e);
        return new ModelAndView("default-403", map);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ModelAndView notFound(ResourceNotFoundException e) {
        Map<String, Throwable> map = new HashMap<String, Throwable>();
        map.put("exception", e);
        return new ModelAndView("default-404", map);
    }

    @ExceptionHandler
    public ModelAndView resolveException(Throwable e, HttpServletResponse response) {
        Map<String, Throwable> map = new HashMap<String, Throwable>();
        map.put("exception", e);
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ModelAndView("default-error", map);
    }

}
