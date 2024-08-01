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
@JacksonXmlRootElement(localName = "bmle-speech")
public class Speech {
    @JacksonXmlProperty(isAttribute = true)
    private String id;

    @JacksonXmlProperty(isAttribute = true)
    private String tone;

    @JacksonXmlProperty(isAttribute = true)
    private String speed;

    @JacksonXmlProperty(isAttribute = true)
    private Boolean end;

    @JacksonXmlProperty
    private String text;
}
