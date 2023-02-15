package app.domain.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CALTest
{
    @Test(expected = IllegalArgumentException.class)
    public void ensureLaboratoryIDNotNull()
    {
        Company company = new Company("ManyLabs");

        String LaboratoryID = "";

        String name = "qwe";

        String address = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";

        String phoneNumber = "12345678901";

        String tinNumber = "1234567890";

        ArrayList <String> CALTestList = new ArrayList<>();
        CALTestList.add("blood");
        CALTestList.add("covid19");

        company.testingCAL(LaboratoryID,name,address,phoneNumber,tinNumber,CALTestList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureLaboratoryIDNotDifferentThan5Digits()
    {
        Company company = new Company("ManyLabs");

        String LaboratoryID = "123456";

        String name = "qwe";

        String address = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";

        String phoneNumber = "12345678901";

        String tinNumber = "1234567890";

        ArrayList <String> CALTestList = new ArrayList<>();
        CALTestList.add("blood");
        CALTestList.add("covid19");

        company.testingCAL(LaboratoryID,name,address,phoneNumber,tinNumber,CALTestList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNameNotNull()
    {
        Company company = new Company("ManyLabs");

        String LaboratoryID = "12345";

        String name = "";

        String address = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";

        String phoneNumber = "12345678901";

        String tinNumber = "1234567890";

        ArrayList <String> CALTestList = new ArrayList<>();
        CALTestList.add("blood");
        CALTestList.add("covid19");

        company.testingCAL(LaboratoryID,name,address,phoneNumber,tinNumber,CALTestList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNameNotBiggerThan20Digits()
    {
        Company company = new Company("ManyLabs");

        String LaboratoryID = "12345";

        String name = "aaaaaaaaaaaaaaaaaaaaa";

        String address = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";

        String phoneNumber = "12345678901";

        String tinNumber = "1234567890";

        ArrayList <String> CALTestList = new ArrayList<>();
        CALTestList.add("blood");
        CALTestList.add("covid19");

        company.testingCAL(LaboratoryID,name,address,phoneNumber,tinNumber,CALTestList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureAddressNotNull()
    {
        Company company = new Company("ManyLabs");

        String LaboratoryID = "12345";

        String name = "qwe";

        String address = "";

        String phoneNumber = "12345678901";

        String tinNumber = "1234567890";

        ArrayList <String> CALTestList = new ArrayList<>();
        CALTestList.add("blood");
        CALTestList.add("covid19");

        company.testingCAL(LaboratoryID,name,address,phoneNumber,tinNumber,CALTestList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureAddressNotBiggerThan30Digits()
    {
        Company company = new Company("ManyLabs");

        String LaboratoryID = "12345";

        String name = "qwe";

        String address = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";

        String phoneNumber = "12345678901";

        String tinNumber = "1234567890";

        ArrayList <String> CALTestList = new ArrayList<>();
        CALTestList.add("blood");
        CALTestList.add("covid19");

        company.testingCAL(LaboratoryID,name,address,phoneNumber,tinNumber,CALTestList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensurePhoneNumberNotNull()
    {
        Company company = new Company("ManyLabs");

        String LaboratoryID = "12345";

        String name = "qwe";

        String address = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";

        String phoneNumber = "";

        String tinNumber = "1234567890";

        ArrayList <String> CALTestList = new ArrayList<>();
        CALTestList.add("blood");
        CALTestList.add("covid19");

        company.testingCAL(LaboratoryID,name,address,phoneNumber,tinNumber,CALTestList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensurePhoneNumberNotDifferentThan11Digits()
    {
        Company company = new Company("ManyLabs");

        String LaboratoryID = "12345";

        String name = "qwe";

        String address = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";

        String phoneNumber = "123456789012";

        String tinNumber = "1234567890";

        ArrayList <String> CALTestList = new ArrayList<>();
        CALTestList.add("blood");
        CALTestList.add("covid19");

        company.testingCAL(LaboratoryID,name,address,phoneNumber,tinNumber,CALTestList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureTINNumberNotNull()
    {
        Company company = new Company("ManyLabs");

        String LaboratoryID = "12345";

        String name = "qwe";

        String address = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";

        String phoneNumber = "12345678901";

        String tinNumber = "";

        ArrayList <String> CALTestList = new ArrayList<>();
        CALTestList.add("blood");
        CALTestList.add("covid19");

        company.testingCAL(LaboratoryID,name,address,phoneNumber,tinNumber,CALTestList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureTINNumberNotDifferentThan10Digits()
    {
        Company company = new Company("ManyLabs");

        String LaboratoryID = "12345";

        String name = "qwe";

        String address = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";

        String phoneNumber = "12345678901";

        String tinNumber = "12345678901";

        ArrayList <String> CALTestList = new ArrayList<>();
        CALTestList.add("blood");
        CALTestList.add("covid19");

        company.testingCAL(LaboratoryID,name,address,phoneNumber,tinNumber,CALTestList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCALTestListNotNull()
    {
        Company company = new Company("ManyLabs");

        String LaboratoryID = "12345";

        String name = "qwe";

        String address = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";

        String phoneNumber = "12345678901";

        String tinNumber = "1234567890";

        ArrayList <String> CALTestList = new ArrayList<>();

        company.testingCAL(LaboratoryID,name,address,phoneNumber,tinNumber,CALTestList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCALTestListNotHaveMoreThan2Types()
    {
        Company company = new Company("ManyLabs");

        String LaboratoryID = "12345";

        String name = "qwe";

        String address = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";

        String phoneNumber = "12345678901";

        String tinNumber = "1234567890";

        ArrayList <String> CALTestList = new ArrayList<>();
        CALTestList.add("blood");
        CALTestList.add("blood");
        CALTestList.add("covid19");
        CALTestList.add("covid19");

        company.testingCAL(LaboratoryID,name,address,phoneNumber,tinNumber,CALTestList);
    }

    @Test
    public void testGetsLaboratoryID()
    {
        ArrayList <String> CALTestList = new ArrayList<>();
        CALTestList.add("blood");
        CALTestList.add("covid19");

        CAL cal = new CAL("12345", "qwe", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", "12345678901", "1234567890",  CALTestList);

        String expectedLaboratoryID = "12345";
        assertEquals(cal.getLaboratoryID(),expectedLaboratoryID);
    }

    @Test
    public void testSetsLaboratoryID()
    {
        ArrayList <String> CALTestList = new ArrayList<>();
        CALTestList.add("blood");
        CALTestList.add("covid19");

        CAL cal = new CAL("12345", "qwe", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", "12345678901", "1234567890",  CALTestList);

        String LaboratoryID = "12345";
        cal.setLaboratoryID(LaboratoryID);
        assertEquals(cal.getLaboratoryID(), LaboratoryID);
    }

    @Test
    public void testGetsName()
    {
        ArrayList <String> CALTestList = new ArrayList<>();
        CALTestList.add("blood");
        CALTestList.add("covid19");

        CAL cal = new CAL("12345", "qwe", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", "12345678901", "1234567890",  CALTestList);

        String expectedName = "qwe";
        assertEquals(cal.getName(),expectedName);
    }

    @Test
    public void testSetsName()
    {
        ArrayList <String> CALTestList = new ArrayList<>();
        CALTestList.add("blood");
        CALTestList.add("covid19");

        CAL cal = new CAL("12345", "qwe", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", "12345678901", "1234567890",  CALTestList);

        String Name = "qwe";
        cal.setName(Name);
        assertEquals(cal.getName(), Name);
    }

    @Test
    public void testGetsAddress()
    {
        ArrayList <String> CALTestList = new ArrayList<>();
        CALTestList.add("blood");
        CALTestList.add("covid19");

        CAL cal = new CAL("12345", "qwe", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", "12345678901", "1234567890",  CALTestList);

        String expectedAddress = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
        assertEquals(cal.getAddress(),expectedAddress);
    }

    @Test
    public void testSetsAddress()
    {
        ArrayList <String> CALTestList = new ArrayList<>();
        CALTestList.add("blood");
        CALTestList.add("covid19");

        CAL cal = new CAL("12345", "qwe", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", "12345678901", "1234567890",  CALTestList);

        String Address = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
        cal.setAddress(Address);
        assertEquals(cal.getAddress(), Address);
    }

    @Test
    public void testGetsPhoneNumber()
    {
        ArrayList <String> CALTestList = new ArrayList<>();
        CALTestList.add("blood");
        CALTestList.add("covid19");

        CAL cal = new CAL("12345", "qwe", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", "12345678901", "1234567890",  CALTestList);

        String expectedPhoneNumber = "12345678901";
        assertEquals(cal.getPhoneNumber(),expectedPhoneNumber);
    }

    @Test
    public void testSetsPhoneNumber()
    {
        ArrayList <String> CALTestList = new ArrayList<>();
        CALTestList.add("blood");
        CALTestList.add("covid19");

        CAL cal = new CAL("12345", "qwe", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", "12345678901", "1234567890",  CALTestList);

        String PhoneNumber = "12345678901";
        cal.setPhoneNumber(PhoneNumber);
        assertEquals(cal.getPhoneNumber(), PhoneNumber);
    }

    @Test
    public void testGetsTINNumber()
    {
        ArrayList <String> CALTestList = new ArrayList<>();
        CALTestList.add("blood");
        CALTestList.add("covid19");

        CAL cal = new CAL("12345", "qwe", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", "12345678901", "1234567890",  CALTestList);

        String expectedTINNumber = "1234567890";
        assertEquals(cal.getTinNumber(),expectedTINNumber);
    }

    @Test
    public void testSetsTINNumber()
    {
        ArrayList <String> CALTestList = new ArrayList<>();
        CALTestList.add("blood");
        CALTestList.add("covid19");

        CAL cal = new CAL("12345", "qwe", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", "12345678901", "1234567890",  CALTestList);

        String TINNumber = "1234567890";
        cal.setTinNumber(TINNumber);
        assertEquals(cal.getTinNumber(), TINNumber);
    }

    @Test
    public void testGetsCALTestList()
    {
        ArrayList <String> expectedCALTestList = new ArrayList<>();
        expectedCALTestList.add("blood");
        expectedCALTestList.add("covid19");

        CAL cal = new CAL("12345", "qwe", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", "12345678901", "1234567890",  expectedCALTestList);

        assertEquals(cal.getCALTestList(),expectedCALTestList);
    }

    @Test
    public void testSetsCALTestList()
    {
        ArrayList <String> CALTestList = new ArrayList<>();
        CALTestList.add("blood");
        CALTestList.add("covid19");

        CAL cal = new CAL("12345", "qwe", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", "12345678901", "1234567890",  CALTestList);

        cal.setCALTestList(CALTestList);
        assertEquals(cal.getCALTestList(), CALTestList);
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