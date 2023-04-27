%%% Elements definition

emotion(happy).
emotion(sad).
emotion(angry).
emotion(neutral).
emotion(fear).
emotion(surprise).

eyes(green).
eyes(blue).
eyes(yellow).
eyes(red).

toneOfVoice(high).
toneOfVoice(medium).
toneOfVoice(low).

voiceSpeed(high).
voiceSpeed(medium).
voiceSpeed(low).


%%% Valence definition

negative(emotion(sad)).
negative(emotion(angry)).
negative(emotion(fear)).
negative(eyes(red)).

indifferent(emotion(neutral)).
indifferent(eyes(blue)).
indifferent(eyes(yellow)).

positive(emotion(happy)).
positive(emotion(surprise)).
positive(eyes(green)).

encourage(toneOfVoice(high)).
encourage(voiceSpeed(high)).
calm(toneOfVoice(medium)).
calm(toneOfVoice(low)).
calm(voiceSpeed(medium)).
caml(voiceSpeed(low)).


%%% Grade definition

high(negative(emotion(angry))).
high(negative(emotion(fear))).
high(negative(eyes(red))).
high(positive(emotion(happy))).
high(positive(eyes(green))).
high(indifferent(eyes(yellow))).
high(calm(toneOfVoice(low))).
high(calm(voiceSpeed(low))).
high(encourage(toneOfVoice(high))).
high(encourage(voiceSpeed(high))).

low(negative(emotion(sad))).
low(indifferent(emotion(neutral))).
low(indifferent(eyes(blue))).
low(positive(emotion(surprise))).
low(calm(toneOfVoice(medium))).
low(calm(voiceSpeed(medium))).


%%% Eye selection actions definition

eyeSelection(X, Y) :- high(positive(emotion(X))), high(positive(eyes(Y))).
eyeSelection(X, Y) :- low(positive(emotion(X))), high(positive(eyes(Y))).
eyeSelection(X, Y) :- high(indifferent(emotion(X))), low(positive(eyes(Y))).
eyeSelection(X, Y) :- low(indifferent(emotion(X))), high(indifferent(eyes(Y))).
eyeSelection(X, Y) :- low(negative(emotion(X))), high(indifferent(eyes(Y))).
eyeSelection(X, Y) :- high(negative(emotion(X))), high(positive(eyes(Y))).


%%% Tone of voice selection actions definition

toneOfVoiceSelection(X, Y) :- positive(emotion(X)), encourage(toneOfVoice(Y)).
toneOfVoiceSelection(X, Y) :- indifferent(emotion(X)), encourage(toneOfVoice(Y)).
toneOfVoiceSelection(X, Y) :- high(negative(emotion(X))), high(calm(toneOfVoice(Y))).
toneOfVoiceSelection(X, Y) :- low(negative(emotion(X))), low(calm(toneOfVoice(Y))).


%%% Voice Speed selection actions definition

voiceSpeedSelection(X, Y) :- positive(emotion(X)), encourage(voiceSpeed(Y)).
voiceSpeedSelection(X, Y) :- indifferent(emotion(X)), encourage(voiceSpeed(Y)).
voiceSpeedSelection(X, Y) :- high(negative(emotion(X))), high(calm(voiceSpeed(Y))).
voiceSpeedSelection(X, Y) :- low(negative(emotion(X))), low(calm(voiceSpeed(Y))).