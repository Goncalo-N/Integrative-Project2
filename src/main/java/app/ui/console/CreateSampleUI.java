package app.ui.console;

import app.controller.CreateSampleController;
import app.domain.model.*;
import app.ui.console.utils.Utils;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CreateSampleUI implements Runnable {

    private List<Test> testList = new ArrayList<>();
    private final CreateSampleController ctrl;
    private int numberR = 1;
    String barcodeText = "100000000000";
    public CreateSampleUI() {
        this.ctrl = new CreateSampleController();
    }

    private static final Font BARCODE_TEXT_FONT = new Font(Font.SANS_SERIF, Font.PLAIN, 14);




    @Override
    public void run() {

        System.out.println("\n Registering Sample(s): \n");
        try {
            if (readData()) {
                if (Utils.confirm("Do you confirm the Sample? (Y/N)")) {
                    if (this.ctrl.saveSample()) {
                        System.out.println("Record save with success.");
                    } else {
                        System.out.println("An error occurred while attempting to save the record.");
                    }
                }
            } else {
                System.out.println("Provided information already exists.");
            }
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro: operação cancelada. \n" + ex.getMessage());
        }
    }

    private boolean readData() throws Exception {

        String testDesignation;

        String state = "Valid";
        Long p = Long.valueOf(barcodeText);
        //System.out.println(ctrl.getTestList());

        try {
            System.out.println(ctrl.getInstanceOfState(state));

        } catch (Exception e) {
            e.printStackTrace();
        }

        testDesignation = Utils.readLineFromConsole("\nSelect the test (Test Designation, ex: Designation1):");

        String sampleNumber = Utils.readLineFromConsole("How many samples do you want to register:");

        assert sampleNumber != null;
        int k = Integer.parseInt(sampleNumber);
        for (int l = 0; l < k; l++) {
            File filejpg = new File("Barcodes/Barcode_" +testDesignation +"_" + (l+1) + ".jpg");
            p++;
            barcodeText = String.valueOf(p);
            Barcode barcodes = BarcodeFactory.createEAN13(barcodeText);
            barcodes.setPreferredBarHeight(150);
            barcodes.setFont(BARCODE_TEXT_FONT);
            System.out.println(testDesignation+"--"+barcodeText);

            if (testDesignation != null) {
                if(barcodeText.length() != 0 && testDesignation.length() != 0){
                    BarcodeImageHandler.saveJPEG(barcodes, filejpg);
                    ctrl.createSample(barcodeText, testDesignation);
                }else{
                    System.out.println("Test Designation wasn't chosen correctly");
                }
            }
        }

        return true;
    }


    public List<Test> getTestList() {
        return testList;
    }

    public void setTestList(List<Test> testList) {
        this.testList = testList;
    }

    public int getNumberR() {
        return numberR;
    }

    public void setNumberR(int numberR) {
        this.numberR = numberR;
    }
}