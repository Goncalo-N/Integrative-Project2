package app.domain.model;

import org.apache.commons.lang3.StringUtils;
import java.util.Date;
import java.util.Objects;

public class Client {

    private final String Name;
    private final long CitizenCardNumber;
    private final long NHSNumber;
    private final Date BirthDate;
    private final String Sex;
    private final long TIN;
    private final long PhoneNumber;
    private final String Email;

    public Client (String name, long citizencardnumber, long nhsnumber, Date birthdate,
                   String sex, long tin, long phonenumber, String email){
        checkPhoneNumber(phonenumber);
        checkEmail(email);
        checkName(name);
        checkCitizenCardNumber(citizencardnumber);
        checkNHSNumber(nhsnumber);
        checkTIN(tin);

        this.Name = name;
        this.CitizenCardNumber = citizencardnumber;
        this.NHSNumber = nhsnumber;
        this.BirthDate = birthdate;
        this.Sex = sex;
        this.TIN = tin;
        this.PhoneNumber = phonenumber;
        this.Email = email;

    }

    private void checkPhoneNumber(long phoneNumber) {
        String phoneNumberString = String.valueOf(phoneNumber);
        if (StringUtils.isBlank(phoneNumberString))
            throw new IllegalArgumentException("Phone Number cannot be empty.");
        if (phoneNumberString.length() != 11)
            throw new IllegalArgumentException("Phone Number must have 11 chars.");
        }

    private void checkEmail(String email) {
        if (StringUtils.isBlank(email))
            throw new IllegalArgumentException("Email cannot be empty.");
    }

    private void checkName(String name) {
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Phone Number cannot be empty.");
    }

    private void checkCitizenCardNumber(long citizenCardNumber) {
        String citizenCardNumberString = String.valueOf(citizenCardNumber);
        if (StringUtils.isBlank(citizenCardNumberString))
            throw new IllegalArgumentException("Citizen Card Number cannot be empty.");
        if (citizenCardNumberString.length() != 16)
            throw new IllegalArgumentException("Citizen Card Number must have 16 chars.");
    }

    private void checkNHSNumber(long NHSNumber) {
        String NHSNumberString = String.valueOf(NHSNumber);
        if (StringUtils.isBlank(NHSNumberString))
            throw new IllegalArgumentException("NHS Number cannot be empty.");
        if (NHSNumberString.length() != 10)
            throw new IllegalArgumentException("NHS Number must have 10 chars.");
    }

    private void checkTIN(long TIN) {
        String TINString = String.valueOf(TIN);
        if (StringUtils.isBlank(TINString))
            throw new IllegalArgumentException("TIN cannot be empty.");
        if (TINString.length() != 10)
            throw new IllegalArgumentException("TIN must have 10 chars.");
    }

    public String getName() { return this.Name; }

    public String getTIN() { return String.valueOf(this.TIN); }

    public long getccNumber() { return this.CitizenCardNumber; }

    public String getEmail() { return this.Email; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client;
        client = (Client) o;
        return  Objects.equals(CitizenCardNumber, client.CitizenCardNumber)
                && Objects.equals(NHSNumber, client.NHSNumber) && Objects.equals(BirthDate, client.BirthDate)
                && Objects.equals(Sex, client.Sex) && Objects.equals(TIN, client.TIN)
                && Objects.equals(PhoneNumber, client.PhoneNumber) && Objects.equals(Email, client.Email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, CitizenCardNumber, NHSNumber, BirthDate, Sex, TIN, PhoneNumber, Email);
    }

    /**
     * @return text description of test
     */
    @Override
    public String toString() {
        return "\nName: " + Name + ", " + "tinNumber: " + TIN
                ;
    }
}
