package app.domain.model;

import auth.AuthFacade;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Company {

    private final String designation;
    private final AuthFacade authFacade;
    private final long testCode;

    private final ArrayList<ParameterCategory> parameterCategoryList;
    private final ArrayList<Parameter> parameterList;
    private final ArrayList<TestType> testTypeList;
    private final ArrayList<Test> testList;
    private final ArrayList<CAL> CALList;
    private final ArrayList<EMP> EMPList;
    private final ArrayList<Client> clientList;
    private final ArrayList<Sample> sampleList;
    private ArrayList<Test> tempTestList;
    private final ArrayList<RepDiag> repDiagList;
    private final ArrayList<String> CALTestList;

    public Company(String designation){
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();

        this.testCode = 12345;

        this.CALTestList = new ArrayList<>();
        CALTestList.add("blood");
        CALTestList.add("covid19");

        this.CALList = new ArrayList<>();
        CALList.add(new CAL("12345", "qwe", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", "12345678901", "1234567890",  getCALTestList()));
        CALList.add(new CAL("66666", "qwe34534", "bbbasdasdqeqwbbbbb", "12343458444", "1234567832",  getCALTestList()));

        this.testTypeList = new ArrayList<>();

        String blood = "blood";
        String covid19 = "covid19";

        testTypeList.add(new TestType(blood, "desc test 1", "col method 1"));
        testTypeList.add(new TestType(covid19, "desc test 2", "col method 2"));

        String Cat1 = "Cat1";
        String Cat2 = "Cat2";
        String Cat3 = "Cat3";

        this.parameterCategoryList = new ArrayList<>();
        parameterCategoryList.add(new ParameterCategory("12345", Cat1));
        parameterCategoryList.add(new ParameterCategory("23145", Cat2));
        parameterCategoryList.add(new ParameterCategory("31234", Cat3));

        this.parameterList = new ArrayList<>();
        parameterList.add(new Parameter(12334, "param 1", "description1", Cat1));
        parameterList.add(new Parameter(22121, "param 2", "description2", Cat1));
        parameterList.add(new Parameter(32333, "param 3", "description3", Cat1));

        parameterList.add(new Parameter(22222, "param 4", "description4", Cat2));
        parameterList.add(new Parameter(33333, "param 5", "description5", Cat2));
        parameterList.add(new Parameter(44444, "param 6", "description6", Cat2));

        parameterList.add(new Parameter(55555, "param 7", "description7", Cat3));
        parameterList.add(new Parameter(66666, "param 8", "description8", Cat3));
        parameterList.add(new Parameter(77777, "param 9", "description9", Cat3));

        this.testList = new ArrayList<>();

        ArrayList<String> testParameterCategoryList = new ArrayList<>();
        ArrayList<String> testParameterList = new ArrayList<>();
        testParameterCategoryList.add("CategoryName1");
        testParameterCategoryList.add("CategoryName2");
        testParameterCategoryList.add("CategoryName3");
        testParameterList.add("ParName1");
        testParameterList.add("ParName2");
        testParameterList.add("ParName3");

        this.sampleList = new ArrayList<>();
        String sDate1="01/06/2021";
        Date date1= null;

        String sDate2="05/06/2021";
        Date date2= null;

        String sDate3="25/06/2021";
        Date date3= null;

        String sDate4="15/06/2021";
        Date date4= null;

        String sDate5="20/06/2021";
        Date date5= null;

        String sDate6="04/06/2021";
        Date date6= null;

        String sDate7="13/06/2021";
        Date date7= null;

        String sDate8="17/06/2021";
        Date date8= null;

        String sDate9="26/06/2021";
        Date date9= null;

        String sDate10="05/01/1998";
        Date date10= null;

        String sDate11="13/06/1980";
        Date date11= null;

        String sDate12="27/12/2000";
        Date date12= null;
        String pattern = "dd/MM/yyyy";
        try
        {
            date1 = new SimpleDateFormat(pattern).parse(sDate1);
            date2 = new SimpleDateFormat(pattern).parse(sDate2);
            date3 = new SimpleDateFormat(pattern).parse(sDate3);
            date4 = new SimpleDateFormat(pattern).parse(sDate4);
            date5 = new SimpleDateFormat(pattern).parse(sDate5);
            date6 = new SimpleDateFormat(pattern).parse(sDate6);
            date7 = new SimpleDateFormat(pattern).parse(sDate7);
            date8 = new SimpleDateFormat(pattern).parse(sDate8);
            date9 = new SimpleDateFormat(pattern).parse(sDate9);
            date10 = new SimpleDateFormat(pattern).parse(sDate10);
            date11 = new SimpleDateFormat(pattern).parse(sDate11);
            date12 = new SimpleDateFormat(pattern).parse(sDate12);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        String valid = "Valid";
        String invalid = "Invalid";
        String registered = "Registered";
        long ccNumber1 = 1234567890123455L;
        long ccNumber2 = 1234567890123456L;
        long ccNumber3 = 1234567890123457L;
        testList.add(new Test(1, "123", "Designation1", ccNumber1, blood,
                testParameterCategoryList, testParameterList, registered, date1));
        testList.add(new Test(2, "1234", "Designation2", ccNumber2, covid19,
                testParameterCategoryList, testParameterList, invalid, date2));
        testList.add(new Test(3, "12345", "Designation3", ccNumber1, blood,
                testParameterCategoryList, testParameterList, valid, date3));
        testList.add(new Test(4, "12346", "Designation4", ccNumber2, covid19,
                testParameterCategoryList, testParameterList, valid, date4));
        testList.add(new Test(5, "12355", "Designation5", ccNumber1, covid19,
                testParameterCategoryList, testParameterList, registered, date5));
        testList.add(new Test(6, "22222", "Designation6", ccNumber3, blood,
                testParameterCategoryList, testParameterList, valid, date6));
        testList.add(new Test(7, "31231", "Designation7", ccNumber3, covid19,
                testParameterCategoryList, testParameterList, valid, date7));
        testList.add(new Test(8, "55543", "Designation8", ccNumber2, blood,
                testParameterCategoryList, testParameterList, invalid, date8));
        testList.add(new Test(9, "23321", "Designation9", ccNumber3, blood,
                testParameterCategoryList, testParameterList, registered, date9));

        this.clientList = new ArrayList<>();
        clientList.add(new Client("José", ccNumber1, 1234567890L, date10, "Male", 1112223334L, 12345678654L, "jose@lei.sem2.pt"));
        clientList.add(new Client("Pedro", ccNumber2, 1234567899L, date11, "Male", 2223334445L, 21232456765L, "pedro@lei.sem2.pt"));
        clientList.add(new Client("António", ccNumber3, 1234567898L, date12, "Male", 8889997776L, 23423438902L, "antonio@lei.sem2.pt"));

        this.EMPList = new ArrayList<>();

        this.repDiagList = new ArrayList<>();
        repDiagList.add(new RepDiag("Report 1", 1));
        repDiagList.add(new RepDiag("Report 2", 2));
        repDiagList.add(new RepDiag("Report 3", 3));
        repDiagList.add(new RepDiag("Report 4", 4));
        repDiagList.add(new RepDiag("Report 5", 5));
        repDiagList.add(new RepDiag("Report 6", 6));
        repDiagList.add(new RepDiag("Report 7", 7));
        repDiagList.add(new RepDiag("Report 8", 8));
        repDiagList.add(new RepDiag("Report 9", 9));
    }

    public String getDesignation() {
        return designation;
    }

    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    public long getTestCode() {
        return this.testCode;
    }

    public ArrayList<Test> getTestList() { return this.testList; }

    public ArrayList<Client> getClientList() { return this.clientList; }

    public ArrayList<CAL> getCALList() { return this.CALList; }

    public ArrayList<String> getCALTestList() { return this.CALTestList; }

    public ArrayList<TestType> getTestTypeList() { return this.testTypeList; }

    public ArrayList<ParameterCategory> getParameterCategoryList() { return parameterCategoryList; }

    public ArrayList<Parameter> getParameterList() { return this.parameterList; }

    public ArrayList<String> getInstanceOfTestDesignation(long ccNumber) {
        String testDesignationToSend;
        ArrayList<String> testDesignationList = new ArrayList<>();
        for (Test t : getTestList()) {
            if (t.getCCNumber() == ccNumber && !t.getState().equals("Invalid")) {
                testDesignationToSend = t.getTestDesignation();
                testDesignationList.add(testDesignationToSend);
            }
        }
        return testDesignationList;
    }

    public long getInstanceOfTestccNumber(String name) {
        long ccNumberToSend = 0;
        for (Client c : getClientList()) {
            if (c.getName().equals(name)) {
                ccNumberToSend = c.getccNumber();
            }
        }
        return ccNumberToSend;
    }

    public Date getInstanceOfTestDate(String s) {
        Date testDateToSend;
        Date testDate = null;
        for (Test t : getTestList()) {
            if (t.getTestDesignation().equals(s)) {
                testDateToSend = t.getDate();
                testDate = testDateToSend;
            }
        }
        return testDate;
    }

    public String getInstanceOfTestDesignationByDate(Date d) {
        String testDesignationToSend;
        String testDesignation = null;
        for (Test t : getTestList()) {
            if (t.getDate().equals(d)) {
                testDesignationToSend = t.getTestDesignation();
                testDesignation = testDesignationToSend;
            }
        }
        return testDesignation;
    }

    public long getInstanceOfCCNumberByEmail(String userID) {
        long ccNumber = 0;
        for (Client c : getClientList()) {
            if (c.getEmail().equals(userID)) {
                ccNumber = c.getccNumber();
            }
        }
        return ccNumber;
    }

    public String getInstanceOfClientName(String name) {
        String clientNameToSend = "";
        for (Client c : getClientList()) {
            if (c.getName().equals(name) && !clientNameToSend.equals(name)) {
                clientNameToSend = name;
            }
            else
            if(!clientNameToSend.equals(name))
            {
                clientNameToSend = "";
            }
        }
        return clientNameToSend;
    }

    public ArrayList<Parameter> getInstanceOfParameterCategory(String code) {
        Parameter pToSend;
        ArrayList<Parameter> tempParameterList = new ArrayList<>();
        for (Parameter p : getParameterList()) {
            if (p.getCategoryName().equals(code)) {
                pToSend = p;
                tempParameterList.add(pToSend);
            }
        }
        return tempParameterList;
    }

    public ArrayList<Test> getInstanceOfState(String state) {
        Test testToSend;
        this.tempTestList = new ArrayList<>();
        for (Test t : getTestList()) {
            if (t.getState().equals(state)) {
                testToSend = t;
                tempTestList.add(testToSend);
            }
        }
        return tempTestList;
    }

    public ArrayList<Test> getInstanceOfTest(long ccNumber) {
        Test tToSend;
        this.tempTestList = new ArrayList<>();
        for (Test t : getTestList()) {
            if (t.getCCNumber() == ccNumber && !t.getState().equals("Invalid")) {
                tToSend = t;
                tempTestList.add(tToSend);
            }
        }
        return tempTestList;
    }

    public ArrayList<Test> getInstanceOfTest2(String testSelected) {
        Test testToSend;
        ArrayList<Test> tempTestList2 = new ArrayList<>();
        for (Test t : getTestList()) {
            if (t.getTestDesignation().equals(testSelected)  && !t.getState().equals("Invalid")) {
                testToSend = t;
                tempTestList2.add(testToSend);
            }
        }
        return tempTestList2;
    }

    public boolean validateTestType(TestType testtype) {
        if (testtype == null)
            return false;
        return ! this.testTypeList.contains(testtype);
    }

    public boolean saveTestType(TestType testtype) {
        if (!validateTestType(testtype))
            return false;
        return this.testTypeList.add(testtype);
    }

    public Test createTest(long testCode, String nhsCode, String testDesignation, long ccNumber, String testType, ArrayList<String> parameterCategoryList,
                           ArrayList<String> parameterList, String state) throws ParseException {

        Calendar calendar = Calendar.getInstance();
        String sDate1= String.valueOf(calendar.getTime());
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

        return new Test(testCode, nhsCode, testDesignation, ccNumber, testType, parameterCategoryList, parameterList, state, date);
    }

    public boolean validateTest(Test test) {
        if (test == null)
            return false;
        return ! this.testList.contains(test);
    }

    public boolean saveTest(Test test) {
        if (!validateTest(test))
            return false;
        return this.testList.add(test);
    }

    public void testingTest(long testCode, String nhsCode, String testDesignation, long ccNumber, String testType, ArrayList<String> parameterCategoryList,
                            ArrayList<String> parameterList, String state, Date date) {
        new Test(testCode, nhsCode, testDesignation, ccNumber, testType, parameterCategoryList, parameterList, state, date);
    }

    public RepDiag createRepDiag(String report, long testCode) { return new RepDiag(report, testCode); }

    public void validateRepDiag(RepDiag repdiag) {
        if (repdiag == null)
            return;
        this.repDiagList.add(repdiag);
    }

    public ArrayList<Test> getInstanceOfTestCode(long testCode) {
        Test testToSend;
        this.tempTestList = new ArrayList<>();
        for (Test t : getTestList()) {
            if (t.getTestCode() == testCode) {
                testToSend = t;
                tempTestList.add(testToSend);
            }
        }
        return tempTestList;
    }

    public CAL createCAL(String laboratoryID, String name, String address, String phoneNumber, String tinNumber, ArrayList<String> CALTestList)
    {
        return new CAL(laboratoryID, name, address, phoneNumber, tinNumber, CALTestList);
    }

    public void testingCAL(String laboratoryID, String name, String address, String phoneNumber, String tinNumber, ArrayList<String> CALTestList)
    {
        new CAL(laboratoryID, name, address, phoneNumber, tinNumber, CALTestList);
    }

    public boolean validateCAL(CAL cal) {
        if (cal == null)
            return false;
        return ! this.CALList.contains(cal);
    }

    public boolean saveCAL(CAL cal) {
        if (!validateCAL(cal))
            return false;
        return this.CALList.add(cal);
    }

    public boolean saveValidation(){ return true; }

    public EMP createEMP(String empID, String organizationRole, String name, String address,  String email, String phoneNumber, String soc) { return new EMP(empID, organizationRole, name, address, email, phoneNumber, soc); }

    public boolean validateEMP(EMP emp) {
        if (emp == null)
            return false;
        return ! this.EMPList.contains(emp);
    }

    public boolean saveEMP(EMP emp) {
        if (!validateEMP(emp))
            return false;
        return this.EMPList.add(emp);
    }

    public Parameter createParameter(long parameterCode, String shortName, String description, String categoryName) { return new Parameter(parameterCode, shortName, description, categoryName); }

    public boolean validateParameter(Parameter parameter) {
        if (parameter == null)
            return false;
        return ! this.parameterList.contains(parameter);
    }

    public boolean saveParameter(Parameter parameter) {
        if (!validateParameter(parameter))
            return false;
        return this.parameterList.add(parameter);
    }

    public ParameterCategory createParameterCategory(String parameterCategoryCode, String name) { return new ParameterCategory(parameterCategoryCode,name); }

    public boolean validateParameterCategory(ParameterCategory pc)
    {
        if (pc == null)
            return false;
        return !this.parameterCategoryList.contains(pc);
    }

    public boolean saveParameterCategory(ParameterCategory pc)
    {
        if (!validateParameterCategory(pc))
            return false;
        return this.parameterCategoryList.add(pc);
    }

    public Client createClient(String Name, long CitizenCardNumber, long NHSNumber, Date BirthDate, String Sex, long TIN, long PhoneNumber, String Email) { return new Client(Name, CitizenCardNumber, NHSNumber, BirthDate, Sex, TIN, PhoneNumber, Email); }

    public boolean validateClient(Client client) {
        if (client == null)
            return false;
        return !this.clientList.contains(client);
    }

    public boolean saveClient(Client client) {
        if (!validateClient(client))
            return false;
        return this.clientList.add(client);
    }

    public Sample createSample(String barcodeText, String testDesignation) { return  new Sample(barcodeText,testDesignation); }

    public boolean validateSample(Sample sample) {
        if (sample == null)
            return false;
        return ! this.sampleList.contains(sample);
    }

    public boolean saveSample(Sample sample) {
        if (!validateSample(sample))
            return false;
        return this.sampleList.add(sample);
    }

    public void testingSample(String barcodeText, String testDesignation) {
        new Sample(barcodeText, testDesignation);
    }

    public boolean validateRep(String rep) {
        Report2NHS(rep);
        return true;
    }

    private void Report2NHS(String data) {
        File file = new File("./NHSReport/NHSReport.txt");
        FileWriter fr = null;

        try {
            fr = new FileWriter(file);
            fr.write(data);
        } catch (IOException var12) {
            var12.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException var11) {
                var11.printStackTrace();
            }

        }
    }

    public boolean sendRep(String rep) {
        return validateRep(rep);
    }
}
