package com.xxl.job.core.aot;

import org.springframework.aot.hint.ExecutableMode;
import org.springframework.aot.hint.ReflectionHints;
import org.springframework.aot.hint.annotation.ReflectiveProcessor;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

/**
 * XxlJobReflectiveProcessor
 *
 * @author Created by a483210 on 2023/3/13 22:41
 * @since 3.0.0
 */
public class XxlJobReflectiveProcessor implements ReflectiveProcessor {

    @Override
    public void registerReflectionHints(ReflectionHints hints, AnnotatedElement element) {
        if (element instanceof Method method) {
            hints.registerMethod(method, ExecutableMode.INVOKE);
        }
    }
}
