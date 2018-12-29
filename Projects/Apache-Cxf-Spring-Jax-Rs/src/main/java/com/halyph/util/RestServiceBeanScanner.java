package com.halyph.util;

import com.halyph.util.annotation.RestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.ArrayList;
import java.util.List;

public final class RestServiceBeanScanner {

    private RestServiceBeanScanner() { }

    public static List<Object> scan(ApplicationContext applicationContext, String... basePackages) {
        GenericApplicationContext genericAppContext = new GenericApplicationContext();
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(genericAppContext, false);

        scanner.addIncludeFilter(new AnnotationTypeFilter(RestService.class));
        scanner.scan(basePackages);
        genericAppContext.setParent(applicationContext);
        genericAppContext.refresh();

        List<Object> restResources = new ArrayList<>(genericAppContext.getBeansWithAnnotation(RestService.class).values());

        return restResources;
    }

}
