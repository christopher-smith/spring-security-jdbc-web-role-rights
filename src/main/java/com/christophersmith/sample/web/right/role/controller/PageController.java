package com.christophersmith.sample.web.right.role.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Christopher Smith (https://github.com/christopher-smith)
 */
@Controller
public class PageController
{
    private static final String VIEW_INDEX = "index";

    @RequestMapping("/")
    public String getIndexPage()
    {
        return VIEW_INDEX;
    }
}
