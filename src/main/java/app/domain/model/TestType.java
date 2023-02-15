package app.domain.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class TestType {

    /**
     * Name of the test type
     */
    private final String name;

    /**
     * Description of the test type
     */
    private final String description;

    /**
     * Collecting method of the test type
     */
    private final String collecting_method;

    /**
     * Creates new type of test
     * @param name              name of the test type
     * @param description       description of the test type
     * @param collecting_method collecting method of the test type
     */
    public TestType(String name, String description, String collecting_method) {
        checkName(name);
        checkDescription(description);
        checkCollectingMethod(collecting_method);
        this.name = name;
        this.description = description;
        this.collecting_method = collecting_method;
    }

    /**
     *  Method that verifies if the name of the new type of test follows the acceptance criteria
     **/
    private void checkName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("Name cannot be blank.");
        }else {
            if (name.length() > 10 ){
                throw new IllegalArgumentException("Name of test type cannot have more than 10 characters");
            }
        }
    }

    /**
     *  Method that verifies if the description of the new type of test follows the acceptance criteria
     **/
    private void checkDescription(String description) {
        if (StringUtils.isBlank(description)) {
            throw new IllegalArgumentException("Description cannot be blank.");
        }else {
            if (description.length() > 15 ){
                throw new IllegalArgumentException("Description of test type cannot have more than 15 characters");
            }
        }
    }

    /**
     *  Method that verifies if the description of the new type of test follows the acceptance criteria
     **/
    private void checkCollectingMethod(String collecting_method) {
        if (StringUtils.isBlank(collecting_method)) {
            throw new IllegalArgumentException("Collecting method cannot be blank.");
        }else {
            if (collecting_method.length() > 20 ){
                throw new IllegalArgumentException("Collecting method of test type cannot have more than 20 characters");
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestType testtype = (TestType) o;
        return Objects.equals(name, testtype.name) && Objects.equals(description, testtype.description) && Objects.equals(collecting_method, testtype.collecting_method);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, collecting_method);
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