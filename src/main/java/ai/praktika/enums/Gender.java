package ai.praktika.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum Gender {

    MALE("man"),
    FEMALE("woman"),
    PREFER_NOT_TO_SAY("unknown");

    private final String displayName;

}
