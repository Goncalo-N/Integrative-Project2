package app.ui.console;

import app.controller.CreateAnalysisController;
import app.domain.model.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CreateAnalysisUI <option> implements Runnable {

    private CreateAnalysisController ctrl;
    String testToshow;
    String option;
    public String toString() {
        return "CreateAnalysisUI{" +
                "ctrl=" + ctrl +
                '}';
    }

    @Override
    public void run() {
        System.out.println("Overview all the tests");
        System.out.println(" ");
        getAllTests();
        MenuOptions();

        while (!option.equals("4")){
            switch (option) {
                case "1":
                    getInvalidTests();
                    MenuOptions();
                    break;

                case "2":
                    System.out.println("Tests done until now: \n");
                    System.out.print("Number of tests: ");
                    getNumberTests();
                    System.out.println(" ");
                    System.out.print("Number of registered tests: ");
                    getNumberRegistereddTests();
                    System.out.print("Number of validated tests: ");
                    getNumberValidatedTests();
                    System.out.print("Number of invalid tests: ");
                    getNumberInvalidTests();
                    MenuOptions();
                    break;

                case "3":
                    System.out.println(" ");
                    System.out.println("Enter first date: (dd/mm/yyyy)");
                    System.out.println("0 - Exit");
                    Scanner sc = new Scanner(System.in);
                    String sdatemenor = sc.nextLine();
                    if (sdatemenor.equals("0")) {
                        option = "4";
                    }
                    else {
                        System.out.println("Enter last date: (dd/mm/yyyy)");
                        System.out.println("0 - Exit");
                        String sdatemaior = sc.nextLine();
                        if (sdatemaior.equals("0")) {
                            option = "4";
                        }
                        else {
                            Date date1 = null;
                            Date date2 = null;
                            try {
                                date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sdatemenor);
                                date2 = new SimpleDateFormat("dd/MM/yyyy").parse(sdatemaior);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            if (date1.compareTo(date2) >  0) {
                                System.out.println("Date order was incorrect!");
                                System.out.println("Enter first date: (dd/mm/yyyy)");
                                System.out.println("0 - Exit");
                                Scanner sc2 = new Scanner(System.in);
                                sdatemenor = sc2.nextLine();
                                if (sdatemenor.equals("0")) {
                                    option = "4";
                                } else {
                                    System.out.println("Enter last date: (dd/mm/yyyy)");
                                    System.out.println("0 - Exit");
                                    sdatemaior = sc2.nextLine();
                                    if (sdatemaior.equals("0")) {
                                        option = "4";
                                    }
                                    else {
                                        date1 = null;
                                        date2 = null;
                                        try {
                                            date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sdatemenor);
                                            date2 = new SimpleDateFormat("dd/MM/yyyy").parse(sdatemaior);
                                        }
                                        catch (ParseException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }

                            ArrayList<Test> testsBetweenDates = new ArrayList<>();
                            ArrayList<Test> registeredTestsBetweenDates = new ArrayList<>();
                            ArrayList<Test> validatedTestsBetweenDates = new ArrayList<>();
                            ArrayList<Test> invalidTestsBetweenDates = new ArrayList<>();
                            ArrayList<Test> tests = this.ctrl.getTestList();
                            for (Test test : tests) {
                                if (test.getDate().compareTo(date1) > 0 && test.getDate().compareTo(date2) < 0) {
                                    testsBetweenDates.add(test);
                                }
                            }

                            int v;
                            for (v = 0; v < testsBetweenDates.size(); v++) {
                                if (testsBetweenDates.get(v).state.equals("Valid")) {
                                    validatedTestsBetweenDates.add(testsBetweenDates.get(v));
                                }
                            }

                            int r;
                            for (r = 0; r < testsBetweenDates.size(); r++) {
                                if (testsBetweenDates.get(r).state.equals("Registered")) {
                                    registeredTestsBetweenDates.add(testsBetweenDates.get(r));
                                }
                            }

                            int i;
                            for (i = 0; i < testsBetweenDates.size(); i++) {
                                if (testsBetweenDates.get(i).state.equals("Invalid")) {
                                    invalidTestsBetweenDates.add(testsBetweenDates.get(i));
                                }
                            }

                            System.out.println("Tests between " + date1 + " and " + date2 + " :");
                            System.out.print("Number of tests: ");
                            System.out.println(testsBetweenDates.size());
                            System.out.print("Number of registered tests: ");
                            System.out.println(registeredTestsBetweenDates.size());
                            System.out.print("Number of validated tests: ");
                            System.out.println(validatedTestsBetweenDates.size());
                            System.out.print("Number of invalid tests: ");
                            System.out.println(invalidTestsBetweenDates.size());

                            MenuOptionsBetweenDates();
                            while (!testToshow.equals("5")) {
                                if (testToshow.equals("1")) {
                                    System.out.println(testsBetweenDates);
                                    MenuOptionsBetweenDates();
                                } else if (testToshow.equals("2")) {
                                    System.out.println(registeredTestsBetweenDates);
                                    MenuOptionsBetweenDates();
                                } else if (testToshow.equals("3")) {
                                    System.out.println(validatedTestsBetweenDates);
                                    MenuOptionsBetweenDates();
                                } else if (testToshow.equals("4")) {
                                    System.out.println(invalidTestsBetweenDates);
                                    MenuOptionsBetweenDates();

                                } else {

                                    MenuOptions();
                                    break;
                                }
                            }
                            MenuOptions();
                        }
                    }
                case "4":
                    break;

                case "5":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Enter \"1\", \"2\", \"3\", \"4\" or \"5\"");
                    MenuOptions();
                    break;

            }
        }
    }

    public void MenuOptions () {
        System.out.println("List of options:");
        System.out.println(" ");
        System.out.println("1 - Show invalid tests");
        System.out.println("2 - Show the number of tests done until now");
        System.out.println("3 - Show tests between a specific period");
        System.out.println("4 - Go back to Laboratory Coordinator Menu");
        System.out.println("5 - Exit the program");
        Scanner chooseoption = new Scanner(System.in);
        option = chooseoption.nextLine();
    }

    public void MenuOptionsBetweenDates () {
        System.out.println("\n 1 - Show all Tests");
        System.out.println(" 2 - Show Registered Tests");
        System.out.println(" 3 - Show Validated Tests");
        System.out.println(" 4 - Show Invalid Tests");
        System.out.println(" 5 - Go Back");
        Scanner sc1 = new Scanner(System.in);
        testToshow = sc1.nextLine();
    }

    public void getAllTests () {
        ctrl = new CreateAnalysisController();
        ArrayList<Test> allTests = ctrl.getTestList();
        System.out.println(allTests);

    }

    public void getRegisteredTests () {
        ctrl = new CreateAnalysisController();
        ArrayList<Test> allTests = ctrl.getTestList();
        ArrayList<Test> registeredTests = new ArrayList<>();
        int i;
        for (i = 0; i < allTests.size(); i++) {
            if (allTests.get(i).state.equals("Registered")) {
                registeredTests.add(allTests.get(i));
            }
        }
        System.out.println(registeredTests);
    }

    public void getValidatedTests () {
        ctrl = new CreateAnalysisController();
        ArrayList<Test> allTests = ctrl.getTestList();
        ArrayList<Test> validatedTests = new ArrayList<>();
        int i;
        for (i = 0; i < allTests.size(); i++) {
            if (allTests.get(i).state.equals("Valid")) {
                validatedTests.add(allTests.get(i));
            }
        }
        System.out.println(validatedTests);
    }

    public void getInvalidTests () {
        ctrl = new CreateAnalysisController();
        ArrayList<Test> allTests = ctrl.getTestList();
        ArrayList<Test> invalidTests = new ArrayList<>();
        int i;
        for (i = 0; i < allTests.size(); i++) {
            if (allTests.get(i).state.equals("Invalid")) {
                invalidTests.add(allTests.get(i));
            }
        }
        System.out.println(invalidTests);
    }

    public void getNumberTests () {
        ctrl = new CreateAnalysisController();
        ArrayList<Test> allTests = ctrl.getTestList();
        System.out.println(allTests.size());
    }

    public void getNumberRegistereddTests () {
        ctrl = new CreateAnalysisController();
        ArrayList<Test> allTests = ctrl.getTestList();
        ArrayList<Test> registeredTests = new ArrayList<>();
        int i;
        for (i = 0; i < allTests.size(); i++) {
            if (allTests.get(i).state.equals("Registered")) {
                registeredTests.add(allTests.get(i));
            }
        }
        System.out.println(registeredTests.size());
    }

    public void getNumberValidatedTests () {
        ctrl = new CreateAnalysisController();
        ArrayList<Test> allTests = ctrl.getTestList();
        ArrayList<Test> validatedTests = new ArrayList<>();
        int i;
        for (i = 0; i < allTests.size(); i++) {
            if (allTests.get(i).state.equals("Valid")) {
                validatedTests.add(allTests.get(i));
            }
        }
        System.out.println(validatedTests.size());
    }

    public void getNumberInvalidTests () {
        ctrl = new CreateAnalysisController();
        ArrayList<Test> allTests = ctrl.getTestList();
        ArrayList<Test> invalidTests = new ArrayList<>();
        int i;
        for (i = 0; i < allTests.size(); i++) {
            if (allTests.get(i).state.equals("Invalid")) {
                invalidTests.add(allTests.get(i));
            }
        }
        System.out.println(invalidTests.size());
    }
}