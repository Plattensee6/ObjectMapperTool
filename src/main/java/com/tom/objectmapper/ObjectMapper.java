package com.tom.objectmapper;

import com.tom.objectmapper.util.MappingUtil;
import com.tom.objectmapper.exceptions.MappingException;
import com.tom.objectmapper.exceptions.ObjectInstantiationException;
import com.tom.objectmapper.exceptions.SetFieldException;

public class ObjectMapper {
    public <T> T mapObject(Class<T> className, Object mappedObject) throws MappingException{
        MappingUtil mapppingUtils = new MappingUtil();
        T newObject = null;
        if (mapppingUtils.checkIfMappable(className, mappedObject.getClass())) {
            try {
                newObject = mapppingUtils.createObject(className, mapppingUtils.getFields(mappedObject));
                
            } catch (ObjectInstantiationException | SetFieldException | IllegalArgumentException | IllegalAccessException ex) {
                throw new MappingException("Unable to map the given object to the specified type" + ex.getMessage());
            }
        }
        return newObject;
    }
}
