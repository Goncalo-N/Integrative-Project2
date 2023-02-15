package app.domain.model;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class RepTest {

      /*  @Test(expected = IllegalArgumentException.class)
        public void ensureRepNotNull()
        {
            Company company = new Company("ManyLabs");
            String rep = null;

            company.testingRep(rep);
        }*/

    @Test
    public void testGetsHistoricalPoints()
    {
        String sDate1="01/06/2021";

        String sDate2="05/06/2021";

        String pattern = "dd/MM/yyyy";
        Date[] dateInterval = new Date[2];
        try { dateInterval[0] = new SimpleDateFormat(pattern).parse(sDate1);
         dateInterval[1] = new SimpleDateFormat(pattern).parse(sDate2); }
        catch (ParseException e) { e.printStackTrace(); }

        int [] independentVariableX = {1,3,5};
        int [] independentVariableY = {5,2,4};

        Rep rep = new Rep(15, dateInterval, "slr", independentVariableX, independentVariableY);

        int historicalPointsExpected = 15;
        assertEquals(rep.getHistoricalPoints(),historicalPointsExpected);
    }

    @Test
    public void testSetsHistoricalPoints()
    {
        String sDate1="01/06/2021";

        String sDate2="05/06/2021";

        String pattern = "dd/MM/yyyy";
        Date[] dateInterval = new Date[2];
        try { dateInterval[0] = new SimpleDateFormat(pattern).parse(sDate1);
            dateInterval[1] = new SimpleDateFormat(pattern).parse(sDate2); }
        catch (ParseException e) { e.printStackTrace(); }

        int [] independentVariableX = {1,3,5};
        int [] independentVariableY = {5,2,4};

        Rep rep = new Rep(15, dateInterval, "slr", independentVariableX, independentVariableY);

        int historicalPoints = 15;
        rep.setHistoricalPoints(historicalPoints);
        assertEquals(rep.getHistoricalPoints(), historicalPoints);
    }
    @Test
    public void testGetsDateInterval()
    {
        String sDate1="01/06/2021";

        String sDate2="05/06/2021";

        String pattern = "dd/MM/yyyy";
        Date[] dateInterval = new Date[2];
        try { dateInterval[0] = new SimpleDateFormat(pattern).parse(sDate1);
            dateInterval[1] = new SimpleDateFormat(pattern).parse(sDate2); }
        catch (ParseException e) { e.printStackTrace(); }

        int [] independentVariableX = {1,3,5};
        int [] independentVariableY = {5,2,4};

        Rep rep = new Rep(15, dateInterval, "slr", independentVariableX, independentVariableY);

        assertEquals(rep.getDateInterval(),dateInterval);
    }

    @Test
    public void testSetsDateInterval()
    {
        String sDate1="01/06/2021";

        String sDate2="05/06/2021";

        String pattern = "dd/MM/yyyy";
        Date[] dateInterval = new Date[2];
        try { dateInterval[0] = new SimpleDateFormat(pattern).parse(sDate1);
            dateInterval[1] = new SimpleDateFormat(pattern).parse(sDate2); }
        catch (ParseException e) { e.printStackTrace(); }

        int [] independentVariableX = {1,3,5};
        int [] independentVariableY = {5,2,4};

        Rep rep = new Rep(15, dateInterval, "slr", independentVariableX, independentVariableY);

        rep.setDateInterval(dateInterval);
        assertEquals(rep.getDateInterval(), dateInterval);
    }
    public void testGetRegressionModel()
    {
        String sDate1="01/06/2021";
        String sDate2="05/06/2021";
        String pattern = "dd/MM/yyyy";
        Date[] dateInterval = new Date[2];
        try { dateInterval[0] = new SimpleDateFormat(pattern).parse(sDate1);
            dateInterval[1] = new SimpleDateFormat(pattern).parse(sDate2); }
        catch (ParseException e) { e.printStackTrace(); }

        int [] independentVariableX = {1,3,5};
        int [] independentVariableY = {5,2,4};

        Rep rep = new Rep(15, dateInterval, "slr", independentVariableX, independentVariableY);

        String regressionModelExpected = "slr";
        assertEquals(rep.getRegressionModel(),regressionModelExpected);
    }

    @Test
    public void test()
    {
        String sDate1="01/06/2021";

        String sDate2="05/06/2021";

        String pattern = "dd/MM/yyyy";
        Date[] dateInterval = new Date[2];
        try { dateInterval[0] = new SimpleDateFormat(pattern).parse(sDate1);
            dateInterval[1] = new SimpleDateFormat(pattern).parse(sDate2); }
        catch (ParseException e) { e.printStackTrace(); }

        int [] independentVariableX = {1,3,5};
        int [] independentVariableY = {5,2,4};

        Rep rep = new Rep(15, dateInterval, "slr", independentVariableX, independentVariableY);

        String regressionModel = "slr";
        rep.setRegressionModel(regressionModel);
        assertEquals(rep.getRegressionModel(), regressionModel);
    }


    @Test
    public void testGetIndependentVariableX()
    {
        String sDate1="01/06/2021";

        String sDate2="05/06/2021";

        String pattern = "dd/MM/yyyy";
        Date[] dateInterval = new Date[2];
        try { dateInterval[0] = new SimpleDateFormat(pattern).parse(sDate1);
            dateInterval[1] = new SimpleDateFormat(pattern).parse(sDate2); }
        catch (ParseException e) { e.printStackTrace(); }

        int [] independentVariableX = {1,3,5};
        int [] independentVariableY = {5,2,4};

        Rep rep = new Rep(15, dateInterval, "slr", independentVariableX, independentVariableY);

        assertEquals(rep.getIndependantVariableX(),independentVariableX);
    }

    @Test
    public void testSetIndependentVariableX()
    {
        String sDate1="01/06/2021";

        String sDate2="05/06/2021";

        String pattern = "dd/MM/yyyy";
        Date[] dateInterval = new Date[2];
        try { dateInterval[0] = new SimpleDateFormat(pattern).parse(sDate1);
            dateInterval[1] = new SimpleDateFormat(pattern).parse(sDate2); }
        catch (ParseException e) { e.printStackTrace(); }

        int [] independentVariableX = {1,3,5};
        int [] independentVariableY = {5,2,4};

        Rep rep = new Rep(15, dateInterval, "slr", independentVariableX, independentVariableY);


        rep.setIndependantVariableX(independentVariableX);
        assertEquals(rep.getIndependantVariableX(), independentVariableX);
    }
    @Test
    public void testGetIndependentVariableY()
    {
        String sDate1="01/06/2021";

        String sDate2="05/06/2021";

        String pattern = "dd/MM/yyyy";
        Date[] dateInterval = new Date[2];
        try { dateInterval[0] = new SimpleDateFormat(pattern).parse(sDate1);
            dateInterval[1] = new SimpleDateFormat(pattern).parse(sDate2); }
        catch (ParseException e) { e.printStackTrace(); }

        int [] independentVariableX = {1,3,5};
        int [] independentVariableY = {5,2,4};

        Rep rep = new Rep(15, dateInterval, "slr", independentVariableX, independentVariableY);

        assertEquals(rep.getIndependantVariableY(),independentVariableY);
    }

    @Test
    public void testSetIndependentVariableY()
    {
        String sDate1="01/06/2021";

        String sDate2="05/06/2021";

        String pattern = "dd/MM/yyyy";
        Date[] dateInterval = new Date[2];
        try { dateInterval[0] = new SimpleDateFormat(pattern).parse(sDate1);
            dateInterval[1] = new SimpleDateFormat(pattern).parse(sDate2); }
        catch (ParseException e) { e.printStackTrace(); }

        int [] independentVariableX = {1,3,5};
        int [] independentVariableY = {5,2,4};

        Rep rep = new Rep(15, dateInterval, "slr", independentVariableX, independentVariableY);


        rep.setIndependantVariableY(independentVariableY);
        assertEquals(rep.getIndependantVariableY(), independentVariableY);
    }
}