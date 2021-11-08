import com.vw.ipppdiffer.model.response.Element;
import com.vw.ipppdiffer.service.DifferServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DifferServiceImplTests {
    DifferServiceImpl service = new DifferServiceImpl();
    MockMultipartFile firstFile = new MockMultipartFile("IB100FF.xml", "IB100FF.xml", "text/xml",
            this.getClass().getClassLoader()
                    .getResourceAsStream("IB100FF.xml"));
    MockMultipartFile secondFile = new MockMultipartFile("IB100FF2.xml", "IB100FF2.xml", "text/xml",
            this.getClass().getClassLoader()
                    .getResourceAsStream("IB100FF2.xml"));

    public DifferServiceImplTests() throws IOException {
    }

    @Test
    void canParseValidTree() {
        Element element = service.getTreeStructure(firstFile);
        assertTrue(element != null);
    }

    @Test
    void canGetValidDiffer() {
        Object getDiffer = service.getDiffer(firstFile, secondFile);
        assertTrue(getDiffer != null);
    }
}
