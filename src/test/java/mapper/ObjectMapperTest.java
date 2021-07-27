package mapper;

import com.tom.objectmapper.ObjectMapper;
import com.tom.objectmapper.exceptions.MappingException;
import com.tom.objectmapper.util.MappingUtilImpl;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ObjectMapperTest {

    private ObjectMapper mapper;
    private TestEntity entity;
    private TestDto dto;

    public ObjectMapperTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        mapper = new ObjectMapper(MappingUtilImpl.getInstance());
        entity = new TestEntity("TestEntity", 1, true, "transientFieldEntity");
        dto = new TestDto("TestDto", 2, false, "transientFieldDto");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testDtoToEntity() throws MappingException {
        // testTransient has to be null, because the field doesn't have annotation, so it is transient to the mapper.
        TestEntity expectedEntity = new TestEntity("TestDto", 2, false, null);
        TestEntity actual = mapper.mapObject(TestEntity.class, dto);
        assertThat(actual, is(expectedEntity));
    }
}
