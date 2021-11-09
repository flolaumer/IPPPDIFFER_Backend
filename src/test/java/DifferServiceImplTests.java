import com.vw.ipppdiffer.model.response.DifferResponse;
import com.vw.ipppdiffer.model.response.Element;
import com.vw.ipppdiffer.service.DifferServiceImpl;
import com.vw.ipppdiffer.model.enums.ColourType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DifferServiceImplTests {
    private DifferServiceImpl service;
    private static final String FIRST_FILE = "IB100FF.xml";
    private static final String SECOND_FILE = "IB100FF2.xml";
    private MockMultipartFile firstFile;
    private MockMultipartFile secondFile;

    @BeforeEach
    public void setup() throws IOException {
        service = new DifferServiceImpl();
        firstFile = new MockMultipartFile(FIRST_FILE, FIRST_FILE, "text/xml",
                this.getClass().getClassLoader()
                        .getResourceAsStream(FIRST_FILE));
        secondFile = new MockMultipartFile(SECOND_FILE, SECOND_FILE, "text/xml",
                this.getClass().getClassLoader()
                        .getResourceAsStream(SECOND_FILE));
    }

    @Test
    void parseValidTree() {
        Element element = service.getTreeStructure(firstFile);
        assertNotNull(element);
        assertEquals("IB-1", element.getName());
        assertEquals(ColourType.BLACK.value, element.getColor());
        assertEquals(7, element.getChildren().size());
        assertEquals(1, element.getAttributes().size());
    }

    @Test
    void canGetValidDiffer() {
        DifferResponse getDiffer = service.getDiffer(firstFile, secondFile);
        Element firstTree = getDiffer.getFirstTree();
        Element secondTree = getDiffer.getSecondTree();
        assertNotNull(getDiffer);
        assertNotNull(firstTree);
        assertNotNull(secondTree);
        assertEquals("IB-1", firstTree.getName());
        assertEquals(ColourType.ORANGE.value, firstTree.getColor());
        assertEquals(7, firstTree.getChildren().size());
        assertEquals(1, firstTree.getAttributes().size());
        assertEquals("IB-1", secondTree.getName());
        assertEquals(ColourType.ORANGE.value, secondTree.getColor());
        assertEquals(7, secondTree.getChildren().size());
        assertEquals(1, secondTree.getAttributes().size());
    }
}
