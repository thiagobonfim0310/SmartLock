package com.smartlock.Business.reports;

public abstract class ReportTemplate {

    public void generateReport() {
        
        generateHeader();
        generateBody();
        generateFooter();
    }

    protected abstract void generateHeader();
    protected abstract void generateBody();
    protected abstract void generateFooter();
    
    
}
