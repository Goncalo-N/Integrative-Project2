package app.domain.model;

public class RepDiag {

    private String report;
    private long testCode;

    public RepDiag(String report, long testCode) {
        this.report = report;
        this.testCode = testCode;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public long getTestCode() {
        return testCode;
    }

    public void setTestCode(long testCode) {
        this.testCode = testCode;
    }
}
