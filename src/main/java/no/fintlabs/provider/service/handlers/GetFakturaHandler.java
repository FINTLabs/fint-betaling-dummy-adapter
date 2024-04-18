package no.fintlabs.provider.service.handlers;

import lombok.extern.slf4j.Slf4j;
import no.fint.event.model.Event;
import no.fint.model.okonomi.faktura.FakturaActions;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.okonomi.faktura.FakturaResource;
import no.fintlabs.provider.service.FakturaService;
import no.fintlabs.provider.service.Handler;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Slf4j
public class GetFakturaHandler implements Handler<FakturaResource> {

    FakturaService fakturaService;

    public GetFakturaHandler(FakturaService fakturaService) {
        this.fakturaService = fakturaService;
    }

    @Override
    public void accept(Event event, List<FakturaResource> input) {
        log.info("Get Faktura");
        event.setData(fakturaService.add(event.getData()));
    }

    @Override
    public FakturaResource cast(FintLinks input) {
        return (FakturaResource) input;
    }

    @Override
    public Set<String> actions() {
        return Collections.singleton(FakturaActions.GET_FAKTURA.name());
    }
}
