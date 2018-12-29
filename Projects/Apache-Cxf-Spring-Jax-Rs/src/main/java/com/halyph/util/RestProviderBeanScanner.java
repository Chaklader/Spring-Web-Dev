package com.halyph.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import javax.ws.rs.ext.Provider;
import java.util.ArrayList;
import java.util.List;

public final class RestProviderBeanScanner {

    private RestProviderBeanScanner() { }
    public static List<Object> scan(ApplicationContext applicationContext, String... basePackages) {
        GenericApplicationContext genericAppContext = new GenericApplicationContext();
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(genericAppContext, false);

        scanner.addIncludeFilter(new AnnotationTypeFilter(Provider.class));
        scanner.scan(basePackages);
        genericAppContext.setParent(applicationContext);
        genericAppContext.refresh();

        return new ArrayList<>(genericAppContext.getBeansWithAnnotation(Provider.class).values());
    }
}
