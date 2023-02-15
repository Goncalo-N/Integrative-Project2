package app.domain.model;

import net.sourceforge.barbecue.Barcode;

public class Sample {

    private String testDesignation;

    /**
     * Barcode of the corresponding sample
     */
    private Barcode barcode;


    public Sample(String barcodeText, String testDesignation) {
        checkTestDesignationNull(testDesignation);
        checkbarcodeTextNull(barcodeText);
        this.testDesignation = testDesignation;

    }

    /**
     * Barcode
     *
     * @return barcode
     */
    public Barcode getBarcode() {
        return barcode;
    }

    /**
     * @param testDesignation test if testDesignation is null
     */
    private void checkTestDesignationNull(String testDesignation)
    {
        if (testDesignation.length() == 0)
            throw new IllegalArgumentException("Test Designation cannot be blank.");
    }
    /**
     * @param barcodeText test if testDesignation is null
     */
    private void checkbarcodeTextNull(String barcodeText)
    {
        if (barcodeText.length() == 0)
            throw new IllegalArgumentException("Barcode number cannot be blank.");
    }

    public String getTestDesignation() {
        return testDesignation;
    }

    public void setTestDesignation(String testDesignation) {
        this.testDesignation = testDesignation;
    }

    public void setBarcode(Barcode barcode) {
        this.barcode = barcode;
    }
}