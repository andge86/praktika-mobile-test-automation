package ai.praktika.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum Age {

    AGE_UNDER_18("Under18"),
    AGE_18_24("18_24"),
    AGE_25_34("25_34"),
    AGE_35_44("35_44"),
    AGE_45_54("45_54"),
    AGE_55_64("55_64"),
    AGE_65_AND_OVER("Over65"),
    PREFER_NOT_TO_SAY("unknown");

    private final String displayName;

}
