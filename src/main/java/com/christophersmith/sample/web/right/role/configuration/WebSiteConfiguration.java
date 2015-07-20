package com.christophersmith.sample.web.right.role.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import nz.net.ultraq.thymeleaf.LayoutDialect;

/**
 * 
 * @author Christopher Smith (https://github.com/christopher-smith)
 */
@Configuration
@ComponentScan({
    "com.christophersmith.sample.web.right.role"})
@EnableTransactionManagement
@EnableWebMvc
public class WebSiteConfiguration extends WebMvcConfigurerAdapter
{
    private static final String RESOURCE_HANDLER_URI_PATH        = "/assets/**";
    private static final String RESOURCE_HANDLER_LOCATION_PATH   = "/assets/";
    private static final String THYMELEAF_RESOLVER_PREFIX        = "/WEB-INF/templates/";
    private static final String THYMELEAF_RESOLVER_SUFFIX        = ".html";
    private static final String THYMELEAF_RESOLVER_TEMPLATE_MODE = "HTML5";
    private static final String CHARACTER_ENCODING_UTF8          = "UTF-8";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler(RESOURCE_HANDLER_URI_PATH)
            .addResourceLocations(RESOURCE_HANDLER_LOCATION_PATH);
    }

    /**
     * 
     * @return
     */
    @Bean
    @Description("Thymeleaf template resolver serving HTML 5")
    public ServletContextTemplateResolver templateResolver()
    {
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
        templateResolver.setPrefix(THYMELEAF_RESOLVER_PREFIX);
        templateResolver.setSuffix(THYMELEAF_RESOLVER_SUFFIX);
        templateResolver.setTemplateMode(THYMELEAF_RESOLVER_TEMPLATE_MODE);
        templateResolver.setCharacterEncoding(CHARACTER_ENCODING_UTF8);
        return templateResolver;
    }

    /**
     * 
     * @return
     */
    @Bean
    @Description("Thymeleaf template engine with Spring integration")
    public SpringTemplateEngine templateEngine()
    {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.addDialect(new LayoutDialect());
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    /**
     * 
     * @return
     */
    @Bean
    @Description("Thymeleaf view resolver")
    public ThymeleafViewResolver viewResolver()
    {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding(CHARACTER_ENCODING_UTF8);
        return viewResolver;
    }

    /**
     * 
     * @return
     */
    @Bean(destroyMethod = "shutdown")
    public DataSource h2SqlDataSource()
    {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
            .addScript("ddl/h2sql-schema.sql").build();
    }

    /**
     * 
     * @return
     */
    @Bean
    @Qualifier("h2SqlJdbcTemplate")
    public JdbcTemplate h2SqlJdbcTemplate()
    {
        return new JdbcTemplate(h2SqlDataSource());
    }
}
