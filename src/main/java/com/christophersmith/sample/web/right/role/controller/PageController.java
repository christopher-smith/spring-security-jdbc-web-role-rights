package com.christophersmith.sample.web.right.role.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController
{
    @RequestMapping("/")
    public String getIndexPage()
    {
        return "index";
    }
}
