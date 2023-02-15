package app.controller;

import app.domain.model.*;
import app.domain.shared.Constants;

import java.text.ParseException;
import java.util.*;

public class CreateTestController
{
    /**
     * Company
     */
    private final Company company;
    /**
     * Test of test
     */
    private Test test;
    /**
     * Test type of the test
     */
    public TestType testType;
    /**
     * State of the test
     */
    public String state;

    Calendar calendar = Calendar.getInstance();

    public CreateTestController(){ this(App.getInstance().getCompany()); }

    /**
     * @param company company
     */
    public CreateTestController(Company company){
        checkUserAuth();
        this.company = company;
        this.test = null;
    }

    /**
     * check user role
     */
    private void checkUserAuth(){
        boolean loggedInWithRole = App.getInstance().getCurrentUserSession().isLoggedInWithRole(Constants.ROLE_RECEPTIONIST);
        if (!loggedInWithRole)
            throw new IllegalStateException("User has no permission to do this operation.");
    }

    /**
     * @param testCode Code of the test
     * @param nhsCode Nhs code of the test
     * @param testDesignation Designation of the test
     * @param ccNumber Citizen card number of the client
     * @param testType Test type of the test
     * @param parameterCategoryList Parameter Category of the test
     * @param parameterList Parameter of the test
     * @param state State of the test
     * @return test
     */
    public boolean createTest(long testCode, String nhsCode, String testDesignation, long ccNumber, String testType, ArrayList<String> parameterCategoryList,
                              ArrayList<String> parameterList, String state) throws ParseException {
        this.test = this.company.createTest(testCode, nhsCode, testDesignation, ccNumber, testType, parameterCategoryList, parameterList, state);
        return this.company.validateTest(test);
    }

    /**
     * @return test
     */
    public boolean saveTest()
    {
        return this.company.saveTest(test);
    }

    /**
     * @return test list of test
     */
    public ArrayList<Test> getTestList() {
        return this.company.getTestList();
    }

    /**
     * @return test type list of test type
     */
    public ArrayList<TestType> getTestTypeList() {
        return this.company.getTestTypeList();
    }

    /**
     * @return parameter category list of test
     */
    public ArrayList<ParameterCategory> getParameterCategoryList() {
        return this.company.getParameterCategoryList();
    }

    /**
     * @return parameter list of test
     */
    public ArrayList<Parameter> getParameterList() {
        return this.company.getParameterList();
    }

    public ArrayList<Parameter> getInstanceOfParameterCategory(String code){
        return this.company.getInstanceOfParameterCategory(code);
    }

    /**
     * @return test code of test
     */
    public long getTestCode()
    {
        return this.company.getTestCode();
    }

    /**
     * @return date of test
     */
    public Date getDate()
    {
        return calendar.getTime();
    }
}
