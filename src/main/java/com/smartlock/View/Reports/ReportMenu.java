package com.smartlock.View.Reports;

import java.util.Scanner;

import javax.sound.midi.SysexMessage;

public class ReportMenu {
    ReportPage reportPage;

    public ReportMenu(ReportPage report) {
        reportPage = report;
    }

    public void menu() {
        
        int option;
        while (true) {
            System.out.println("Selecione a opção de relatório que deseja gerar");
            System.out.println("[1] - Relatório geral simplificado (PDF)");
            System.out.println("[2] - Relatório geral simplifcado (TXT)");
            System.out.println("[3] - Voltar");
            Scanner input = new Scanner(System.in);
            option = input.nextInt();
            switch (option) {
                case 1:
                    this.reportPage.issueReportPDF();
                    break;
                case 2:
                    this.reportPage.issueReportTXT();
                    break;
                case 3:
                    return;
            
                default:
                    break;
            }
        }
    }
}
