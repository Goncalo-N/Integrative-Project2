package app.ui.console;

import app.ui.console.utils.Utils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class LaboratoryCoordinatorUI implements Runnable{

    public LaboratoryCoordinatorUI()
    {
    }

    public void run()
    {
        List<MenuItem> options = new ArrayList<>();
        try {
            options.add(new MenuItem("Validate Tests", new ValidateTestUI()));
            options.add(new MenuItem("Import Tests from CSV", new ImportTestUI()));
            options.add(new MenuItem("Overview the performance of the Company", new CreateAnalysisUI()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int option;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nLaboratory Coordinator Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
