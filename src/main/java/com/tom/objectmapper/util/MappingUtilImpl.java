package com.tom.objectmapper.util;

import com.tom.objectmapper.annotations.ElementToMap;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import com.tom.objectmapper.annotations.MappedEntity;
import com.tom.objectmapper.exceptions.ObjectInstantiationException;
import com.tom.objectmapper.exceptions.SetFieldException;

public class MappingUtilImpl implements MapperUtil{
    private static MappingUtilImpl instance = null;
    
    private MappingUtilImpl() {
    }
    
    /**
     * 
     * @param targetClass
     * @param currentClass
     * @return true when the given Classes are annotated with 
     * MappedEntity annotation and mappedEntity attributes are equal.
     */
    @Override
    public boolean checkIfMappable(Class<?> targetClass, Class<?> currentClass){
        boolean flag = false;
        if (targetClass.isAnnotationPresent(MappedEntity.class) && currentClass.isAnnotationPresent(MappedEntity.class)) {
            MappedEntity targetAnnotation = targetClass.getAnnotation(MappedEntity.class);
            MappedEntity currentAnnotation = targetClass.getAnnotation(MappedEntity.class);
            
            if (targetAnnotation != null && currentAnnotation != null) {
                flag = targetAnnotation.entityName().equals(currentAnnotation.entityName());
            }
        }
        return flag;
    }
   /**
    * 
    * @param mappedObject
    * @return Returns a Map, where the key contains the name of the field 
    * and the value contains the retrieved value. Any primitive types wrapped 
    * in its proper class;
    * @throws IllegalArgumentException
    * @throws IllegalAccessException 
    */
    @Override
    public Map<String,Object> getFields(Object mappedObject) throws IllegalArgumentException, IllegalAccessException{
        Map<String, Object> fields = new HashMap<>();
        if (mappedObject == null) {
            throw new IllegalArgumentException("The mapped object cannot be null!");
        }
        Class<?> mappedClass = mappedObject.getClass();
        for (Field field : mappedClass.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(ElementToMap.class)) {
                fields.put(field.getName(), field.get(mappedObject));
            }
        }
        return fields;
    }
    @Override
    public <T> T createObject(Class<T> className, Map<String,Object> fields) throws ObjectInstantiationException, SetFieldException{
        T newObject;
        try {
            newObject = className.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
           throw new ObjectInstantiationException("Unable to create object" + ex.getMessage());
        }
        try {
            fields.forEach((fieldName, value)  -> {
                try {
                    Field field = className.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    field.set(newObject, value);

                } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex){
                    throw new RuntimeException();
                } 
            });
        } catch (Exception e) {
            throw new SetFieldException("Unable to set the field's value.");
        }
        return newObject;
    }
    public static MappingUtilImpl getInstance() {
        return (instance == null)? new MappingUtilImpl() : instance;
    }
    
}
