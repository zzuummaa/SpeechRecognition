package ru.zuma.ruspeech;

import edu.cmu.sphinx.LiveSpeechRecognizerExtension;
import edu.cmu.sphinx.api.Configuration;

import java.io.IOException;

public class RuSpeech {
    private static final String ACOUSTIC_MODEL =
            "resource:/edu/cmu/sphinx/models/ru";
    private static final String DICTIONARY_PATH =
            "resource:/edu/cmu/sphinx/models/ru/ru.dic";
    private static final String GRAMMAR_PATH =
            "resource:/";
    private static final String LANGUAGE_MODEL =
            "resource:/edu/cmu/sphinx/models/ru/ru.lm";

    public static void main(String[] args) throws IOException {
        Configuration configuration = new Configuration();
        configuration.setAcousticModelPath(ACOUSTIC_MODEL);
        configuration.setDictionaryPath(DICTIONARY_PATH);
        configuration.setGrammarPath(GRAMMAR_PATH);
        configuration.setUseGrammar(true);

        configuration.setGrammarName("test");
        LiveSpeechRecognizerExtension jsgfRecognizer =
                new LiveSpeechRecognizerExtension(configuration);

        jsgfRecognizer.startRecognition(true);
        System.out.println("Скажи что нибудь.");
        while (true) {
            String utterance = jsgfRecognizer.getResult().getHypothesis();
            System.out.println("Вы сказали: " + utterance);

            if (utterance.equals("пока") | utterance.equals("до свидания") | utterance.equals("член")) {
                System.out.println("До свидания, господин!");
                jsgfRecognizer.stopRecognition();
                break;
            }
        }
    }
}
