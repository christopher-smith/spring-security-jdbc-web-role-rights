package com.christophersmith.sample.web.right.role.repository.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * An annotation used for easier access to the H2 SQL database {@link JdbcTemplate}.
 * <p>
 * Using this annotation is preferred over using the {@code @Qualifier} annotation for
 * {@link JdbcTemplate} IoC.
 * 
 * @author Christopher Smith (https://github.com/christopher-smith)
 */
@Target({
    ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Autowired
@Qualifier("h2SqlJdbcTemplate")
public @interface H2SqlJdbcTemplate
{

}
