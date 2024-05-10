package com.smartlock.view.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import com.smartlock.business.entities.Enviroments;

/**
 * printEntities
 */
public class PrintEntities {

    public void printClass(Object object) {
        printClass(object, 0);
    }

    private void printClass(Object object, int depth) {
        Class<?> entity = object.getClass();
        Field[] attributes = entity.getDeclaredFields();

        for (Field attribute : attributes) {
            attribute.setAccessible(true);
            try {
                Object value = attribute.get(object);
                if (value != null) {
                    if (depth > 0) {
                        System.out.print("    ".repeat(depth));
                        System.out.print("└─ ");
                    }
                    if (value instanceof Collection) {
                        System.out.println(attribute.getName() + ": ");
                        printCollection((List<?>) value, depth + 1);
                    } else if (value instanceof UUID) {
                        System.out.println(attribute.getName() + ": " + value.toString());
                    } else if (!attribute.getType().isPrimitive() && !attribute.getType().equals(String.class)) {
                        System.out.println(attribute.getName() + ": ");
                        printClass(value, depth + 1);
                    } else {
                        System.out.println(attribute.getName() + ": " + value);
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private void printCollection(List<?> collection, int depth) {
        for (Object element : collection) {
            if (depth > 0) {
                System.out.print("    ".repeat(depth));
                System.out.print("└─ ");
            }
            if (element instanceof Enviroments) {
                printClass(element, depth);
            } else {
                System.out.println(element.toString());
            }
        }
    }

}