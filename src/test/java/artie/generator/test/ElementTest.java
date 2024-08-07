package artie.generator.test;
import artie.generator.dto.Element;
import artie.generator.type.PrologStringList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElementTest {

    private Element element1;
    private Element element2;
    private Element element3;

    @BeforeEach
    void setUp() throws Exception {
        element1 = Element.builder()
                .name("emotion")
                .value("happy")
                .valence("positive")
                .grade("high")
                .build();

        element2 = Element.builder()
                .name("emotion")
                .value("happy")
                .build();

        element3 = Element.builder()
                .name("emotion")
                .value("happy")
                .valence("positive")
                .build();
    }

    @Test
    void getPrologElementTest(){
        String element1Result1 = "emotion(happy)";
        String element1Result2 = "emotion(happyTest)";

        assertEquals(element1Result1, element1.getPrologElement());
        assertEquals(element1Result2, element1.getPrologElement(PrologStringList.builder().list(Arrays.asList("happyTest")).build()));
    }

    @Test
    void getPrologValenceTest(){
        String element1Result1 = "positive(emotion(happy))";
        String element1Result2 = "positive(emotion(happyTest))";

        assertEquals(element1Result1, element1.getPrologValence());
        assertEquals(element1Result2, element1.getPrologValence(PrologStringList.builder().list(Arrays.asList("happyTest")).build()));
    }

    @Test
    void getPrologGradeTest(){
        String element1Result1 = "high(positive(emotion(happy)))";
        String element1Result2 = "high(positive(emotion(happyTest)))";

        assertEquals(element1Result1, element1.getPrologGrade());
        assertEquals(element1Result2, element1.getPrologGrade(PrologStringList.builder().list(Arrays.asList("happyTest")).build()));
    }

    @Test
    void getHigherLevelTest(){
        String element1Result1 = "high(positive(emotion(happy)))";
        String element1Result2 = "high(positive(emotion(happyTest)))";
        String element2Result1 = "emotion(happy)";
        String element2Result2 = "emotion(happyTest)";
        String element3Result1 = "positive(emotion(happy))";
        String element3Result2 = "positive(emotion(happyTest))";

        assertEquals(element1Result1, element1.getHigherLevel(null));
        assertEquals(element1Result2, element1.getHigherLevel(PrologStringList.builder().list(Arrays.asList("happyTest")).build()));

        assertEquals(element2Result1, element2.getHigherLevel(null));
        assertEquals(element2Result2, element2.getHigherLevel(PrologStringList.builder().list(Arrays.asList("happyTest")).build()));

        assertEquals(element3Result1, element3.getHigherLevel(null));
        assertEquals(element3Result2, element3.getHigherLevel(PrologStringList.builder().list(Arrays.asList("happyTest")).build()));
    }
}
