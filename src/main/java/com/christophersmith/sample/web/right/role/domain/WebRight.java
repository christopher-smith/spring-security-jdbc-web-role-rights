package com.christophersmith.sample.web.right.role.domain;

/**
 * 
 * @author Christopher Smith (https://github.com/christopher-smith)
 */
public class WebRight
{
    private long    identifier;
    private String  code;
    private boolean active;
    private boolean menuOption;
    private int     webSectionIdentifier;
    private int     order;
    private String  pageUri;

    public WebRight()
    {
        super();
    }

    public long getIdentifier()
    {
        return identifier;
    }

    public void setIdentifier(long identifier)
    {
        this.identifier = identifier;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public boolean isMenuOption()
    {
        return menuOption;
    }

    public void setMenuOption(boolean menuOption)
    {
        this.menuOption = menuOption;
    }

    public int getWebSectionIdentifier()
    {
        return webSectionIdentifier;
    }

    public void setWebSectionIdentifier(int webSectionIdentifier)
    {
        this.webSectionIdentifier = webSectionIdentifier;
    }

    public int getOrder()
    {
        return order;
    }

    public void setOrder(int order)
    {
        this.order = order;
    }

    public String getPageUri()
    {
        return pageUri;
    }

    public void setPageUri(String pageUri)
    {
        this.pageUri = pageUri;
    }
}
