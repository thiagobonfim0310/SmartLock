package com.smartlock.Business.Enviroment;

import com.smartlock.Business.entities.Enviroments;

import com.smartlock.Infra.database.Database;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

public class EnviromentManager {

    Database data;

    public EnviromentManager(Database database) {
        data = database;
    }

    public void registerEnviromentController(Enviroments enviroment) {

        enviroment.setId(UUID.randomUUID());

        data.saveEnviroment(enviroment);
    }

    public List<Enviroments> listEnviromentController() {
        List<Enviroments> enviroments = new ArrayList<>();

        enviroments = data.listEnviroments();
        return enviroments;
    }

    public void updateEnviromentController(Enviroments enviroment, UUID id) {

        data.updateEnviroments(enviroment, id);
    }

    public void deleteEnviromentController(UUID id) {
        data.deleteEnviroments(id);
    }
}
