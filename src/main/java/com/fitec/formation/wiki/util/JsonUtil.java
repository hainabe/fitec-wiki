package com.fitec.formation.wiki.util;

public interface JsonUtil {

    String DATE_PATTERN = "dd-MM-yyyy";

    String MSG_SUCCESS_ADD = "### B**ch ADDED!";
    String MSG_SUCCESS_LOAD = "### B**ch LOADED!";
    String MSG_SUCCESS_UPDATE = "### B**ch UPDATED!";
    String MSG_SUCCESS_DELETE = "### B**ch DELETED!";

    String MSG_ERROR_DB = "### Not today! INVALID REQUEST";
    String MSG_ERROR_NOT_FOUND = "### Not today! RESOURCE NOT FOUND";
    String MSG_ERROR_UNAUTH = "### Not today! ACCESS DENIED";
}
