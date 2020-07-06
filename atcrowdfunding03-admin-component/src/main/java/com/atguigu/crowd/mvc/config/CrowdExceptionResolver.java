package com.atguigu.crowd.mvc.config;

import com.atguigu.crowd.util.ResultEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class CrowdExceptionResolver {

    @ExceptionHandler(value = NullPointerException.class)
    public void resolveNullpointerException(NullPointerException exception, HttpServletResponse response) throws IOException {
        commonResolve(exception,response);
    }

    @ExceptionHandler(value = ArithmeticException.class)
    public void resolveMathException(ArithmeticException exception,HttpServletResponse response) throws IOException {
        commonResolve(exception,response);
    }

    private void commonResolve(Exception e,HttpServletResponse response) throws IOException {
        ResultEntity<Object> resultEntity = ResultEntity.failed(e.getMessage());
        ObjectMapper objectMapper=new ObjectMapper();
        String json = objectMapper.writeValueAsString(resultEntity);
        response.getWriter().print(json);
    }
}
