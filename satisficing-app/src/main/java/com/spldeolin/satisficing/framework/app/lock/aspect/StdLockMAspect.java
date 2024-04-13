package com.spldeolin.satisficing.framework.app.lock.aspect;

import java.lang.reflect.Method;
import org.apache.commons.lang3.mutable.MutableObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import com.google.common.base.MoreObjects;
import com.spldeolin.satisficing.framework.app.lock.StdLock;
import com.spldeolin.satisficing.framework.app.lock.annotation.StdLockM;
import lombok.extern.slf4j.Slf4j;

/**
 * 配合{@link StdLockM}使用的切面
 *
 * @author Deolin 2021-12-12
 */
@Component
@Aspect
@Slf4j
public class StdLockMAspect {


    private static final DefaultParameterNameDiscoverer parameterNameDiscoverer = new DefaultParameterNameDiscoverer();

    private static final ExpressionParser expressionParser = new SpelExpressionParser();

    @Autowired
    private StdLock stdLock;

    @Pointcut("@annotation(com.spldeolin.satisficing.framework.app.lock.annotation.StdLockM)")
    public void cut() {
    }

    @Around(value = "cut() && @annotation(stdLockM)")
    public Object around(ProceedingJoinPoint pjp, StdLockM stdLockM) throws Throwable {
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        String[] paramNames = MoreObjects.firstNonNull(parameterNameDiscoverer.getParameterNames(method),
                new String[0]);
        Object[] args = pjp.getArgs();

        // build lock key
        EvaluationContext context = new StandardEvaluationContext();
        for (int i = 0; i < paramNames.length; i++) {
            context.setVariable(paramNames[i], args[i]);
        }
        Expression expression = expressionParser.parseExpression(stdLockM.key());
        String key = expression.getValue(context, String.class);

        // invoke with using StdLock
        MutableObject<Object> result = new MutableObject<>();
        MutableObject<Throwable> t = new MutableObject<>();
        stdLock.dSync(() -> {
            try {
                result.setValue(pjp.proceed());
            } catch (Throwable throwable) {
                t.setValue(throwable);
            }
        }, key, stdLockM.waitSeconds());

        // exit
        if (t.getValue() != null) {
            throw t.getValue();
        } else {
            return result.getValue();
        }
    }

}