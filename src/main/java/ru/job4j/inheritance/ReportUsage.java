package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport report = new TextReport();
        System.out.println(report.generate("Report's name", "Report's body"));
    }
}
