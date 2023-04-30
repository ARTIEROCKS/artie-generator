package artie.generator.dto.bmle;

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

    public BML(String id, String character, String posture, String gazeTarget, String face, String gesture, String speechTone,
               String speechSpeed, String speechText){
        this.id = id;
        this.character = character;
        this.posture = Posture.builder().lexeme(posture).id(id).build();
        this.gaze = Gaze.builder().target(gazeTarget).id(id).build();
        this.face = Face.builder().lexeme(face).id(id).build();
        this.gesture = Gesture.builder().lexeme(gesture).build();
        this.speech = Speech.builder().tone(speechTone).speed(speechSpeed).text(speechText).build();
    }

}
