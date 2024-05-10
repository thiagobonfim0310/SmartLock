package com.smartlock.View.Reports;

import java.util.Scanner;
import java.util.UUID;
import java.util.List;

import com.smartlock.Business.reports.ReportTemplate;
import com.smartlock.View.util.PrintEntities;

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
