package com.christophersmith.sample.web.right.role.domain;

/**
 * 
 * @author Christopher Smith (https://github.com/christopher-smith)
 */
public class WebSection
{
    private int    identifier;
    private String code;
    private int    order;

    /**
     * Default constructor.
     */
    public WebSection()
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
    public int getIdentifier()
    {
        return identifier;
    }

    /**
     * Sets this instance's identifier.
     * 
     * @param identifier
     */
    public void setIdentifier(int identifier)
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

    public void setCode(String code)
    {
        this.code = code;
    }

    /**
     * Returns the
     * 
     * @return
     */
    public int getOrder()
    {
        return order;
    }

    public void setOrder(int order)
    {
        this.order = order;
    }
}
