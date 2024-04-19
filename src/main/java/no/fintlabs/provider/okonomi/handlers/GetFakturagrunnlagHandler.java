package no.fintlabs.provider.okonomi.handlers;

import lombok.extern.slf4j.Slf4j;
import no.fint.event.model.Event;
import no.fint.model.okonomi.faktura.FakturaActions;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.okonomi.faktura.FakturagrunnlagResource;
import no.fintlabs.provider.adapter.Handler;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Slf4j
public class GetFakturagrunnlagHandler implements Handler {

    @Override
    public void accept(Event event) {
        log.info("Fakturagrunnlag accepted");

    }

    @Override
    public Set<String> actions() {
        return Collections.singleton(FakturaActions.GET_FAKTURAGRUNNLAG.name());
    }
}
