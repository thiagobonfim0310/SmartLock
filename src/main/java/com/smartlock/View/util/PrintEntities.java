package com.smartlock.View.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

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
                        // Se for uma coleção, imprima cada elemento
                        System.out.println(attribute.getName() + ": ");
                        printCollection((Collection<?>) value, depth + 1);
                    } else if (value instanceof UUID) {
                        // Se for um UUID, imprima seu valor diretamente
                        System.out.println(attribute.getName() + ": " + value.toString());
                    } else if (!attribute.getType().isPrimitive() && !attribute.getType().equals(String.class)) {
                        // Se não for primitivo nem String, chame recursivamente o método printObject
                        System.out.println(attribute.getName() + ": ");
                        printClass(value, depth + 1);
                    } else {
                        // Para outros tipos de dados, imprima o nome do atributo e seu valor
                        System.out.println(attribute.getName() + ": " + value);
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private void printCollection(Collection<?> collection, int depth) {
        for (Object element : collection) {
            if (depth > 0) {
                System.out.print("    ".repeat(depth));
                System.out.print("└─ ");
            }
            System.out.println(element.toString());
        }
    }

}