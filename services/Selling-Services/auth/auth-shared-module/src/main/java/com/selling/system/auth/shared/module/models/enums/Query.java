package com.selling.system.auth.shared.module.models.enums;

public enum Query {
    RETRIEVE_ALL_PROFILES,
    RETRIEVE_ALL_AUTHORITIES,
    RETRIEVE_PROFILE,
    RETRIEVE_PROFILE_AUTHORITIES_KEYS,
    RETRIEVE_AUTHORITIES_KEYS,
    RETRIEVE_ALL_GROUPS,
    RETRIEVE_ALL_USERS,
    RETRIEVE_USER,
    RETRIEVE_ALL_CLIENTS,
    RETRIEVE_CLIENT,
    RETRIEVE_GRANT_TYPES,
    IS_PROFILE_NAME_EXISTS,
    IS_USERNAME_EXISTS,
    IS_EMAIL_EXISTS,
    IS_CLIENT_NAME_EXISTS,
    ADD_PROFILE_AUTHORITIES,
    ADD_PROFILE,
    ADD_AUTHORITY,
    ADD_GROUP,
    ADD_USER,
    ADD_GRANT_TYPE,
    ADD_CLIENT,
    DELETE_PROFILE,
    DELETE_ALL_PROFILE_AUTHORITIES,
    DELETE_PROFILE_AUTHORITIES,
    DELETE_PROFILE_AUTHORITIES_GROUP,
    DELETE_AUTHORITIES_GROUP,
    DELETE_GROUP,
    DELETE_PROFILE_AUTHORITY,
    DELETE_AUTHORITY,
    DELETE_USER,
    DELETE_GRANT_TYPE,
    DELETE_CLIENT,
    UPDATE_PROFILE_NAME,
    UPDATE_GROUP_NAME,
    UPDATE_AUTHORITY_NAME,
    UPDATE_USER_INFO,
    UPDATE_USER_PASSWORD,
    UPDATE_CLIENT_PROFILE,
    UPDATE_CLIENT_GRANT_TYPE,
    ASSIGN_USER_PROFILE,
    AUTHORITY_VALUES,
    ENABLE_USER,
    LOCK_USER,
    EXPIRE_USER_ACCOUNT,
    EXPIRE_USER_CREDENTIAL
}
