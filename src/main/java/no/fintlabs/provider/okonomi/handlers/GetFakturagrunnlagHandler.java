package no.fintlabs.provider.okonomi.handlers;

import lombok.extern.slf4j.Slf4j;
import no.fint.event.model.Event;
import no.fint.event.model.ResponseStatus;
import no.fint.model.okonomi.faktura.FakturaActions;
import no.fintlabs.provider.adapter.Handler;
import no.fintlabs.provider.okonomi.services.FakturaGrunnlagService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;

@Slf4j
@Component
public class GetFakturagrunnlagHandler implements Handler {

    private final FakturaGrunnlagService fakturaGrunnlagService;

    public GetFakturagrunnlagHandler(FakturaGrunnlagService fakturaGrunnlagService) {
        this.fakturaGrunnlagService = fakturaGrunnlagService;
    }

    @Override
    public void accept(Event response) {
        log.info("GET Fakturagrunnlag: {}", response.getQuery());

        if (!StringUtils.startsWith(response.getQuery(), "ordrenummer/")) {
            response.setResponseStatus(ResponseStatus.REJECTED);
            response.setMessage("Invalid query " + response.getQuery());
            return;
        }

        response.addData(fakturaGrunnlagService.get(StringUtils.removeStart(response.getQuery(), "ordrenummer/")));
        response.setResponseStatus(ResponseStatus.ACCEPTED);

    }

    @Override
    public Set<String> actions() {
        return Collections.singleton(FakturaActions.GET_FAKTURAGRUNNLAG.name());
    }
}
