CREATE SEQUENCE profiles_seq START 1;
CREATE SEQUENCE authorities_seq START 1;
CREATE SEQUENCE groups_seq START 1;
CREATE SEQUENCE users_seq START 1;
CREATE SEQUENCE clients_seq START 1;
CREATE SEQUENCE grants_seq START 1;


CREATE TABLE groups
(
    group_id   INTEGER DEFAULT NEXTVAL('groups_seq'),
    group_name VARCHAR(32) NOT NULL,
    PRIMARY KEY (group_id)
);

CREATE TABLE authorities
(
    authority_id   INTEGER DEFAULT NEXTVAL('authorities_seq'),
    group_id       INTEGER,
    authority_name VARCHAR(32) NOT NULL,
    PRIMARY KEY (authority_id),
    UNIQUE (authority_name, group_id),
    FOREIGN KEY (group_id) REFERENCES groups (group_id)
);

CREATE TABLE profiles
(
    profile_id   INTEGER DEFAULT NEXTVAL('profiles_seq'),
    profile_name VARCHAR(255) NOT NULL,
    PRIMARY KEY (profile_id),
    UNIQUE (profile_name)
);

CREATE TABLE profiles_authorities
(
    profile_id   INTEGER,
    authority_id INTEGER,
    PRIMARY KEY (profile_id, authority_id),
    FOREIGN KEY (authority_id) REFERENCES authorities (authority_id),
    FOREIGN KEY (profile_id) REFERENCES profiles (profile_id)
);

CREATE TABLE users
(
    user_id               INTEGER     DEFAULT NEXTVAL('users_seq'),
    username              VARCHAR(255) NOT NULL,
    email                 VARCHAR(255) NOT NULL,
    password              VARCHAR(255) NOT NULL,
    phone                 VARCHAR(20)  NOT NULL,
    profile_id            INTEGER,
    create_at             TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    is_enabled            BOOLEAN     DEFAULT FALSE,
    is_account_expired    BOOLEAN     DEFAULT FALSE,
    is_credential_expired BOOLEAN     DEFAULT FALSE,
    is_account_locked     BOOLEAN     DEFAULT FALSE,
    last_password_changed TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    country               VARCHAR(64)  NOT NULL,
    city                  VARCHAR(64)  NOT NULL,
    street                VARCHAR(64),
    PRIMARY KEY (user_id),
    UNIQUE (email),
    UNIQUE (username),
    FOREIGN KEY (profile_id) REFERENCES profiles (profile_id)
        ON DELETE SET NULL
);

CREATE TABLE grant_types
(
    grant_id   INTEGER     DEFAULT NEXTVAL('grants_seq'),
    grant_type VARCHAR(32) NOT NULL,
    PRIMARY KEY (grant_id),
    UNIQUE (grant_type)
);

CREATE TABLE clients
(
    client_seq    INTEGER DEFAULT NEXTVAL('clients_seq'),
    client_name   VARCHAR(64),
    client_id     VARCHAR(64)  NOT NULL,
    client_secret VARCHAR(255) NOT NULL,
    profile_id    INTEGER,
    grant_id      INTEGER      NOT NULL,
    PRIMARY KEY (client_seq),
    UNIQUE (client_id),
    UNIQUE (client_name),
    FOREIGN KEY (profile_id) REFERENCES profiles (profile_id)
        ON DELETE SET NULL,
    FOREIGN KEY (grant_id) REFERENCES grant_types (grant_id)
        ON DELETE SET NULL
);









