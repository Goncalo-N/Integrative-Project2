package app.domain.model;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TestTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensureTestCodeNotNull()
    {
        Company company = new Company("ManyLabs");

        long testCode = Long.parseLong(null);

        String nhsCode = "123456789012";

        String textDesignation = "Designation";

        long ccNumber = 1234567890123456L;

        String testType = "Blood";

        ArrayList<String> testParameterCategoryList = new ArrayList<>();
        ArrayList<String> testParameterList = new ArrayList<>();

        testParameterCategoryList.add("CategoryName");
        testParameterList.add("ParName");

        String state = "Valid";

        Calendar calendar = Calendar.getInstance();

        Date date = calendar.getTime();

        company.testingTest(testCode, nhsCode, textDesignation, ccNumber, testType, testParameterCategoryList, testParameterList, state, date);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureTestCodeNotBiggerThan12Digits()
    {
        Company company = new Company("ManyLabs");

        long testCode = 1234567890123L;

        String nhsCode = "123456789012";

        String textDesignation = "Designation";

        long ccNumber = 1234567890123456L;

        String testType = "Blood";

        ArrayList<String> testParameterCategoryList = new ArrayList<>();
        ArrayList<String> testParameterList = new ArrayList<>();

        testParameterCategoryList.add("CategoryName");
        testParameterList.add("ParName");

        String state = "Valid";

        Calendar calendar = Calendar.getInstance();

        Date date = calendar.getTime();

        company.testingTest(testCode, nhsCode, textDesignation, ccNumber, testType, testParameterCategoryList, testParameterList, state, date);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNHSCodeNotNull()
    {
        Company company = new Company("ManyLabs");

        long testCode = 123456789012L;

        String nhsCode = "";

        String textDesignation = "Designation";

        long ccNumber = 1234567890123456L;

        String testType = "Blood";

        ArrayList<String> testParameterCategoryList = new ArrayList<>();
        ArrayList<String> testParameterList = new ArrayList<>();

        testParameterCategoryList.add("CategoryName");
        testParameterList.add("ParName");

        String state = "Valid";

        Calendar calendar = Calendar.getInstance();

        Date date = calendar.getTime();

        company.testingTest(testCode, nhsCode, textDesignation, ccNumber, testType, testParameterCategoryList, testParameterList, state, date);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNHSCodeNotBiggerThan12Digits()
    {
        Company company = new Company("ManyLabs");

        long testCode = 123456789012L;

        String nhsCode = "1234567890123";

        String textDesignation = "Designation";

        long ccNumber = 1234567890123456L;

        String testType = "Blood";

        ArrayList<String> testParameterCategoryList = new ArrayList<>();
        ArrayList<String> testParameterList = new ArrayList<>();

        testParameterCategoryList.add("CategoryName");
        testParameterList.add("ParName");

        String state = "Valid";

        Calendar calendar = Calendar.getInstance();

        Date date = calendar.getTime();

        company.testingTest(testCode, nhsCode, textDesignation, ccNumber, testType, testParameterCategoryList, testParameterList, state, date);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureTestDesignationNotNull()
    {
        Company company = new Company("ManyLabs");

        long testCode = 123456789012L;

        String nhsCode = "123456789012";

        String textDesignation = "";

        long ccNumber = 1234567890123456L;

        String testType = "Blood";

        ArrayList<String> testParameterCategoryList = new ArrayList<>();
        ArrayList<String> testParameterList = new ArrayList<>();

        testParameterCategoryList.add("CategoryName");
        testParameterList.add("ParName");

        String state = "Valid";

        Calendar calendar = Calendar.getInstance();

        Date date = calendar.getTime();

        company.testingTest(testCode, nhsCode, textDesignation, ccNumber, testType, testParameterCategoryList, testParameterList, state, date);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureTestDesignationNotBiggerThan30Digits()
    {
        Company company = new Company("ManyLabs");

        long testCode = 123456789012L;

        String nhsCode = "123456789012";

        String textDesignation = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        long ccNumber = 1234567890123456L;

        String testType = "Blood";

        ArrayList<String> testParameterCategoryList = new ArrayList<>();
        ArrayList<String> testParameterList = new ArrayList<>();

        testParameterCategoryList.add("CategoryName");
        testParameterList.add("ParName");

        String state = "Valid";

        Calendar calendar = Calendar.getInstance();

        Date date = calendar.getTime();

        company.testingTest(testCode, nhsCode, textDesignation, ccNumber, testType, testParameterCategoryList, testParameterList, state, date);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCCNumberNotNull()
    {
        Company company = new Company("ManyLabs");

        long testCode = 123456789012L;

        String nhsCode = "123456789012";

        String textDesignation = "Designation";

        long ccNumber = 0;

        String testType = "Blood";

        ArrayList<String> testParameterCategoryList = new ArrayList<>();
        ArrayList<String> testParameterList = new ArrayList<>();

        testParameterCategoryList.add("CategoryName");
        testParameterList.add("ParName");

        String state = "Valid";

        Calendar calendar = Calendar.getInstance();

        Date date = calendar.getTime();

        company.testingTest(testCode, nhsCode, textDesignation, ccNumber, testType, testParameterCategoryList, testParameterList, state, date);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCCNumberNotDifferentThan16Digits()
    {
        Company company = new Company("ManyLabs");

        long testCode = 123456789012L;

        String nhsCode = "123456789012";

        String textDesignation = "Designation";

        long ccNumber = 12345678901234567L;

        String testType = "Blood";

        ArrayList<String> testParameterCategoryList = new ArrayList<>();
        ArrayList<String> testParameterList = new ArrayList<>();

        testParameterCategoryList.add("CategoryName");
        testParameterList.add("ParName");

        String state = "Valid";

        Calendar calendar = Calendar.getInstance();

        Date date = calendar.getTime();

        company.testingTest(testCode, nhsCode, textDesignation, ccNumber, testType, testParameterCategoryList, testParameterList, state, date);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureTestTypeNotNull()
    {
        Company company = new Company("ManyLabs");

        long testCode = 123456789012L;

        String nhsCode = "123456789012";

        String textDesignation = "Designation";

        long ccNumber = 1234567890123456L;

        String testType = "";

        ArrayList<String> testParameterCategoryList = new ArrayList<>();
        ArrayList<String> testParameterList = new ArrayList<>();

        testParameterCategoryList.add("CategoryName");
        testParameterList.add("ParName");

        String state = "Valid";

        Calendar calendar = Calendar.getInstance();

        Date date = calendar.getTime();

        company.testingTest(testCode, nhsCode, textDesignation, ccNumber, testType, testParameterCategoryList, testParameterList, state, date);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureParameterCategoryListNotNull()
    {
        Company company = new Company("ManyLabs");

        long testCode = 123456789012L;

        String nhsCode = "123456789012";

        String textDesignation = "Designation";

        long ccNumber = 1234567890123456L;

        String testType = "blood";

        ArrayList<String> testParameterCategoryList = new ArrayList<>();
        ArrayList<String> testParameterList = new ArrayList<>();

        testParameterList.add("ParName");

        String state = "Valid";

        Calendar calendar = Calendar.getInstance();

        Date date = calendar.getTime();

        company.testingTest(testCode, nhsCode, textDesignation, ccNumber, testType, testParameterCategoryList, testParameterList, state, date);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureParameterListNotNull()
    {
        Company company = new Company("ManyLabs");

        long testCode = 123456789012L;

        String nhsCode = "123456789012";

        String textDesignation = "Designation";

        long ccNumber = 1234567890123456L;

        String testType = "blood";

        ArrayList<String> testParameterCategoryList = new ArrayList<>();
        ArrayList<String> testParameterList = new ArrayList<>();

        testParameterCategoryList.add("CategoryName");

        String state = "Valid";

        Calendar calendar = Calendar.getInstance();

        Date date = calendar.getTime();

        company.testingTest(testCode, nhsCode, textDesignation, ccNumber, testType, testParameterCategoryList, testParameterList, state, date);
    }

    @Test
    public void testGetsTestCode()
    {
        ArrayList <String> testParameterCategoryList = new ArrayList<>();
        testParameterCategoryList.add("CategoryName");

        ArrayList <String> testParameterList = new ArrayList<>();
        testParameterList.add("ParName");

        String sDate1="01/06/2021";
        Date date1 = null;
        String pattern = "dd/MM/yyyy";

        try { date1 = new SimpleDateFormat(pattern).parse(sDate1); }
        catch (ParseException e) { e.printStackTrace(); }

        app.domain.model.Test test = new app.domain.model.Test(1, "123", "Designation1", 1234567890123456L, "blood", testParameterCategoryList, testParameterList, "Valid", date1);

        long expectedTestCode = 1;
        assertEquals(test.getTestCode(),expectedTestCode);
    }

    @Test
    public void testSetsTestCode()
    {
        ArrayList <String> testParameterCategoryList = new ArrayList<>();
        testParameterCategoryList.add("CategoryName");

        ArrayList <String> testParameterList = new ArrayList<>();
        testParameterList.add("ParName");

        String sDate1="01/06/2021";
        Date date1 = null;
        String pattern = "dd/MM/yyyy";

        try { date1 = new SimpleDateFormat(pattern).parse(sDate1); }
        catch (ParseException e) { e.printStackTrace(); }

        app.domain.model.Test test = new app.domain.model.Test(1, "123", "Designation1", 1234567890123456L, "blood", testParameterCategoryList, testParameterList, "Valid", date1);

        long testCode = 1;
        test.setTestCode(testCode);
        assertEquals(test.getTestCode(), testCode);
    }

    @Test
    public void testGetsNHSCode()
    {
        ArrayList <String> testParameterCategoryList = new ArrayList<>();
        testParameterCategoryList.add("CategoryName");

        ArrayList <String> testParameterList = new ArrayList<>();
        testParameterList.add("ParName");

        String sDate1="01/06/2021";
        Date date1 = null;
        String pattern = "dd/MM/yyyy";

        try { date1 = new SimpleDateFormat(pattern).parse(sDate1); }
        catch (ParseException e) { e.printStackTrace(); }

        app.domain.model.Test test = new app.domain.model.Test(1, "123", "Designation1", 1234567890123456L, "blood", testParameterCategoryList, testParameterList, "Valid", date1);

        String expectedNHSCode = "123";
        assertEquals(test.getNHSCode(),expectedNHSCode);
    }

    @Test
    public void testSetsNHSCode()
    {
        ArrayList <String> testParameterCategoryList = new ArrayList<>();
        testParameterCategoryList.add("CategoryName");

        ArrayList <String> testParameterList = new ArrayList<>();
        testParameterList.add("ParName");

        String sDate1="01/06/2021";
        Date date1 = null;
        String pattern = "dd/MM/yyyy";

        try { date1 = new SimpleDateFormat(pattern).parse(sDate1); }
        catch (ParseException e) { e.printStackTrace(); }

        app.domain.model.Test test = new app.domain.model.Test(1, "123", "Designation1", 1234567890123456L, "blood", testParameterCategoryList, testParameterList, "Valid", date1);

        String NHSCode = "123";
        test.setNHSCode(NHSCode);
        assertEquals(test.getNHSCode(), NHSCode);
    }

    @Test
    public void testGetsTestDesignation()
    {
        ArrayList <String> testParameterCategoryList = new ArrayList<>();
        testParameterCategoryList.add("CategoryName");

        ArrayList <String> testParameterList = new ArrayList<>();
        testParameterList.add("ParName");

        String sDate1="01/06/2021";
        Date date1 = null;
        String pattern = "dd/MM/yyyy";

        try { date1 = new SimpleDateFormat(pattern).parse(sDate1); }
        catch (ParseException e) { e.printStackTrace(); }

        app.domain.model.Test test = new app.domain.model.Test(1, "123", "Designation1", 1234567890123456L, "blood", testParameterCategoryList, testParameterList, "Valid", date1);

        String expectedTestDesignation = "Designation1";
        assertEquals(test.getTestDesignation(),expectedTestDesignation);
    }

    @Test
    public void testSetsTestDesignation()
    {
        ArrayList <String> testParameterCategoryList = new ArrayList<>();
        testParameterCategoryList.add("CategoryName");

        ArrayList <String> testParameterList = new ArrayList<>();
        testParameterList.add("ParName");

        String sDate1="01/06/2021";
        Date date1 = null;
        String pattern = "dd/MM/yyyy";

        try { date1 = new SimpleDateFormat(pattern).parse(sDate1); }
        catch (ParseException e) { e.printStackTrace(); }

        app.domain.model.Test test = new app.domain.model.Test(1, "123", "Designation1", 1234567890123456L, "blood", testParameterCategoryList, testParameterList, "Valid", date1);

        String TestDesignation = "Designation1";
        test.setTestDesignation(TestDesignation);
        assertEquals(test.getTestDesignation(), TestDesignation);
    }

    @Test
    public void testGetsCCNumber()
    {
        ArrayList <String> testParameterCategoryList = new ArrayList<>();
        testParameterCategoryList.add("CategoryName");

        ArrayList <String> testParameterList = new ArrayList<>();
        testParameterList.add("ParName");

        String sDate1="01/06/2021";
        Date date1 = null;
        String pattern = "dd/MM/yyyy";

        try { date1 = new SimpleDateFormat(pattern).parse(sDate1); }
        catch (ParseException e) { e.printStackTrace(); }

        app.domain.model.Test test = new app.domain.model.Test(1, "123", "Designation1", 1234567890123456L, "blood", testParameterCategoryList, testParameterList, "Valid", date1);

        long expectedCCNumber = 1234567890123456L;
        assertEquals(test.getCCNumber(),expectedCCNumber);
    }

    @Test
    public void testSetsCCNumber()
    {
        ArrayList <String> testParameterCategoryList = new ArrayList<>();
        testParameterCategoryList.add("CategoryName");

        ArrayList <String> testParameterList = new ArrayList<>();
        testParameterList.add("ParName");

        String sDate1="01/06/2021";
        Date date1 = null;
        String pattern = "dd/MM/yyyy";

        try { date1 = new SimpleDateFormat(pattern).parse(sDate1); }
        catch (ParseException e) { e.printStackTrace(); }

        app.domain.model.Test test = new app.domain.model.Test(1, "123", "Designation1", 1234567890123456L, "blood", testParameterCategoryList, testParameterList, "Valid", date1);

        long CCNumber = 1234567890123456L;
        test.setCCNumber(CCNumber);
        assertEquals(test.getCCNumber(), CCNumber);
    }

    @Test
    public void testGetsTestType()
    {
        ArrayList <String> testParameterCategoryList = new ArrayList<>();
        testParameterCategoryList.add("CategoryName");

        ArrayList <String> testParameterList = new ArrayList<>();
        testParameterList.add("ParName");

        String sDate1="01/06/2021";
        Date date1 = null;
        String pattern = "dd/MM/yyyy";

        try { date1 = new SimpleDateFormat(pattern).parse(sDate1); }
        catch (ParseException e) { e.printStackTrace(); }

        app.domain.model.Test test = new app.domain.model.Test(1, "123", "Designation1", 1234567890123456L, "blood", testParameterCategoryList, testParameterList, "Valid", date1);

        String expectedTestType = "blood";
        assertEquals(test.getTestType(),expectedTestType);
    }

    @Test
    public void testSetsTestType()
    {
        ArrayList <String> testParameterCategoryList = new ArrayList<>();
        testParameterCategoryList.add("CategoryName");

        ArrayList <String> testParameterList = new ArrayList<>();
        testParameterList.add("ParName");

        String sDate1="01/06/2021";
        Date date1 = null;
        String pattern = "dd/MM/yyyy";

        try { date1 = new SimpleDateFormat(pattern).parse(sDate1); }
        catch (ParseException e) { e.printStackTrace(); }

        app.domain.model.Test test = new app.domain.model.Test(1, "123", "Designation1", 1234567890123456L, "blood", testParameterCategoryList, testParameterList, "Valid", date1);

        String TestType = "blood";
        test.setTestType(TestType);
        assertEquals(test.getTestType(), TestType);
    }

    @Test
    public void testGetsParameterCategoryList()
    {
        ArrayList <String> expectedParameterCategoryList = new ArrayList<>();
        expectedParameterCategoryList.add("CategoryName");

        ArrayList <String> testParameterList = new ArrayList<>();
        testParameterList.add("ParName");

        String sDate1="01/06/2021";
        Date date1 = null;
        String pattern = "dd/MM/yyyy";

        try { date1 = new SimpleDateFormat(pattern).parse(sDate1); }
        catch (ParseException e) { e.printStackTrace(); }

        app.domain.model.Test test = new app.domain.model.Test(1, "123", "Designation1", 1234567890123456L, "blood", expectedParameterCategoryList, testParameterList, "Valid", date1);

        assertEquals(test.getParameterCategoryList(),expectedParameterCategoryList);
    }

    @Test
    public void testSetsParameterCategoryList()
    {
        ArrayList <String> testParameterCategoryList = new ArrayList<>();
        testParameterCategoryList.add("CategoryName");

        ArrayList <String> testParameterList = new ArrayList<>();
        testParameterList.add("ParName");

        String sDate1="01/06/2021";
        Date date1 = null;
        String pattern = "dd/MM/yyyy";

        try { date1 = new SimpleDateFormat(pattern).parse(sDate1); }
        catch (ParseException e) { e.printStackTrace(); }

        app.domain.model.Test test = new app.domain.model.Test(1, "123", "Designation1", 1234567890123456L, "blood", testParameterCategoryList, testParameterList, "Valid", date1);

        test.setParameterCategoryList(testParameterCategoryList);
        assertEquals(test.getParameterCategoryList(), testParameterCategoryList);
    }

    @Test
    public void testGetsParameterList()
    {
        ArrayList <String> expectedParameterCategoryList = new ArrayList<>();
        expectedParameterCategoryList.add("CategoryName");

        ArrayList <String> expectedParameterList = new ArrayList<>();
        expectedParameterList.add("ParName");

        String sDate1="01/06/2021";
        Date date1 = null;
        String pattern = "dd/MM/yyyy";

        try { date1 = new SimpleDateFormat(pattern).parse(sDate1); }
        catch (ParseException e) { e.printStackTrace(); }

        app.domain.model.Test test = new app.domain.model.Test(1, "123", "Designation1", 1234567890123456L, "blood", expectedParameterCategoryList, expectedParameterList, "Valid", date1);

        assertEquals(test.getParameterList(),expectedParameterList);
    }

    @Test
    public void testSetsParameterList()
    {
        ArrayList <String> testParameterCategoryList = new ArrayList<>();
        testParameterCategoryList.add("CategoryName");

        ArrayList <String> testParameterList = new ArrayList<>();
        testParameterList.add("ParName");

        String sDate1="01/06/2021";
        Date date1 = null;
        String pattern = "dd/MM/yyyy";

        try { date1 = new SimpleDateFormat(pattern).parse(sDate1); }
        catch (ParseException e) { e.printStackTrace(); }

        app.domain.model.Test test = new app.domain.model.Test(1, "123", "Designation1", 1234567890123456L, "blood", testParameterCategoryList, testParameterList, "Valid", date1);

        test.setParameterList(testParameterList);
        assertEquals(test.getParameterList(), testParameterList);
    }

    /*
    @Test
    public void createCAL()
    {
        ArrayList <String> CALTestList = new ArrayList<>();
        CALTestList.add("blood");
        CALTestList.add("covid19");

        Company company = new Company("Many Labs");

        CAL cal = company.createCAL("12345", "qwe", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", "12345678901", "1234567890",  CALTestList);

        CAL result = company.createCAL("12345", "qwe", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", "12345678901", "1234567890",  CALTestList);

        assertEquals(cal, result);
    }

    @Test
    public void validateCAL()
    {
        ArrayList <String> CALTestList = new ArrayList<>();
        CALTestList.add("blood");
        CALTestList.add("covid19");

        CAL cal = new CAL("12345", "qwe", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", "12345678901", "1234567890",  CALTestList);

        Company company = new Company("Many Labs");

        boolean result = false;

        if(company.validateCAL(cal)){
            result = true;
        }

        assertTrue(result);
    }

     */
    /*
    @Test
    public void saveCAL()
    {
        ArrayList <String> CALTestList = new ArrayList<>();
        CALTestList.add("blood");
        CALTestList.add("covid19");

        CAL cal = new CAL("12345", "qwe", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", "12345678901", "1234567890",  CALTestList);

        Company company = new Company("Many Labs");

        boolean result = company.saveCAL(cal);

        assertTrue(result);
    }

    @Test
    public void toStringCAL()
    {
        ArrayList <String> CALTestList = new ArrayList<>();
        CALTestList.add("blood");
        CALTestList.add("covid19");

        CAL cal = new CAL("12345", "qwe", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", "12345678901", "1234567890",  CALTestList);

        String toString = cal.toString();
        String toString2 = cal.toString();

        assertEquals(toString, toString2);
    }
    */
}
