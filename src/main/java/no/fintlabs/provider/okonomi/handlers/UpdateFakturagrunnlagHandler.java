package no.fintlabs.provider.okonomi.handlers;

import lombok.extern.slf4j.Slf4j;
import no.fint.event.model.Event;
import no.fint.event.model.ResponseStatus;
import no.fint.model.okonomi.faktura.FakturaActions;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.okonomi.faktura.FakturagrunnlagResource;
import no.fintlabs.provider.adapter.Handler;
import no.fintlabs.provider.okonomi.services.FakturaGrunnlagService;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Slf4j
@Component
public class UpdateFakturagrunnlagHandler implements Handler {

    FakturaGrunnlagService fakturaGrunnlagService;

    public UpdateFakturagrunnlagHandler(FakturaGrunnlagService fakturaGrunnlagService) {
        this.fakturaGrunnlagService = fakturaGrunnlagService;
    }

    @Override
    public void accept(Event event) {
        log.info("Fakturagrunnlag recieved: {}", event.getCorrId());
        event.setResponseStatus(ResponseStatus.ACCEPTED);
        event.setData(fakturaGrunnlagService.add(event.getData()));
    }

    @Override
    public Set<String> actions() {
        return Collections.singleton(FakturaActions.UPDATE_FAKTURAGRUNNLAG.name());
    }
}
