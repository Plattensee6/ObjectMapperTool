package mapper;

import com.tom.objectmapper.annotations.ElementToMap;
import com.tom.objectmapper.annotations.MappedEntity;
import java.util.Objects;

@MappedEntity(entityName = "testEntity")
public class TestDto {
    @ElementToMap
    private String testName;
    @ElementToMap
    private int testInt;
    @ElementToMap
    private boolean testBoolean;
    
    private String testTransient;

    public TestDto() {
    }

    public TestDto(String testName, int testInt, boolean testBoolean, String testTransient) {
        this.testName = testName;
        this.testInt = testInt;
        this.testBoolean = testBoolean;
        this.testTransient = testTransient;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.testName);
        hash = 13 * hash + this.testInt;
        hash = 13 * hash + (this.testBoolean ? 1 : 0);
        hash = 13 * hash + Objects.hashCode(this.testTransient);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TestDto other = (TestDto) obj;
        if (this.testInt != other.testInt) {
            return false;
        }
        if (this.testBoolean != other.testBoolean) {
            return false;
        }
        if (!Objects.equals(this.testName, other.testName)) {
            return false;
        }
        if (!Objects.equals(this.testTransient, other.testTransient)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TestDto{" + "testName=" + testName + ", testInt=" + testInt + ", testBoolean=" + testBoolean + ", testTransient=" + testTransient + '}';
    }

   
    
    
}
