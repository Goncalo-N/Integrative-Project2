package app.domain.model;

import java.util.Date;

public class Rep {

    private int historicalPoints;
    private Date[] dateInterval;
    private String regressionModel;
    private int [] independentVariableX;
    private int [] independentVariableY;

    public Rep(int historicalPoints, Date[] dateInterval, String regressionModel, int[] independantVariableX, int[] independantVariableY) {
        setHistoricalPoints(historicalPoints);
        setDateInterval(dateInterval);
        setRegressionModel(regressionModel);
        setIndependantVariableX(independantVariableX);
        setIndependantVariableY(independantVariableY);

    }

    public int getHistoricalPoints() {
        return historicalPoints;
    }

    public void setHistoricalPoints(int historicalPoints) {
        this.historicalPoints = historicalPoints;
    }

    public Date[] getDateInterval() {
        return dateInterval;
    }

    public void setDateInterval(Date[] dateInterval) {
        this.dateInterval = dateInterval;
    }

    public String getRegressionModel() {
        return regressionModel;
    }

    public void setRegressionModel(String regressionModel) {
        this.regressionModel = regressionModel;
    }

    public int[] getIndependantVariableX() {
        return independentVariableX;
    }

    public void setIndependantVariableX(int[] independantVariableX) {
        this.independentVariableX = independantVariableX;
    }

    public int[] getIndependantVariableY() {
        return independentVariableY;
    }

    public void setIndependantVariableY(int[] independantVariableY) {
        this.independentVariableY = independantVariableY;
    }
}
