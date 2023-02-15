package app.domain.model;

import org.apache.commons.lang3.StringUtils;

public class EMP
{
    private String empID;
    private String organizationRole;
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private String soc;

    public EMP(String empID, String organizationRole, String name, String address, String email, String phoneNumber, String soc)
    {
        checkempID(empID);
        checkorganizationRole(organizationRole);
        checkname(name);
        checkaddress(address);
        checkphoneNumber(phoneNumber);

        this.empID = empID;
        this.organizationRole = organizationRole;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.soc = soc;
    }

    private void checkempID(String empID)
    {
        if (StringUtils.isBlank(empID))
            throw new IllegalArgumentException("empID cannot be blank.");
        if (empID.length() != 5)
            throw new IllegalArgumentException("empID must have 5 chars.");
    }

    private void checkorganizationRole(String organizationRole)
    {
        if (StringUtils.isBlank(organizationRole))
            throw new IllegalArgumentException("OrganizationRole cannot be blank.");
        if (organizationRole.length() > 15)
            throw new IllegalArgumentException("OrganizationRole must have less than 15 chars.");
    }

    private void checkname(String name)
    {
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Name cannot be blank.");
        if (name.length() > 35)
            throw new IllegalArgumentException("Name must have less than 35 chars.");
    }

    private void checkaddress(String address)
    {
        if (StringUtils.isBlank(address))
            throw new IllegalArgumentException("Address cannot be blank.");
        if (address.length() > 30)
            throw new IllegalArgumentException("Address must have less than 30 chars.");
    }

    private void checkphoneNumber(String phoneNumber)
    {
        if (StringUtils.isBlank(phoneNumber))
            throw new IllegalArgumentException("PhoneNumber cannot be blank.");
        if (phoneNumber.length() != 11)
            throw new IllegalArgumentException("PhoneNumber must have 11 chars.");
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getOrganizationRole() {
        return organizationRole;
    }

    public void setOrganizationRole(String organizationRole) {
        this.organizationRole = organizationRole;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSoc() {
        return soc;
    }

    public void setSoc(String soc) {
        this.soc = soc;
    }
}
