package com.tom.objectmapper.util;

import com.tom.objectmapper.exceptions.ObjectInstantiationException;
import com.tom.objectmapper.exceptions.SetFieldException;
import java.util.Map;

public interface MapperUtil {

    boolean checkIfMappable(Class<?> targetClass, Class<?> currentClass);

    Map<String, Object> getFields(Object mappedObject) throws IllegalArgumentException, IllegalAccessException;

    <T> T createObject(Class<T> className, Map<String, Object> fields) throws ObjectInstantiationException, SetFieldException;

}
