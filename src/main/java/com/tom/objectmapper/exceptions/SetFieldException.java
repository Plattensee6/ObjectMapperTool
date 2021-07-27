package com.tom.objectmapper.exceptions;
/**
 * NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException
 * SetFieldException is thrown when NoSuchFieldException OR SecurityException OR SecurityException
 * OR IllegalArgumentException OR IllegalAccessException is being thrown.
 * ObjectMapper is unalbe to set the target types's corresponding fileds.
 */
public class SetFieldException extends Exception{
    public SetFieldException(String message) {
        super(message);
    }
}
