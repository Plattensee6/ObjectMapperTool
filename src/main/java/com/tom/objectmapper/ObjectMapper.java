package com.tom.objectmapper;

import com.tom.objectmapper.exceptions.MappingException;
import com.tom.objectmapper.exceptions.ObjectInstantiationException;
import com.tom.objectmapper.exceptions.SetFieldException;
import com.tom.objectmapper.util.MapperUtil;

public class ObjectMapper {
    private final MapperUtil mapppingUtils;

    public ObjectMapper(MapperUtil mapppingUtils) {
        this.mapppingUtils = mapppingUtils;
    }
    
    public <T> T mapObject(Class<T> className, Object mappedObject) throws MappingException{
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
