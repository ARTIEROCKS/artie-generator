package artie.pedagogicalintervention.generator.dto.bmle;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JacksonXmlRootElement(localName = "bml")
public class BML {

    @JacksonXmlProperty(isAttribute = true)
    private String character;
    @JacksonXmlProperty(isAttribute = true)
    private String id;

    private Posture posture;
    private Gaze gaze;
    private Face face;
    private Gesture gesture;
    @JacksonXmlProperty(localName = "bmle:speech")
    private Speech speech;

}
