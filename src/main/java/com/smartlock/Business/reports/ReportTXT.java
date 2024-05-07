package com.smartlock.Business.reports;

import com.smartlock.Business.entities.Report;
import com.smartlock.Business.entities.Lock;
import com.smartlock.Business.entities.User;
import com.smartlock.Business.entities.Enviroments;

import com.smartlock.Infra.database.Database;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class ReportTXT extends Report {

    Database data;

    List <Enviroments> enviroments;


    @Override
    protected void generateReport() {
        String fileName = "Relatorio_" + getIssueDate() + ".txt";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("== Relatório ==\n");
            writer.write("Data de Geração: " + getIssueDate() + "\n");

            for (Enviroments enviroment : enviroments) {
                writer.write("Ambiente " + enviroment.getName() + "\n");
                writer.write("Trancas\n");
                
                for (Lock lock : enviroment.getLocks()) {
                    writer.write("- " + lock.getId().toString() + "\n");
                }
                writer.write("\n");
            }
            
            System.out.println("Relatório exportado com sucesso para o arquivo: " + fileName);
        } catch (IOException e) {
            System.err.println("Erro ao exportar relatório para o arquivo: " + fileName);
            e.printStackTrace();
        }
    }
}
