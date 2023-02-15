package app.domain.model;

public class ClientTest {

    @org.junit.Test(expected = NullPointerException.class)

    public void ensureBarcodeTextIsNotNull()
    {
        Company company = new Company("ManyLabs");

        String testDesignation = "testDesignation1";

        company.testingSample(null, testDesignation);
    }

    @org.junit.Test(expected = NullPointerException.class)

    public void ensureDesignationIsNotNull()
    {
        Company company = new Company("ManyLabs");

        String barcodeText = "123456789012";

        company.testingSample(barcodeText, null);
    }
}