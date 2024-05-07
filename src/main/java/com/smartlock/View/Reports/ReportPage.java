package com.smartlock.View.Reports;

import java.util.Scanner;
import java.util.UUID;
import java.util.List;

import com.smartlock.Business.reports.ReportManager;
import com.smartlock.Business.entities.Report;
import com.smartlock.View.util.PrintEntities;

public class ReportPage {
    
    ReportManager manageReport;
    PrintEntities print = new PrintEntities();

    public ReportPage(ReportManager reportManager) {
        manageReport = reportManager;
    }

    public void issueReportPDF() {
        System.out.println("Gerando relatório em PDF");
        manageReport.generateReportPDF();
    }

    public void issueReportTXT() {
        System.out.println("Gerando relatṕrio em TXT");
        manageReport.generateReportTXT();
    }

}
