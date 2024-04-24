package com.smartlock.Infra.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.smartlock.Business.entities.Enviroments;

public class DataToJson {
    private static Gson gson = new Gson();

    public String serializeEnviroments(List<Enviroments> enviroments) {
        gson = new Gson();
        return gson.toJson(enviroments);
    }

    public List<Enviroments> deserializeEnviroments(String serializedEnviroments) {
        gson = new Gson();
        Enviroments[] envArray = gson.fromJson(serializedEnviroments, Enviroments[].class);
        return Arrays.asList(envArray);
    }

    public String serializeType(List<String> list) {
        return gson.toJson(list);
    }

    public List<String> deserializeTypes(String json) {
        if (json == null || json.isEmpty()) {
            return new ArrayList<>();
        }
        Type type = new TypeToken<List<String>>() {
        }.getType();
        List<String> list = gson.fromJson(json, type);
        if (list == null) {
            throw new IllegalArgumentException("Erro ao deserializar a lista.");
        }
        return list;
    }

}
