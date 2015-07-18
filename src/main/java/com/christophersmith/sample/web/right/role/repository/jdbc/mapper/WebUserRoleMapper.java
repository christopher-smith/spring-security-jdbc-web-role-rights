package com.christophersmith.sample.web.right.role.repository.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.BooleanUtils;
import org.joda.time.DateTime;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.christophersmith.sample.web.right.role.domain.WebUserRole;

/**
 * WebUserRoleMapper is a {@link RowMapper} implementation used for creating {@link WebUserRole}
 * objects from a {@link ResultSet}.
 * 
 * @author Christopher Smith (https://github.com/christopher-smith)
 */
@Component
public class WebUserRoleMapper implements RowMapper<WebUserRole>
{
    /**
     * WEB_USER_ROLE table name.
     */
    public static final String TABLE_NAME                    = "WEB_USER_ROLE";
    /**
     * WEB_USER_ROLE_ID column name. Data type is a BIGINT and is incremented by the database.
     */
    public static final String COLUMN_NAME_WEB_USER_ROLE_ID  = "WEB_USER_ROLE_ID";
    /**
     * WEB_USER_ROLE_NME column name. Data type is a VARCHAR(128).
     */
    public static final String COLUMN_NAME_WEB_USER_ROLE_NME = "WEB_USER_ROLE_NME";
    /**
     * ACTIVE_FLG column name. Data type is a SMALLINT (0 = false, 1 = true).
     */
    public static final String COLUMN_NAME_ACTIVE_FLG        = "ACTIVE_FLG";
    /**
     * INSERTED_BY_VLU column name. Data type is a VARCHAR(255).
     */
    public static final String COLUMN_NAME_INSERTED_BY_VLU   = "INSERTED_BY_VLU";
    /**
     * INSERTED_TS column name. Data type is a TIMESTAMP.
     */
    public static final String COLUMN_NAME_INSERTED_TS       = "INSERTED_TS";
    /**
     * UPDATED_BY_VLU column name. Data type is a VARCHAR(255).
     */
    public static final String COLUMN_NAME_UPDATED_BY_VLU    = "UPDATED_BY_VLU";
    /**
     * UPDATED_TS column name. Data type is a TIMESTAMP.
     */
    public static final String COLUMN_NAME_UPDATED_TS        = "UPDATED_TS";
    /**
     * SELECT statement for use is this class.
     */
    public static final String SELECT                        = "SELECT "
        + COLUMN_NAME_WEB_USER_ROLE_ID + ", " + COLUMN_NAME_WEB_USER_ROLE_NME + ", "
        + COLUMN_NAME_ACTIVE_FLG + ", " + COLUMN_NAME_INSERTED_BY_VLU + ", "
        + COLUMN_NAME_INSERTED_TS + ", " + COLUMN_NAME_UPDATED_BY_VLU + ", "
        + COLUMN_NAME_UPDATED_TS + " FROM " + TABLE_NAME;

    @Override
    public WebUserRole mapRow(ResultSet result, int index) throws SQLException
    {
        WebUserRole record = new WebUserRole();
        record.setIdentifier(result.getLong(COLUMN_NAME_WEB_USER_ROLE_ID));
        record.setName(result.getString(COLUMN_NAME_WEB_USER_ROLE_NME));
        record.setActive(BooleanUtils.toBoolean(result.getInt(COLUMN_NAME_ACTIVE_FLG)));
        record.setInsertedBy(result.getString(COLUMN_NAME_INSERTED_BY_VLU));
        record.setInsertedDateTime(new DateTime(result.getTimestamp(COLUMN_NAME_INSERTED_TS)));
        record.setUpdatedBy(result.getString(COLUMN_NAME_UPDATED_BY_VLU));
        record.setUpdatedDateTime(new DateTime(result.getTimestamp(COLUMN_NAME_UPDATED_TS)));
        return record;
    }
}
