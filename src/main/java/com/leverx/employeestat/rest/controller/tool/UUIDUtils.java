package com.leverx.employeestat.rest.controller.tool;

import com.leverx.employeestat.rest.exception.NotValidUUIDException;

import java.util.UUID;

public class UUIDUtils {
    public static UUID getUUIDFromString(String id) {
        UUID uuid = null;
        try {
            uuid = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            throw new NotValidUUIDException(String.format("Value =%s is not UUID", id), e);
        }
        return uuid;
    }
}
