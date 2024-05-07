package com.smartlock.Business.entities;

import java.time.LocalDate;

public abstract class Report {
    private LocalDate reportDate;

    public Report() {
        this.reportDate = LocalDate.now();
    }

    protected void generateReport() {

    }

    protected LocalDate getIssueDate() {
        return this.reportDate;
    }
}
