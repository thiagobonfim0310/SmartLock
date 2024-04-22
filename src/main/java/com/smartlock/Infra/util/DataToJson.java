package com.smartlock.Infra.util;

import com.google.gson.Gson;
import java.util.Arrays;
import java.util.List;

import com.smartlock.Business.entities.Enviroments;

public class DataToJson {

    public String serializeEnviroments(List<Enviroments> enviroments) {
        Gson gson = new Gson();
        return gson.toJson(enviroments);
    }

    public List<Enviroments> deserializeEnviroments(String serializedEnviroments) {
        Gson gson = new Gson();
        Enviroments[] envArray = gson.fromJson(serializedEnviroments, Enviroments[].class);
        return Arrays.asList(envArray);
    }

}
