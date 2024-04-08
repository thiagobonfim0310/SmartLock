package com.smartlock.View.util;

import java.lang.reflect.Field;

/**
 * printEntities
 */
public class PrintEntities {

    public void printClass(Object object) {

        Class<?> entity = object.getClass();

        Field[] attributes = entity.getDeclaredFields();

        for (Field attibute : attributes) {
            attibute.setAccessible(true);
            try {
                System.out.println(attibute.getName() + ": " + attibute.get(object));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}