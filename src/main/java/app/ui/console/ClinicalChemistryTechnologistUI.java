package app.ui.console;

import app.ui.console.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class ClinicalChemistryTechnologistUI implements Runnable{
    public ClinicalChemistryTechnologistUI()
    {
    }

    public void run()
    {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Consult Historical Tests", new ConsultHistoricalTestsUI()));

        int option;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nClinical Chemistry Technologist Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
