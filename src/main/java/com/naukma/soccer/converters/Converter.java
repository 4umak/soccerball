package com.naukma.soccer.converters;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface Converter<FROM, TO> {

    TO convert(FROM from);

    default List<TO> convertAll(Collection<FROM> objects) {
        return objects.stream().map(this::convert).collect(Collectors.toList());
    }
}

