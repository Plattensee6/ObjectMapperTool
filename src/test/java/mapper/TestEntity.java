package mapper;

import com.tom.objectmapper.annotations.ElementToMap;
import com.tom.objectmapper.annotations.MappedEntity;
import java.util.Objects;

@MappedEntity(entityName = "testEntity")
public class TestEntity {
    @ElementToMap
    private String testName;
    @ElementToMap
    private int testInt;
    @ElementToMap
    private boolean testBoolean;
    
    private String testTransient;

    public TestEntity() {
    }

    public TestEntity(String testName, int testInt, boolean testBoolean, String testTransient) {
        this.testName = testName;
        this.testInt = testInt;
        this.testBoolean = testBoolean;
        this.testTransient = testTransient;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.testName);
        hash = 37 * hash + this.testInt;
        hash = 37 * hash + (this.testBoolean ? 1 : 0);
        hash = 37 * hash + Objects.hashCode(this.testTransient);
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
        final TestEntity other = (TestEntity) obj;
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
        return "TestEntity{" + "testName=" + testName + ", testInt=" + testInt + ", testBoolean=" + testBoolean + ", testTransient=" + testTransient + '}';
    }

    
}
