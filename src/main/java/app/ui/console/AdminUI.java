package app.ui.console;

import app.ui.console.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class AdminUI implements Runnable{
    public AdminUI()
    {
    }

    public void run()
    {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Create a Parameter Category", new CreateParameterCategoryUI()));
        options.add(new MenuItem("Create a Clinical Analysis Laboratory", new CreateCALUI()));
        options.add(new MenuItem("Create a Employee", new CreateEMPUI()));
        options.add(new MenuItem("Create a Parameter", new CreateParameterUI()));
        options.add(new MenuItem("Generate a Report", new CreateRepUI()));

        int option;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nAdmin Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
