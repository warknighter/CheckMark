package sample;

import java.util.Date;

public class Reports {

    private String ReportNummber;
    private String ReportRegNum;
    private Date ReportDate;

    public Reports(String reportNummber, String reportRegNum, Date reportDate){
        this.ReportNummber = reportNummber;
        this.ReportRegNum = reportRegNum;
        this.ReportDate = reportDate;
    }

    public String getReportNummber(){
        return ReportNummber;
    }

    public String getReportRegNum(){
        return ReportRegNum;
    }

    public Date getReportDate(){
        return ReportDate;
    }
}
