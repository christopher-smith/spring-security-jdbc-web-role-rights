package com.christophersmith.sample.web.right.role.domain;

import org.joda.time.DateTime;

/**
 * WebUserRole contains information about Web User Roles used by the system.
 * <p>
 * A Web User Role is assigned to one or more {@link WebRight} objects for easier management of
 * permissions to various functions and views of the web site.
 * 
 * @author Christopher Smith (https://github.com/christopher-smith)
 */
public class WebUserRole
{
    private long     identifier;
    private String   name;
    private boolean  active;
    private String   insertedBy;
    private DateTime insertedDateTime;
    private String   updatedBy;
    private DateTime updatedDateTime;

    /**
     * Default constructor.
     */
    public WebUserRole()
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
     * Returns the name used to uniquely identify this instance.
     * <p>
     * The {@code name} is a unique String identifier that is defined by authorized web site users.
     * 
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets this instance's name.
     * 
     * @param code
     */
    public void setName(String name)
    {
        this.name = name;
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
     * Returns the email address of the user who created this record.
     * 
     * @return
     */
    public String getInsertedBy()
    {
        return insertedBy;
    }

    /**
     * Sets the email address of the web user who created this record.
     * 
     * @param insertedBy
     */
    public void setInsertedBy(String insertedBy)
    {
        this.insertedBy = insertedBy;
    }

    /**
     * Returns the {@link DateTime} that this record was created.
     * 
     * @return
     */
    public DateTime getInsertedDateTime()
    {
        return insertedDateTime;
    }

    /**
     * Sets the {@link DateTime} that this record was created.
     * 
     * @param insertedDateTime
     */
    public void setInsertedDateTime(DateTime insertedDateTime)
    {
        this.insertedDateTime = insertedDateTime;
    }

    /**
     * Returns the email address of the last web user who modified this record.
     * 
     * @return
     */
    public String getUpdatedBy()
    {
        return updatedBy;
    }

    /**
     * Sets the email address of the last web user who modified this record.
     * 
     * @param updatedBy
     */
    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    /**
     * Returns the {@link DateTime} that this record was last updated.
     * 
     * @return
     */
    public DateTime getUpdatedDateTime()
    {
        return updatedDateTime;
    }

    /**
     * Sets the {@link DateTime} that this record was last updated.
     * 
     * @param updatedDateTime
     */
    public void setUpdatedDateTime(DateTime updatedDateTime)
    {
        this.updatedDateTime = updatedDateTime;
    }
}
