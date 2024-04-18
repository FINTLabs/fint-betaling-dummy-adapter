package no.fintlabs.provider.service.handlers;

import lombok.extern.slf4j.Slf4j;
import no.fint.event.model.Event;
import no.fint.model.okonomi.faktura.FakturaActions;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.okonomi.faktura.FakturagrunnlagResource;
import no.fintlabs.provider.service.Handler;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Slf4j
public class GetFakturagrunnlagHandler implements Handler<FakturagrunnlagResource> {

    @Override
    public void accept(Event event, List<FakturagrunnlagResource> input) {
        log.info("Fakturagrunnlag accepted");

    }

    @Override
    public FakturagrunnlagResource cast(FintLinks input) {
        return (FakturagrunnlagResource) input;
    }

    @Override
    public Set<String> actions() {
        return Collections.singleton(FakturaActions.GET_FAKTURAGRUNNLAG.name());
    }
}
