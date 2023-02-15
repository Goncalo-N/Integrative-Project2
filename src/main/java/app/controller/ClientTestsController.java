package app.controller;

import app.domain.model.*;
import app.domain.shared.Constants;
import java.util.*;

public class ClientTestsController
{
    /**
     * Company
     */
    private final Company company;

    Calendar calendar = Calendar.getInstance();

    public ClientTestsController(){
        this(App.getInstance().getCompany());
    }

    /**
     * @param company company
     */
    public ClientTestsController(Company company){
        checkUserAuth();
        this.company = company;
    }

    /**
     * Checks if the user logged in has the client role
     */
    private void checkUserAuth(){
        boolean loggedInWithRole = App.getInstance().getCurrentUserSession().isLoggedInWithRole(Constants.ROLE_CLIENT);
        if (!loggedInWithRole)
            throw new IllegalStateException("User has no permission to do this operation.");
    }

    /**
     * Gets the Test List
     * @return test list of test
     */
    public ArrayList<Test> getTestList() {
        return this.company.getTestList();
    }

    /**
     * Gets the Test that has the ccNumber passed
     * @param ccNumber ccNumber
     * @return Test
     */
    public ArrayList<Test> getInstanceOfTest(long ccNumber) {
        return this.company.getInstanceOfTest(ccNumber);
    }

    /**
     * Gets the Test that has the Test Designation passed
     * @param testSelected test selected
     * @return Test
     */
    public ArrayList<Test> getInstanceOfTest2(String testSelected) {
        return this.company.getInstanceOfTest2(testSelected);
    }

    /**
     * Gets the test code
     * @return test code of test
     */
    public long getTestCode()
    {
        return this.company.getTestCode();
    }

    /**
     * Gets the Test Designation that has the ccNumber that is passed
     * @param ccNumber ccNumber
     * @return TestDesignation
     */
    public ArrayList<String> getInstanceOfTestDesignation(long ccNumber) {
        return this.company.getInstanceOfTestDesignation(ccNumber);
    }

    /**
     * Gets the Date that has the Test Designation that is passed
     * @param s Test Designation
     * @return Date
     */
    public Date getInstanceOfTestDate(String s) {
        return this.company.getInstanceOfTestDate(s);
    }

    /**
     * Gets the Test Designation that has the Date that is passed
     * @param d Date
     * @return Test Designation
     */
    public String getInstanceOfTestDesignationByDate(Date d) {
        return this.company.getInstanceOfTestDesignationByDate(d);
    }

    /**
     * Gets the ccNumber that has the Email that is passed
     * @param userID email
     * @return ccNumber
     */
    public long getInstanceOfCCNumberByEmail(String userID) {
        return this.company.getInstanceOfCCNumberByEmail(userID);
    }

    /**
     * Gets the current date
     * @return date of test
     */
    public Date getDate()
    {
        return calendar.getTime();
    }

    /**
     * Gets the current email
     * @return email
     */
    public String getUserId() { return String.valueOf(App.getInstance().getCurrentUserSession().getUserId()); }
}
