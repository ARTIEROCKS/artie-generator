package artie.pedagogicalintervention.generator.test;

import artie.pedagogicalintervention.generator.dto.Action;
import artie.pedagogicalintervention.generator.dto.ActionInput;
import artie.pedagogicalintervention.generator.dto.Element;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ActionTest {

    private Action eyesSelection1;

    @BeforeEach
    void setUp() throws Exception {

       Element emotionHappy = Element.builder()
                .name("emotion")
                .value("happy")
                .valence("positive")
                .grade("high")
                .build();

        Element eyesGreen = Element.builder()
                .name("eyes")
                .value("green")
                .valence("positive")
                .grade("high")
                .build();

        ActionInput xInput = ActionInput.builder()
                .variableName("X")
                .elements(Arrays.asList(emotionHappy))
                .build();

        ActionInput yInput = ActionInput.builder()
                .variableName("Y")
                .elements(Arrays.asList(eyesGreen))
                .build();

        eyesSelection1 = Action.builder()
                .name("eyeSelection")
                .actionInputs(Arrays.asList(xInput, yInput))
                .build();
    }

    @Test
    void getVariableListTest(){
        assertEquals(eyesSelection1.getVariableList(), "X, Y");
    }

    @Test
    void getFunctionDefinitionTest(){
        assertEquals(eyesSelection1.getFunctionDefinition(), "high(positive(emotion(X))), high(positive(eyes(Y)))");
    }

    @Test
    void getPrologFunctionTest(){
        assertEquals(eyesSelection1.getPrologFunction(), "eyeSelection(X, Y) :- high(positive(emotion(X))), high(positive(eyes(Y))).");
    }

}
