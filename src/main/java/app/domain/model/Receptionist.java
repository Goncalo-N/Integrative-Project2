package app.domain.model;

import app.controller.App;
import java.util.Date;

public class Receptionist {
    private String EmployeeID;
    private String OrganizationRole;
    private String name;
    private String address;
    private int PhoneNumber;
    private String Email;
    private String soc;
    private final Company company;

    public Receptionist(String EmployeeID, String OrganizationRole, String name, String address, int PhoneNumber, String Email, String soc) {
        this.EmployeeID = EmployeeID;
        this.OrganizationRole = OrganizationRole;
        this.name = name;
        this.address = address;
        this.PhoneNumber = PhoneNumber;
        this.Email = Email;
        this.soc = soc;
        this.company = App.getInstance().getCompany();
    }


    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public void setOrganizationRole(String organizationRole) {
        OrganizationRole = organizationRole;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setSoc(String soc) {
        this.soc = soc;
    }



    public String getName() {
        return name;
    }

    public String getEmail() {
        return Email;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public String getOrganizationRole() {
        return OrganizationRole;
    }

    public String getSoc() {
        return soc;
    }

    public boolean createClient(String Name, long CitizenCardNumber, long NHSNumber, Date BirthDate, String Sex, long TIN, long PhoneNumber, String Email) { {
            return company.saveClient (new Client(Name, CitizenCardNumber, NHSNumber, BirthDate, Sex, TIN, PhoneNumber, Email));
        }
    }
}
