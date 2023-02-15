package app.domain.model;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Objects;

public class ParameterCategory {

    private final String parameterCategoryCode;
    private final String name;
    private final ArrayList<Parameter> parameterList;

    public ParameterCategory(String parameterCategoryCode, String name)
    {
        checkParameterCategoryCode(parameterCategoryCode);
        checkName(name);

        this.parameterCategoryCode = parameterCategoryCode;
        this.name = name;
        this.parameterList = new ArrayList<>();
    }

    private void checkParameterCategoryCode(String parameterCategoryCode)
    {
        String k = String.valueOf(parameterCategoryCode);
        if (StringUtils.isBlank(k))
            throw new IllegalArgumentException("Code cannot be blank.");
        if ( (k.length() != 5))
            throw new IllegalArgumentException("Code must have 5 digits.");
    }

    private void checkName(String name){
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Name cannot be blank.");
        if (name.length() > 10)
            throw new IllegalArgumentException("Name must have less than 10 characters.");
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Parameter> getParameterList()
    {
        return parameterList;
    }

    public String getCode() {
        return this.parameterCategoryCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParameterCategory parameterCategory = (ParameterCategory) o;
        return Objects.equals(parameterCategoryCode, parameterCategoryCode) && Objects.equals(name, parameterCategory.name);
}

    @Override
    public int hashCode() {
        return Objects.hash(parameterCategoryCode, name);
    }

    /**
     * @return text description of test
     */
    @Override
    public String toString() {
        return "\nName: " + name
                ;
    }
}
