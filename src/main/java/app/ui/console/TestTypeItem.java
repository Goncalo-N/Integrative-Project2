package app.ui.console;

import org.apache.commons.lang3.StringUtils;

public class TestTypeItem {
    private final String description;

    public TestTypeItem(String description)
    {
        if (StringUtils.isBlank(description))
            throw new IllegalArgumentException("MenuItem description cannot be null or empty.");

        this.description = description;
    }

    public String toString()
    {
        return this.description;
    }

}
