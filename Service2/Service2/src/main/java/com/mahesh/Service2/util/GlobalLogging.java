package com.mahesh.Service2.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Service
@Configuration
public class GlobalLogging {

    private static final Logger LOG = Logger.getLogger(GlobalLogging.class.getName());

    @Pointcut(value = "execution(* com.mahesh.Service2..*.*(..))")
    private void executionInService() {
        //do nothing, just for pointcut def
    }
    @Before(value = "executionInService()")
    public void pushStackInBean(JoinPoint joinPoint) {
        pushStack(joinPoint);
    }
    ObjectMapper mapper = new ObjectMapper();
    private void pushStack(JoinPoint joinPoint) {
        String methodName = StringUtils.replace(joinPoint.getSignature().toString(), "com.mahesh.Service2.", "");
        String input = getInputParametersString(joinPoint.getArgs());
        LOG.log(Level.INFO, methodName+"\t "+input);
    }
    private String getInputParametersString(Object[] joinPointArgs) {
        String input;
        try {
            input = mapper.writeValueAsString(joinPointArgs);
        } catch (Exception e) {
            input = "Unable to create input parameters string. Error:" + e.getMessage();
        }
        return input;
    }

}

