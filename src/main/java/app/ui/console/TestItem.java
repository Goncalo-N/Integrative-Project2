package app.ui.console;

import app.domain.model.Test;
import org.apache.commons.lang3.StringUtils;

public class TestItem {
    private final String description;
    private final Test test;


    public TestItem(String description, Test test)
    {
        if (StringUtils.isBlank(description))
            throw new IllegalArgumentException("TestItem description cannot be null or empty.");

        this.description = description;
        this.test = test;
    }

    public Test getTest() {
        return test;
    }

    public String toString()
    {
        return this.description;
    }
}
