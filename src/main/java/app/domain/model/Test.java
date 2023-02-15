package app.domain.model;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Test implements Comparable<Test> {
    /**
     * Code of the test
     */
    private long testCode;
    /**
     * Nhs code of the test
     */
    private String nhsCode;
    /**
     * Designation of the test
     */
    private String testDesignation;
    /**
     * Citizen card number of the client
     */
    private long ccNumber;
    /**
     * Test type of the test
     */
    private String testType;
    /**
     * Parameter Category of the test
     */
    private ArrayList<String> parameterCategoryList;
    /**
     * Parameter of the test
     */
    private ArrayList<String> parameterList;
    /**
     * State of the test
     */
    public String state;
    /**
     * Date of the test
     */
    private Date date;

    /**
     * @param testCode Code of the test
     * @param nhsCode Nhs code of the test
     * @param testDesignation Designation of the test
     * @param ccNumber Citizen card number of the client
     * @param testType Test type of the test
     * @param parameterCategoryList Parameter Category of the test
     * @param parameterList Parameter of the test
     * @param state State of the test
     * @param date Date of the test
     */
    public Test(long testCode, String nhsCode, String testDesignation, long ccNumber, String testType, ArrayList<String> parameterCategoryList,
                ArrayList<String> parameterList, String state, Date date)
    {
        checkTestCode(testCode);
        checkNhsCode(nhsCode);
        checkTestDesignation(testDesignation);
        checkCardNumber(ccNumber);
        checkTestType(testType);
        checkParameterCategoryList(parameterCategoryList);
        checkParameterList(parameterList);

        setTestCode(testCode);
        setNHSCode(nhsCode);
        setTestDesignation(testDesignation);
        setCCNumber(ccNumber);
        setTestType(testType);
        setParameterCategoryList(parameterCategoryList);
        setParameterList(parameterList);
        setState(state);
        setDate(date);
    }

    /**
     * @param testCode Method that verifies if the test code of the new test follows the acceptance criteria
     */
    public static void checkTestCode(long testCode)
    {
        String k = String.valueOf(testCode);
        if (k.length() == 0)
            throw new IllegalArgumentException("Test Code cannot be blank.");
        if (k.length() > 12)
            throw new IllegalArgumentException("Test Code must have less than 12 digits.");
    }

    /**
     * @param nhsCode Method that verifies if the nhs Code of the new test follows the acceptance criteria
     */
    public static void checkNhsCode(String nhsCode)
    {
        if (StringUtils.isBlank(nhsCode))
            throw new IllegalArgumentException("Nhs Code cannot be blank.");
        if (nhsCode.length() > 12)
            throw new IllegalArgumentException("Nhs Code must have less than 12 digits.");
    }

    /**
     * @param testDesignation Method that verifies if the test designation of the new test follows the acceptance criteria
     */
    public static void checkTestDesignation(String testDesignation)
    {
        if (StringUtils.isBlank(testDesignation))
            throw new IllegalArgumentException("Test Designation cannot be blank.");
        if (testDesignation.length() > 30)
            throw new IllegalArgumentException("Test Designation must have less than 30 characters.");
    }

    /**
     * @param ccNumber Method that verifies if the citizen card number of the new test follows the acceptance criteria
     */
    public static void checkCardNumber(long ccNumber)
    {
        String k = String.valueOf(ccNumber);
        if (k.length() == 0)
            throw new IllegalArgumentException("ccNumber cannot be blank.");
        if (k.length() != 16)
            throw new IllegalArgumentException("ccNumber must have 16 digits.");
    }

    /**
     * @param testtype Method that verifies if the test type of the new test follows the acceptance criteria
     */
    public static void checkTestType(String testtype)
    {
        if (StringUtils.isBlank(testtype))
            throw new IllegalArgumentException("Test type cannot be blank.");
    }

    /**
     * @param parameterCategoryList Method that verifies if the parameter category list of the new test follows the acceptance criteria
     */
    public static void checkParameterCategoryList(ArrayList<String> parameterCategoryList)
    {
        if (parameterCategoryList.isEmpty())
            throw new IllegalArgumentException("Parameter Category cannot be blank.");
    }

    /**
     * @param parameterList Method that verifies if the parameter list of the new test follows the acceptance criteria
     */
    private void checkParameterList(ArrayList<String> parameterList)
    {
        if (parameterList.isEmpty())
            throw new IllegalArgumentException("Parameter List cannot be blank.");
    }

    public long getTestCode() { return testCode; }

    public void setTestCode(long testCode) { this.testCode = testCode; }

    public String getNHSCode() { return nhsCode; }

    public void setNHSCode(String nhsCode) { this.nhsCode = nhsCode; }

    public String getTestDesignation() { return testDesignation; }

    public void setTestDesignation(String testDesignation) { this.testDesignation = testDesignation; }

    public long getCCNumber() { return ccNumber; }

    public void setCCNumber(long ccNumber) { this.ccNumber = ccNumber; }

    public String getTestType(){
        return testType;
    }

    public void setTestType(String testType) { this.testType = testType; }

    public ArrayList<String> getParameterCategoryList() {
        return parameterCategoryList;
    }

    public void setParameterCategoryList(ArrayList<String> parameterCategoryList) { this.parameterCategoryList = parameterCategoryList; }

    public ArrayList<String> getParameterList() {
        return parameterList;
    }

    public void setParameterList(ArrayList<String> parameterList) { this.parameterList = parameterList; }

    public String getState() { return state; }

    public void setState(String state) {
        this.state = state;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return Objects.equals(testCode, test.testCode) && Objects.equals(nhsCode, test.nhsCode) && Objects.equals(testDesignation, test.testDesignation)
                && Objects.equals(ccNumber, test.ccNumber) && Objects.equals(testType, test.testType) && Objects.equals(parameterCategoryList, test.parameterCategoryList)
                && Objects.equals(parameterList, test.parameterList) && Objects.equals(state, test.state) && Objects.equals(date, test.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(testCode, nhsCode, testDesignation, ccNumber, testType, parameterCategoryList, parameterList, state, date);
    }

    @Override
    public String toString() {
        return "\nTest code: " + testCode +
                "\nNhs code: " + nhsCode +
                "\nTest designation: " + testDesignation +
                "\nccNumber: " + ccNumber +
                "\nTest Type: " + testType +
                "\nParameter Category List: " + parameterCategoryList +
                "\nParameter List: " + parameterList +
                "\nState: " + state +
                "\nDate: " + date;
    }

    @Override
    public int compareTo(Test o) {
        if (getDate() == null || o.getDate() == null)
            return 0;
        return getDate().compareTo(o.getDate());
    }
}
