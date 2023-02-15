package app.ui.console;

import app.ui.console.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class ClientUI implements Runnable{
    public ClientUI()
    {
    }

    public void run()
    {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Consult my tests", new ClientTestsUI()));

        int option;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nClient Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
