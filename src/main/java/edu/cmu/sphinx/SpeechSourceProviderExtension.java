package edu.cmu.sphinx;

import edu.cmu.sphinx.api.Microphone;

public class SpeechSourceProviderExtension {
    private final static Microphone mic = new Microphone(16000, 16, true, false);

    Microphone getMicrophone() {
        return mic;
    }
}
