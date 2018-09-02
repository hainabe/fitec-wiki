package com.fitec.formation.wiki.util;

import org.springframework.stereotype.Component;

@Component
public interface MessageUtil {

    String DATE_PATTERN = "dd-MM-yyyy";

    String CROSS_ORIGIN = "http://localhost:4200";

    String MSG_SUCCESS_ADD = "### B**ch ADDED!";
    String MSG_SUCCESS_LOAD = "### B**ch LOADED!";
    String MSG_SUCCESS_UPDATE = "### B**ch UPDATED!";
    String MSG_SUCCESS_DELETE = "### B**ch DELETED!";
    String MSG_SUCCESS_MAP = "### B**ch MAPPED!";
    String MSG_SUCCESS_SET_STATUS = "### B**ch status SET!";

    String MSG_ERROR_DB = "### Not today! INVALID REQUEST";
    String MSG_ERROR_NULL = "### Not today! B**ch is NULL!";
    String MSG_ERROR_NOT_FOUND = "### Not today! RESOURCE NOT FOUND";
    String MSG_ERROR_NULL_NOT_FOUND = "### Not today! RESOURCE NOT FOUND or B**ch is NULL! Meh... Who knows?";
    String MSG_ERROR_UNAUTH = "### Not today! ACCESS DENIED";
    String MSG_ERROR_SET_STATUS = "### Not today! Status NOT SET!";

}
