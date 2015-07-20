-- TABLE:   WEB_SECTION
-- PURPOSE: This table stores a listing of Web Sections for
--          the web site. This table is populated at run time,
--          and is not a user populated table.
CREATE TABLE WEB_SECTION
(
	WEB_SECTION_ID INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
	WEB_SECTION_CD VARCHAR(255) NOT NULL,
	ORDER_NO       INTEGER      NOT NULL
);


-- TABLE:   WEB_RIGHT
-- PURPOSE: This table stores a listing of Web Rights for the
--          various pages and features on the web site. This
--          table is populated at run time, and is not a user
--          populated table.
CREATE TABLE WEB_RIGHT
(
	WEB_RIGHT_ID    BIGINT       NOT NULL PRIMARY KEY AUTO_INCREMENT,
	WEB_RIGHT_CD    VARCHAR(255) NOT NULL,
	ACTIVE_FLG      SMALLINT     NOT NULL,
	MENU_OPTION_FLG SMALLINT     NOT NULL,
	WEB_SECTION_ID  INTEGER      NOT NULL,
	ORDER_NO        INTEGER      NOT NULL,
	PAGE_URI_VLU    VARCHAR(255)
);

CREATE UNIQUE INDEX WEB_RIGHT_UX1 ON WEB_RIGHT (WEB_RIGHT_CD);
CREATE        INDEX WEB_RIGHT_IX1 ON WEB_RIGHT (ACTIVE_FLG);

ALTER TABLE WEB_RIGHT
	ADD CONSTRAINT WEB_RIGHT_FK1
	FOREIGN KEY (WEB_SECTION_ID)
	REFERENCES WEB_SECTION (WEB_SECTION_ID);


-- TABLE:   WEB_USER_ROLE
-- PURPOSE: This table stores a listing of user provided Roles
--          that Web Users can be assigned to.
CREATE TABLE WEB_USER_ROLE
(
	WEB_USER_ROLE_ID  BIGINT       NOT NULL AUTO_INCREMENT,
	WEB_USER_ROLE_NME VARCHAR(128) NOT NULL,
	ACTIVE_FLG        SMALLINT     NOT NULL,
	INSERTED_BY_VLU   VARCHAR(255) NOT NULL,
	INSERTED_TS       TIMESTAMP    NOT NULL,
	UPDATED_BY_VLU    VARCHAR(255) NOT NULL,
	UPDATED_TS        TIMESTAMP    NOT NULL
);

CREATE UNIQUE INDEX WEB_USER_ROLE_UX1 ON WEB_USER_ROLE (WEB_USER_ROLE_NME);
CREATE        INDEX WEB_USER_ROLE_IX1 ON WEB_USER_ROLE (ACTIVE_FLG);


-- TABLE:   WEB_USER_ROLE_WEB_RIGHT
-- PURPOSE: This table stores a listing of Web Rights that have
--          been assigned to Web User Roles, and is populated by
--          the user.
CREATE TABLE WEB_USER_ROLE_WEB_RIGHT
(
	WEB_USER_ROLE_ID BIGINT NOT NULL,
	WEB_RIGHT_ID     BIGINT NOT NULL,
	PRIMARY KEY(WEB_USER_ROLE_ID, WEB_RIGHT_ID)
);

CREATE INDEX WEB_USER_ROLE_WEB_RIGHT_IX1 ON WEB_USER_ROLE_WEB_RIGHT (WEB_USER_ROLE_ID);
CREATE INDEX WEB_USER_ROLE_WEB_RIGHT_IX2 ON WEB_USER_ROLE_WEB_RIGHT (WEB_RIGHT_ID);

ALTER TABLE WEB_USER_ROLE_WEB_RIGHT
	ADD CONSTRAINT WEB_USER_ROLE_WEB_RIGHT_FK1
	FOREIGN KEY (WEB_USER_ROLE_ID)
	REFERENCES WEB_USER_ROLE (WEB_USER_ROLE_ID);

ALTER TABLE WEB_USER_ROLE_WEB_RIGHT
	ADD CONSTRAINT WEB_USER_ROLE_WEB_RIGHT_FK2
	FOREIGN KEY (WEB_RIGHT_ID)
	REFERENCES WEB_RIGHT (WEB_RIGHT_ID);


-- TABLE:   WEB_USER
-- PURPOSE: This table stores a listing of Web Users that are setup to
--          access the web site, and is populated by the user.
CREATE TABLE WEB_USER
(
	WEB_USER_ID       BIGINT       NOT NULL PRIMARY KEY AUTO_INCREMENT,
	FIRST_NME         VARCHAR(32)  NOT NULL,
	LAST_NME          VARCHAR(32)  NOT NULL,
	EMAIL_ADDRESS_VLU VARCHAR(255) NOT NULL,
	PASSWORD_VLU      VARCHAR(255) NOT NULL,
	ACTIVE_FLG        SMALLINT     NOT NULL,	
	WEB_USER_ROLE_ID  BIGINT,
	INSERTED_BY_VLU   VARCHAR(255) NOT NULL,
	INSERTED_TS       TIMESTAMP    NOT NULL,
	UPDATED_BY_VLU    VARCHAR(255) NOT NULL,
	UPDATED_TS        TIMESTAMP    NOT NULL
);

CREATE UNIQUE INDEX WEB_USER_UX1 ON WEB_USER (EMAIL_ADDRESS_VLU);

ALTER TABLE WEB_USER
	ADD CONSTRAINT WEB_USER_FK1
	FOREIGN KEY (WEB_USER_ROLE_ID)
	REFERENCES WEB_USER_ROLE (WEB_USER_ROLE_ID);
