package com.christophersmith.sample.web.right.role.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import nz.net.ultraq.thymeleaf.LayoutDialect;

/**
 * WebSiteConfiguration is Spring JavaConfig class that configures this web site.
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

    /**
     * Adds the /assets/ URI to the {@link ResourceHandlerRegistry} for this site for static
     * content.
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler(RESOURCE_HANDLER_URI_PATH)
            .addResourceLocations(RESOURCE_HANDLER_LOCATION_PATH);
    }

    /**
     * Returns a {@link ServletContextTemplateResolver} for Thymeleaf templates.
     * <p>
     * This is configured to look for templates in the /WEB-INF/templates/ directory with a suffix
     * of {@code .html} and a mode of HTML5. Character encoding is also set to UTF-8.
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
     * Returns a {@link SpringTemplateEngine} configured with a {@link LayoutDialect} dialect and
     * sets the {@link ThymeleafViewResolver}.
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
     * Returns a {@link ThymeleafViewResolver} with a character encoding of UTF-8.
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
     * Returns a {@link DataSource} for the H2 SQL database.
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
     * Returns a {@link PlatformTransactionManager} for the H2 SQL database.
     * 
     * @return
     */
    @Bean
    @Qualifier("h2SqlDataSourceTransactionManager")
    public PlatformTransactionManager h2SqlDataSourceTransactionManager()
    {
        return new DataSourceTransactionManager(h2SqlDataSource());
    }

    /**
     * Returns a {@link JdbcTemplate} for the H2 SQL database.
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
