package com.smartlock.business.reports;

import com.smartlock.business.entities.Lock;
import com.smartlock.business.entities.Enviroments;

import com.smartlock.infra.database.Database;
import com.smartlock.view.util.PrintEntities;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ReportTXT extends ReportTemplate {

    Database data;
    PrintEntities print = new PrintEntities();

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

            System.out.print("------------------------------------ \n");
            print.printClass(enviroment);
            System.out.print("\n");
        }
    }

    @Override
    protected void generateFooter() {
        
        System.out.println("== SmartLock ==");
        System.out.println("Relatório em formato (.txt)");
    }

}
