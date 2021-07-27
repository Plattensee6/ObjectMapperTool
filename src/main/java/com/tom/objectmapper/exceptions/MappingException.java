package com.tom.objectmapper.exceptions;
/**
 * Throws MappingException when the ObjectMapper 
 * is unable to map the provided object to the given type.
 * Mapping is possible when: 
 * - both class has to be annontated with MappedEntity
 * - both MappedEntity annotation has to have a name attribute, 
 * both name has to be the same and it shoul be in lowercase.
 * - all mapped field hast to bo annotated with ElementToMap
 * 
*/
public class MappingException extends Exception{
    public MappingException(String message) {
        super(message);
    }
}
