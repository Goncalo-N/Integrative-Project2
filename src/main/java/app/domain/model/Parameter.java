package app.domain.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Parameter {

    private final long parameterCode;
    private final String shortName;
    private final String description;
    private final String categoryName;

    public Parameter(long parameterCode, String shortName, String description, String categoryName)
    {
        checkParameterCode(parameterCode);
        checkShortName(shortName);
        checkDescription(description);
        checkCategoryName(categoryName);

        this.parameterCode = parameterCode;
        this.shortName = shortName;
        this.description = description;
        this.categoryName = categoryName;
    }

    public String getCategoryName(){
        return this.categoryName;
    }

    private void checkParameterCode(long parameterCode)
    {
        String k = String.valueOf(parameterCode);
        if (StringUtils.isBlank(k))
            throw new IllegalArgumentException("Code cannot be blank.");
        if (k.length() != 5)
            throw new IllegalArgumentException("Code must have 5 digits.");
    }

    private void checkShortName(String shortName)
    {
        if (StringUtils.isBlank(shortName))
            throw new IllegalArgumentException("Short Name cannot be blank.");
        if (shortName.length() > 8)
            throw new IllegalArgumentException("Short Name must have less than 8 characters.");
    }

    private void checkDescription(String description)
    {
        if (StringUtils.isBlank(description))
            throw new IllegalArgumentException("Description cannot be blank.");
        if (description.length() > 20)
            throw new IllegalArgumentException("Description must have less than 20 characters.");
    }

    private void checkCategoryName(String categoryName)
    {
        if (StringUtils.isBlank(categoryName))
            throw new IllegalArgumentException("Category Name cannot be blank.");
        if (categoryName.length() > 20)
            throw new IllegalArgumentException("Category Name must have less than 20 characters.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parameter parameter = (Parameter) o;
        return Objects.equals(parameterCode, parameterCode) && Objects.equals(shortName, parameter.shortName)
                && Objects.equals(description, parameter.description) && Objects.equals(categoryName, parameter.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parameterCode, shortName, description, categoryName);
    }

    /**
     * @return text description of test
     */
    @Override
    public String toString() {
        return "\nShort Name: " + shortName
                ;
    }
}
