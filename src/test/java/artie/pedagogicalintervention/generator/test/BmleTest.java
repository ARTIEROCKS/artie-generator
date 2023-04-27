package artie.pedagogicalintervention.generator.test;

import artie.pedagogicalintervention.generator.dto.bmle.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class BmleTest {

    private XmlMapper xmlMapper;
    private Posture posture;
    private Gaze gaze;
    private Face face;
    private Gesture gesture;
    private Speech speech;
    private BML bml;

    @BeforeEach
    void setUp() throws Exception {
        xmlMapper = new XmlMapper();
        posture = Posture.builder().id("1").lexeme("Stand").build();
        gaze = Gaze.builder().id("2").target("student 1").build();
        face = Face.builder().id("3").lexeme("HAPPY").build();
        gesture = Gesture.builder().id("4").lexeme("CONGRATS").build();
        speech = Speech.builder().id("5").tone("HIGH").speed("LOW").text("Hello! how are you today?").build();
        bml = BML.builder().id("0").character("NAO").posture(posture).gaze(gaze).face(face).gesture(gesture).speech(speech).build();
    }

    @Test
    void postureXMLSerialization() throws JsonProcessingException {

        //Test the posture xml serialization
        String xml = xmlMapper.writeValueAsString(posture);
        String xmlResult = "<posture id=\"1\" lexeme=\"Stand\"/>";

        //We check that the xml is as expected
        assertEquals(xmlResult, xml);
    }

    @Test
    void gazeXMLSerialization() throws JsonProcessingException {

        //Test the gaze xml serialization
        String xml = xmlMapper.writeValueAsString(gaze);
        String xmlResult = "<gaze id=\"2\" target=\"student 1\"/>";

        //We check that the xml is as expected
        assertEquals(xmlResult, xml);
    }

    @Test
    void faceXMLSerialization() throws JsonProcessingException {

        //Test the face xml serialization
        String xml = xmlMapper.writeValueAsString(face);
        String xmlResult = "<face id=\"3\" lexeme=\"HAPPY\"/>";

        //We check that the xml is as expected
        assertEquals(xmlResult, xml);
    }

    @Test
    void gestureXMLSerialization() throws JsonProcessingException {

        //Test the gesture xml serialization
        String xml = xmlMapper.writeValueAsString(gesture);
        String xmlResult = "<gesture id=\"4\" lexeme=\"CONGRATS\"/>";

        //We check that the xml is as expected
        assertEquals(xmlResult, xml);
    }

    @Test
    void speechXMLSerialization() throws JsonProcessingException {

        //Test the gesture xml serialization
        String xml = xmlMapper.writeValueAsString(speech);
        String xmlResult = "<bmle:speech id=\"5\" tone=\"HIGH\" speed=\"LOW\"><text>Hello! how are you today?</text></bmle:speech>";

        //We check that the xml is as expected
        assertEquals(xmlResult, xml);
    }

    @Test
    void bmlXMLSerialization() throws JsonProcessingException {

        //Test the gesture xml serialization
        String xml = xmlMapper.writeValueAsString(bml);
        String xmlResult = "<bml character=\"NAO\" id=\"0\"><posture id=\"1\" lexeme=\"Stand\"/><gaze id=\"2\" target=\"student 1\"/><face id=\"3\" lexeme=\"HAPPY\"/><gesture id=\"4\" lexeme=\"CONGRATS\"/><bmle:speech id=\"5\" tone=\"HIGH\" speed=\"LOW\"><text>Hello! how are you today?</text></bmle:speech></bml>";

        //We check that the xml is as expected
        assertEquals(xmlResult, xml);
    }
}
