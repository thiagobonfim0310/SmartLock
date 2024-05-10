package com.smartlock.Business.reports;

import com.smartlock.Business.entities.Lock;
import com.smartlock.Business.entities.Enviroments;

import com.smartlock.Infra.database.Database;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ReportTXT extends ReportTemplate {

    Database data;

    private List <Enviroments> enviroments = new ArrayList<>();

    public ReportTXT(Database data) {
        this.enviroments = data.listEnviroments();
    }

    @Override
    protected void generateHeader() {

        System.out.println("Relatório Simples");
        System.out.println("Data de Emissão: " + LocalDate.now());
    }

    @Override
    protected void generateBody() {
        
        for (Enviroments enviroment : enviroments) {
            System.out.print("Ambiente: " + enviroment.getName() + "\n");
            System.out.println("Trancas");

            for (Lock lock : enviroment.getLocks()) {
                System.out.print("- " + lock.getId().toString() + "\n");
            }
            System.out.print("\n");
        }
    }

    @Override
    protected void generateFooter() {
        
        System.out.println("== SmartLock ==");
        System.out.println("Relatório em formato (.txt)");
    }

}
