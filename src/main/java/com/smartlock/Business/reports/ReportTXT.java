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

    @Override
    protected void generateFile() {
        String fileName = "Relatorio_" + LocalDate.now() + ".txt";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("== Relatório ==\n");
            writer.write("Data de Geração: " + LocalDate.now() + "\n");

            for (Enviroments enviroment : enviroments) {
                writer.write("Ambiente " + enviroment.getName() + "\n");
                writer.write("Trancas\n");
                
                for (Lock lock : enviroment.getLocks()) {
                    writer.write("- " + lock.getId().toString() + "\n");
                }
                writer.write("\n");
            }

            writer.write("== SmartLock ==\n");
            writer.write("Relatório em formato (.txt)\n");
            writer.write("\n");
            
            System.out.println("Relatório exportado com sucesso para o arquivo: " + fileName);
        } catch (IOException e) {
            System.err.println("Erro ao exportar relatório para o arquivo: " + fileName);
            e.printStackTrace();
        }
    }
}
