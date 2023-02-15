package app.ui.console;

import app.ui.console.utils.Utils;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class MainMenuUI {

    public MainMenuUI()
    {
    }

    public void run() throws IOException
    {
        List<MenuItem> options = new ArrayList<>();
        try {
            options.add(new MenuItem("Do Login", new AuthUI()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        options.add(new MenuItem("Know the Development Team",new DevTeamUI()));
        int option;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nMain Menu");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
