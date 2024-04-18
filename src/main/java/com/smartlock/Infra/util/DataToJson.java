package com.smartlock.Infra.util;

import com.google.gson.Gson;
import java.util.Arrays;
import com.smartlock.Business.entities.Enviroments;

public class DataToJson {

    public String serializeEnviroments(Enviroments[] enviroments) {
        Gson gson = new Gson();
        return gson.toJson(enviroments);
    }

    public Enviroments[] deserializeEnviroments(String serializedEnviroments) {
        Gson gson = new Gson();
        return gson.fromJson(serializedEnviroments, Enviroments[].class);
    }

}
