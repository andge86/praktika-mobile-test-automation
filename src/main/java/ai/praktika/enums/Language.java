package ai.praktika.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum Language {

    // This is one of the fast approaches to keep all the translations
    // Instead on this we can use language properties files with all the translations or some translation APIs

    ITALIAN("Italian", "Ciao!", true, "Ciao! Quali sono i suoi hobby e interessi?", "Qual è la sua lingua madre?"),
    SPANISH("Spanish", "¡Hola!", true, "¡Hola! ¿Cuáles son sus aficiones e intereses?", "¿Cuál es su lengua materna?"),
    ENGLISH("English", "Hello!", true, "Hello! What are your hobbies and interests?", "What is your native language?"),
    DUTCH("Dutch", "Hallo!", false, "", "");

    //TODO: add more languages and translated statements (especially for commonly used languages)

    private final String displayName;
    private final String greeting;
    private final boolean isFullySupported; // some do not provide full menu translation
    private final String hobbyAndInterestsQuestion;
    private final String motherTongueQuestion;

}
