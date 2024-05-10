package com.smartlock.view.reports;

import java.util.Scanner;
import java.util.UUID;
import java.util.List;

import com.smartlock.view.util.PrintEntities;
import com.smartlock.business.reports.ReportTemplate;

public class ReportPage {
    
    ReportTemplate manageReport;
    PrintEntities print = new PrintEntities();

    public ReportPage(ReportTemplate reportManager) {
        manageReport = reportManager;
    }

    public void issueReportTXT() {
        System.out.println("Gerando relatório em TXT");
        manageReport.generateReport();
    }

}
