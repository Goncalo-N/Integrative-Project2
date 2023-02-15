package app.controller;

import app.domain.model.*;
import app.domain.shared.Constants;

import java.util.*;

public class ConsultHistoricalTestsController
{
    /**
     * Company
     */
    private final Company company;

    Calendar calendar = Calendar.getInstance();

    public ConsultHistoricalTestsController(){
        this(App.getInstance().getCompany());
    }

    /**
     * @param company company
     */
    public ConsultHistoricalTestsController(Company company){
        checkUserAuth();
        this.company = company;
    }

    /**
     * Checks if the user logged in has the clinical chemistry technologist role
     */
    private void checkUserAuth(){
        boolean loggedInWithRole = App.getInstance().getCurrentUserSession().isLoggedInWithRole(Constants.ROLE_CLINICALCHEMISTRYTECHNOLOGIST);
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
     * Gets the Client List
     * @return client list of clients
     */
    public ArrayList<Client> getClientList() {
        return this.company.getClientList();
    }

    /**
     * Gets the Test that has the ccNumber passed
     * @param ccNumber ccNumber
     * @return Test
     */
    public ArrayList<Test> getInstanceOfTest(long ccNumber){
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
     * Gets the ccNumber that has the Name that is passed
     * @param name Name
     * @return ccNumber
     */
    public long getInstanceOfTestccNumber(String name) {
        return this.company.getInstanceOfTestccNumber(name);
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

    public String getInstanceOfClientName(String name) {
        return this.company.getInstanceOfClientName(name);
    }

    /**
     * Gets the current date
     * @return date of test
     */
    public Date getDate()
    {
        return calendar.getTime();
    }

    public ArrayList<Client> bubleSortName(ArrayList <Client> tempclientList)
    {
        int size = tempclientList.size();
        int end = size-1;
        boolean sorted = false;
        for(int i = 0; i < size-1 && !sorted; i++)
        {
            sorted = true;
            for (int j=0; j<end; j++) {
                Client t1 = tempclientList.get(j);
                Client t2 = tempclientList.get(j+1);
                if(t1.getName().compareTo(t2.getName()) > 0)
                {
                    sorted = false;
                    tempclientList.remove(j);
                    tempclientList.add(j+1, t1);
                }
            }
            end--;
        }
        return tempclientList;
    }

    public  ArrayList <Client> insertionSortName(ArrayList <Client> tempclientList) {
        int in, out;

        for (out = 1; out < tempclientList.size(); out++) {
            Client temp = tempclientList.get(out);
            in = out;

            while (in > 0 && tempclientList.get(in - 1).getTIN().compareTo(temp.getTIN()) > 0) {
                tempclientList.set(in, tempclientList.get(in - 1));
                --in;
            }
            tempclientList.set(in, temp);
        }
        return tempclientList;
    }
}
