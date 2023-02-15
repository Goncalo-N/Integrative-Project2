package app.ui.console;

import app.ui.console.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class ReceptionistUI implements Runnable{
    public ReceptionistUI()
    {
    }

    public void run()
    {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Create a Client", new CreateClientUI()));
        options.add(new MenuItem("Register a Test", new CreateTestUI()));

        int option;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nReceptionist Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
