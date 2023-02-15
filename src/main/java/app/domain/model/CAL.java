package app.domain.model;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Objects;

public class CAL
{
    private String laboratoryID;
    private String name;
    private String address;
    private String phoneNumber;
    private String tinNumber;
    private ArrayList<String> CALTestList;

    public CAL(String laboratoryID, String name, String address, String phoneNumber, String tinNumber, ArrayList<String> CALTestList)
    {
        checklaboratoryID(laboratoryID);
        checkName(name);
        checkAddress(address);
        checkphoneNumber(phoneNumber);
        checktinNumber(tinNumber);
        checkCALTestList(CALTestList);

        setLaboratoryID(laboratoryID);
        setName(name);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setTinNumber(tinNumber);
        setCALTestList(CALTestList);
    }

    public static void checklaboratoryID(String laboratoryID) {
        if (StringUtils.isBlank(laboratoryID))
            throw new IllegalArgumentException("Laboratory ID cannot be blank.");
        if (laboratoryID.length() != 5)
            throw new IllegalArgumentException("Laboratory ID must have 5 chars.");
    }

    public static void checkName(String name)
    {
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Name cannot be blank.");
        if (name.length() > 20)
            throw new IllegalArgumentException("Name must have less than 20 chars.");
    }

    public static void checkAddress(String address) {
        if (StringUtils.isBlank(address))
            throw new IllegalArgumentException("Address cannot be blank.");
        if (address.length() > 30)
            throw new IllegalArgumentException("Address must have less than 30 chars.");
    }

    public static void checkphoneNumber(String phoneNumber) {
        if (StringUtils.isBlank(phoneNumber))
            throw new IllegalArgumentException("PhoneNumber cannot be blank.");
        if (phoneNumber.length() != 11)
            throw new IllegalArgumentException("PhoneNumber must have 11 chars.");
    }

    public static void checktinNumber(String tinNumber) {
        if (StringUtils.isBlank(tinNumber))
            throw new IllegalArgumentException("TINNumber cannot be blank.");
        if (tinNumber.length() != 10)
            throw new IllegalArgumentException("TINNumber must have 10 chars.");
    }

    public static void checkCALTestList(ArrayList<String> CALTestList) {
        if (CALTestList.size() == 0)
            throw new IllegalArgumentException("Type of tests cannot be blank.");

        for (int i = 0; i < CALTestList.size()-1; i++)
            for (int k = i+1; k < CALTestList.size(); k++)
                if(CALTestList.get(i).equals(CALTestList.get(k)))
                    throw new IllegalArgumentException("Cannot have 2 Type of tests equals.");
    }

    public String getLaboratoryID() {
        return laboratoryID;
    }

    public void setLaboratoryID(String laboratoryID) {
        this.laboratoryID = laboratoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    public ArrayList<String> getCALTestList() {
        return CALTestList;
    }

    public void setCALTestList(ArrayList<String> CALTestList) {
        this.CALTestList = CALTestList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CAL cal;
        cal = (CAL) o;
        return  Objects.equals(laboratoryID, cal.laboratoryID)
                && Objects.equals(name, cal.name) && Objects.equals(address, cal.address)
                && Objects.equals(phoneNumber, cal.phoneNumber) && Objects.equals(tinNumber, cal.tinNumber)
                && Objects.equals(CALTestList, cal.CALTestList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(laboratoryID, name, address, phoneNumber, tinNumber, CALTestList);
    }

    @Override
    public String toString() {
        return "\nLaboratoryID: " + laboratoryID +
                "\nName: " + name +
                "\nAddress: " + address +
                "\nPhone Number: " + phoneNumber +
                "\ntinNumber: " + tinNumber +
                "\nTest Type List: " + CALTestList;
    }
}
