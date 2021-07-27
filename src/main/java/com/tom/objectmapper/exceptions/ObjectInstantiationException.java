package com.tom.objectmapper.exceptions;
/**
 * 
 * Throws ObjectInstantiationException when InstantiationException 
 * OR IllegalAccessException is thrown by the Class type object newInstance method.
 * 
 */
public class ObjectInstantiationException extends Exception{
    public ObjectInstantiationException(String message) {
        super(message);
    }
}
