package utils;

import groovy.util.logging.Slf4j;

@lombok.extern.slf4j.Slf4j
@Slf4j
public class ContextManeger {
    private static final ThreadLocal<TypeContext> currentContext = new ThreadLocal<>();

    public static void setCurrentContext(TypeContext context) {
        currentContext.set(context);
        log.info("Контекст установлен...");
    }

    public static TypeContext getContext() {
        if (currentContext.get() != null)
            log.info("Контекст получен...");
        return currentContext.get();
    }

    public static void clearContext() {
        currentContext.remove();
        log.info("Контекст очищен...");
    }
}
