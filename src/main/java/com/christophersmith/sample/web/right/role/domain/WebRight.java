package com.christophersmith.sample.web.right.role.domain;

/**
 * WebRight contains information about a Right, or permission, that is used on the web site.
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

    /**
     * Default constructor.
     */
    public WebRight()
    {
        super();
    }

    /**
     * The database assigned identifier.
     * <p>
     * This value will be unique.
     * 
     * @return
     */
    public long getIdentifier()
    {
        return identifier;
    }

    /**
     * Sets this instance's identifier.
     * 
     * @param identifier
     */
    public void setIdentifier(long identifier)
    {
        this.identifier = identifier;
    }

    /**
     * Returns the unique code for this instance.
     * 
     * @return
     */
    public String getCode()
    {
        return code;
    }

    /**
     * Sets the code for this instance.
     * 
     * @param code
     */
    public void setCode(String code)
    {
        this.code = code;
    }

    /**
     * Returns whether this instance is active.
     * <p>
     * A {@code false} value indicates that this instance should be considered as deleted.
     * 
     * @return
     */
    public boolean isActive()
    {
        return active;
    }

    /**
     * Sets whether this instance should be active.
     * 
     * @param active
     */
    public void setActive(boolean active)
    {
        this.active = active;
    }

    /**
     * Returns whether this instance is a menu option within a Web Section.
     * 
     * @return
     */
    public boolean isMenuOption()
    {
        return menuOption;
    }

    /**
     * Sets whether this instance is a menu option.
     * 
     * @param menuOption
     */
    public void setMenuOption(boolean menuOption)
    {
        this.menuOption = menuOption;
    }

    /**
     * Returns the associated {@link WebSection} identifier.
     * 
     * @return
     */
    public int getWebSectionIdentifier()
    {
        return webSectionIdentifier;
    }

    /**
     * Sets the {@link WebSection} identifier for this instance.
     * 
     * @param webSectionIdentifier
     */
    public void setWebSectionIdentifier(int webSectionIdentifier)
    {
        this.webSectionIdentifier = webSectionIdentifier;
    }

    /**
     * Returns the display order for this instance.
     * 
     * @return
     */
    public int getOrder()
    {
        return order;
    }

    /**
     * Sets the display order for this instance.
     * 
     * @param order
     */
    public void setOrder(int order)
    {
        this.order = order;
    }

    /**
     * Returns a relative URI that this instance should be mapped to.
     * 
     * @return
     */
    public String getPageUri()
    {
        return pageUri;
    }

    /**
     * Sets the relative URI that this instance should be mapped to.
     * 
     * @param pageUri
     */
    public void setPageUri(String pageUri)
    {
        this.pageUri = pageUri;
    }
}
