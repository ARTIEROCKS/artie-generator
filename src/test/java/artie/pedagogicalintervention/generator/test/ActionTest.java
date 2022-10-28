package artie.pedagogicalintervention.generator.test;

import artie.pedagogicalintervention.generator.dto.Action;
import artie.pedagogicalintervention.generator.dto.ActionInput;
import artie.pedagogicalintervention.generator.dto.Element;
import artie.pedagogicalintervention.generator.type.PrologStringList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ActionTest {

    private Action eyesSelection1;
    private Action toneOfVoiceSelection1;

    private Action voiceSpeedSelection1;

    @BeforeEach
    void setUp() throws Exception {

       Element emotionHappy = Element.builder()
                .name("emotion")
                .value("happy")
                .valence("positive")
                .grade("high")
                .build();
        Element emotionHappyWithoutGrade = Element.builder()
                .name("emotion")
                .value("happy")
                .valence("positive")
                .build();
        Element eyesGreen = Element.builder()
                .name("eyes")
                .value("green")
                .valence("positive")
                .grade("high")
                .build();
        Element toneOfVoiceHigh = Element.builder()
                .name("toneOfVoice")
                .value("high")
                .valence("encourage")
                .grade("high")
                .build();
        Element voiceSpeed = Element.builder()
                .name("voiceSpeed")
                .value("high")
                .valence("encourage")
                .build();
        Element toneOfVoiceSelectionFunction = Element.builder()
                .name("toneOfVoiceSelection")
                .build();


        ActionInput eyesSelection1xInput = ActionInput.builder()
                .variablesNames(PrologStringList.builder().list(Arrays.asList("X")).build())
                .elements(Arrays.asList(emotionHappy))
                .build();
        ActionInput eyesSelection1yInput = ActionInput.builder()
                .variablesNames(PrologStringList.builder().list(Arrays.asList("Y")).build())
                .elements(Arrays.asList(eyesGreen))
                .build();
        eyesSelection1 = Action.builder()
                .name("eyeSelection")
                .actionInputs(Arrays.asList(eyesSelection1xInput, eyesSelection1yInput))
                .build();

        ActionInput toneOfVoiceSelection1xyInput = ActionInput.builder()
                .variablesNames(PrologStringList.builder().list(Arrays.asList("X", "Y")).build())
                .elements(Arrays.asList(toneOfVoiceHigh))
                .build();
        ActionInput toneOfVoiceSelection1xyzInput = ActionInput.builder()
                .variablesNames(PrologStringList.builder().list(Arrays.asList("X", "Y", "Z")).build())
                .elements(Arrays.asList(emotionHappy))
                .build();
        ActionInput toneOfVoiceSelection1yzInput = ActionInput.builder()
                .variablesNames(PrologStringList.builder().list(Arrays.asList("Y", "Z")).build())
                .elements(Arrays.asList(eyesGreen))
                .build();
        toneOfVoiceSelection1 = Action.builder()
                .name("toneOfVoiceSelection")
                .actionInputs(Arrays.asList(toneOfVoiceSelection1xyInput, toneOfVoiceSelection1xyzInput, toneOfVoiceSelection1yzInput))
                .build();


        ActionInput voiceSpeedSelection1wxzInput = ActionInput.builder()
                .variablesNames(PrologStringList.builder().list(Arrays.asList("W", "X", "Z")).build())
                .elements(Arrays.asList(voiceSpeed, emotionHappyWithoutGrade))
                .build();
        ActionInput voiceSpeedSelection1xyzInput = ActionInput.builder()
                .variablesNames(PrologStringList.builder().list(Arrays.asList("X", "Y", "Z")).build())
                .elements(Arrays.asList(toneOfVoiceSelectionFunction))
                .build();
        voiceSpeedSelection1 = Action.builder()
                .name("voiceSpeedSelection")
                .actionInputs(Arrays.asList(voiceSpeedSelection1wxzInput, voiceSpeedSelection1xyzInput))
                .build();
    }

    @Test
    void getVariableListTest(){
        assertEquals("X, Y", eyesSelection1.getVariableList());
        assertEquals("X, Y, Z", toneOfVoiceSelection1.getVariableList());
    }

    @Test
    void getFunctionDefinitionTest(){
        assertEquals("high(positive(emotion(X))), high(positive(eyes(Y)))", eyesSelection1.getFunctionDefinition());
        assertEquals("high(encourage(toneOfVoice(X, Y))), high(positive(emotion(X, Y, Z))), high(positive(eyes(Y, Z)))", toneOfVoiceSelection1.getFunctionDefinition());
    }

    @Test
    void getPrologFunctionTest(){
        assertEquals("eyeSelection(X, Y) :- high(positive(emotion(X))), high(positive(eyes(Y))).", eyesSelection1.getPrologFunction());
        assertEquals("toneOfVoiceSelection(X, Y, Z) :- high(encourage(toneOfVoice(X, Y))), high(positive(emotion(X, Y, Z))), high(positive(eyes(Y, Z))).", toneOfVoiceSelection1.getPrologFunction());
        assertEquals("voiceSpeedSelection(W, X, Z, Y) :- encourage(voiceSpeed(W, X, Z)), positive(emotion(W, X, Z)), toneOfVoiceSelection(X, Y, Z).", voiceSpeedSelection1.getPrologFunction());
    }

}
