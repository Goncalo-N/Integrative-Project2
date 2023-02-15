package app.ui.console;

import app.controller.CreateRepController;
import app.ui.console.utils.Utils;
import app.domain.shared.LinearRegression;
import org.apache.commons.lang3.time.DateUtils;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class CreateRepUI implements Runnable {

    private final CreateRepController ctrl;

    public CreateRepUI() {this.ctrl = new CreateRepController();}

    @Override
    public void run() {

        System.out.println("\n Report creation process started \n");
        try {
            String rep = readData();
            sendAutoRep(rep);
            if (Utils.confirm("Do you confirm the Report? (Y/N)")) {
                if (this.ctrl.sendRep(rep)) {
                    System.out.println("Record save with success.");
                } else {
                    System.out.println("An error occurred while attempting to save the record.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Date> getDatesBetween(Date startDate, Date endDate) {
        List<Date> datesInRange = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);

        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(endDate);

        while (calendar.before(endCalendar)) {
            Date result = calendar.getTime();
            if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)
                datesInRange.add(result);
            calendar.add(Calendar.DATE, 1);
        }
        return datesInRange;
    }

    /**
     * @return returns the report
     * @throws Exception Exception
     */
    private String readData() throws Exception {
        int lineNumber = 0;
        int dateArraySize = 3200;
        String line;
        Date[] date = new Date[dateArraySize];
        Double[] igGan = new Double[dateArraySize];
        Calendar[] calendar = new Calendar[dateArraySize];
        try {
            File csvFile = new File("tests_CovidMATCPCSV.csv");
            BufferedReader br = new BufferedReader(new FileReader(csvFile));

            br.readLine();
            SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");

            while ((line = br.readLine()) != null) {
                String[] arr = line.split(";");
                date[lineNumber] = dt1.parse(arr[21]);
                igGan[lineNumber] = Double.parseDouble(arr[20]);
                dt1.format(date[lineNumber]);
                calendar[lineNumber] = Calendar.getInstance();
                calendar[lineNumber].setTime(date[lineNumber]);

                lineNumber++;
            }


            // System.out.println(lineNumber);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        int predictor;
        int historicalPointsF = 0;
        double[] meanAge = new double[lineNumber];
        double totalMeanAge = 0;
        Date currentDay = Utils.readDateFromConsole("\n Insert current day");
        int n = 0;
        double[] independentVariableY = new double[lineNumber];
        double[] independentVariableX = new double[lineNumber];

        String daysOrWeeks = Utils.readLineFromConsole("\n:Historical Points are in days or weeks? (D / W)");
        int historicalPoints = Utils.readIntegerFromConsole("\nNumber of historical points:");
        assert daysOrWeeks != null;
        if (daysOrWeeks.equals("D") || daysOrWeeks.equals("d")) {
            historicalPointsF = historicalPoints;
        } else if (daysOrWeeks.equals("W") || daysOrWeeks.equals("w")) {
            historicalPointsF = historicalPoints * 7;
        }
        while (n < lineNumber) {
            if (calendar[n].get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                n++;
            }
        }
        Date dateHP = DateUtils.addDays(currentDay, -historicalPointsF);

        List<Date> dateList3 = getDatesBetween(dateHP, currentDay);

        Date date1 = Utils.readDateFromConsole("\nInsert first date of the pretended interval of dates:");
        Date date2 = Utils.readDateFromConsole("\nInsert second date of the pretended interval of dates:");
        List<Date> dateList2 = getDatesBetween(date1, date2);
        int[] dateList2Rep = new int[dateList2.size()];
        int[] countIgGan = new int[igGan.length];
        SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < dateList2.size(); i++) {
            for (int j = 0; j < lineNumber; j++) {

                if (dt1.format(dateList2.get(i)).equals(dt1.format(date[j]))) {
                    dateList2Rep[i] = dateList2Rep[i] + 1;
                    if (igGan[j] > 1.4) {
                        countIgGan[i]++;

                    }
                }

            }

        }

        String regressionModel = Utils.readLineFromConsole("\nChoose the regression model to be used:");
        while (true) {
            assert regressionModel != null;
            if (!(!regressionModel.equals("slr") && !regressionModel.equals("mlr"))) break;
            regressionModel = Utils.readLineFromConsole("\nChoose the regression model to be used:");
        }
        if (regressionModel.equals("slr")) {
            String choiceX = Utils.readLineFromConsole("\nChoose the independent variable to be used as x (mean age / number day tests):");
            predictor = 1;
            n = 0;
            assert choiceX != null;
            if (choiceX.equals("mean age")) {
                while (n < lineNumber) {
                    if (calendar[n].get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                        long diff = currentDay.getTime() - date[n].getTime();
                        meanAge[n] = (int) (diff / (24 * 60 * 60 * 1000));
                        totalMeanAge = totalMeanAge + meanAge[n];
                        n++;
                    }
                    totalMeanAge = totalMeanAge / meanAge.length;
                    independentVariableX[0] = totalMeanAge;
                }

            } else if (choiceX.equals("number day tests")) {
                for (int i = 0; i < dateList2Rep.length; i++) {
                    if (dateList2Rep[i] != 0.0)
                        independentVariableX[i] = dateList2Rep[i];
                }

            }
        } else {
            predictor = 2;
            n = 0;
            while (n < lineNumber) {
                if (calendar[n].get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                    long diff = currentDay.getTime() - date[n].getTime();
                    meanAge[n] = (int) (diff / (24 * 60 * 60 * 1000));

                    totalMeanAge = totalMeanAge + meanAge[n];
                    n++;

                }

            }
            totalMeanAge = totalMeanAge / meanAge.length;
            independentVariableX[0] = totalMeanAge;
            for (int i = 1; i < dateList2Rep.length; i++) {
                if (dateList2Rep[i] != 0)
                    independentVariableX[i] = dateList2Rep[i];
            }
        }

        int i;


        for (n = 0; n < countIgGan.length; n++) {
            independentVariableY[n] = countIgGan[n];
        }
        LinearRegression linearRegression = new LinearRegression(independentVariableX, independentVariableY);

        //<!--------- rep       -----------------------------------------
        double R2adjusted = 1 - ((1 - linearRegression.R2()) * (independentVariableX.length) - 1) / (independentVariableX.length - predictor - 1);
        double df1 = independentVariableY.length - (independentVariableX.length + 1);
        double df2 = independentVariableY.length - (independentVariableY.length);
        int sum2 = 0;
        for (i = 1; i <= independentVariableY.length; i++)
            sum2 += (i * i);
        int sum1 = 0;
        for (i = 1; i <= independentVariableY.length - 1; i++)
            sum1 += (i * i);
        double MSE = sum1 / df1;
        double MSED = sum2 - sum1 / df2 - df1;
        double fval = MSED / MSE;
        double totalDf = df2 + df1;
        double totalSum = sum1 + sum2;
        int[] dateList3Rep = new int[dateList3.size()];
        int[] countIgGan2 = new int[dateList3.size()];
        double R = Math.sqrt(linearRegression.R2());

        for (i = 0; i < dateList3.size(); i++) {
            for (int j = 0; j < lineNumber; j++) {

                if (dt1.format(dateList3.get(i)).equals(dt1.format(date[j]))) {
                    dateList3Rep[i] = dateList3Rep[i] + 1;
                    if (igGan[j] > 1.4) {
                        countIgGan2[i]++;

                    }
                }

            }

        }
        String rep = "The regression model fitted using data from the interval\n" +
                "y= " + linearRegression + "\n" +
                "R2adjusted= " + R2adjusted + "\n" +
                "R = " + R + "\n" +
                "Hypothesis tests for regression coefficients\n" +
                "HO:b=0 (a=0) H1: b<>0 (a<>0)\n" +
                "t_obs=" + "\n" +
                "Decision: \n" +
                "Reject H0/ No reject H0\n" +
                "Significance model with Anova\n" +
                "H0: b=0  H1:b<>0 \n" +
                "\t\tdf\tSS\t\tMS\t\tF\t\t\n" +
                "Regression\t" + df1 + "\t" + sum1 + "\t" + MSE + "\t" + fval + "\t\n" +
                "Residual\t" + df2 + "\t" + sum2 + "\t " + MSED + "\t\t\n" +
                "Total\t\t" + totalDf + "\t" + totalSum + "\n" +
                "" + returnList(dateList3, countIgGan2);

        System.out.println(rep);
        return rep;
    }

    public List<String> returnList(List<Date> dateList3, int[] countIgGan2) {
        List<String> listToReturn = new ArrayList<>();
        for (int i = 0; i < dateList3.size(); i++) {
            if (i % 2 == 0) {
                listToReturn.add(String.valueOf(dateList3.get(i)));
            } else {
                listToReturn.add(String.valueOf(countIgGan2[i]));
            }
        }
        return listToReturn;
    }

    public void sendAutoRep(String rep) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));

        if (dtf.format(now).equals("06:00:00")) {
            ctrl.createRep(rep);
            File file = new File("./NHSReport/logfile.txt");
            FileWriter fr = null;

            try {
                fr = new FileWriter(file);
                fr.write("report was sent at 6:00 am successfully");
            } catch (IOException var12) {
                var12.printStackTrace();
            } finally {
                try {
                    assert fr != null;
                    fr.close();
                } catch (IOException var11) {
                    var11.printStackTrace();
                }
            }
        }
    }
}



