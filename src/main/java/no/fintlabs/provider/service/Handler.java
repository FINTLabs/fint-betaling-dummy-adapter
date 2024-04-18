package no.fintlabs.provider.service;

import no.fint.event.model.Event;
import no.fint.model.resource.FintLinks;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public interface Handler<T extends FintLinks> {

    default Set<String> actions() {
        return Collections.emptySet();
    }

    void accept(Event event, List<T> data);

    T cast(FintLinks object);

    default void castAndAccept(Event<? extends FintLinks> input) {
        List<T> castedList = cast(input.getData());
        accept(input, castedList);
    }

    default List<T> cast(List<? extends FintLinks> list) {
        return list.stream().map(this::cast).toList();
    }


}
