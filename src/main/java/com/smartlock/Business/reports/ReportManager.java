package com.smartlock.Business.reports;

import com.smartlock.Business.entities.Report;
import com.smartlock.Business.reports.ReportTXT;
import com.smartlock.Business.reports.ReportPDF;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

public class ReportManager {

    ReportTXT reportTXT = new ReportTXT();
    ReportPDF reportPDF = new ReportPDF();


    public ReportManager() {
        //implementar HEADER, BODY e BASEBOARD;
        //essas classes acima devem ser abstratas aqui no Template e implementadas no ReportTXT e PDF;
    }

    public void generateReportTXT() {
        reportTXT.generateReport();
    }
    
    public void generateReportPDF() {

    }
}
