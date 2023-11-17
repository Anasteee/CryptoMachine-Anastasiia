package org.javarush.anastasiia.language;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Text {
    private final String text;
    private final Language language;
}
