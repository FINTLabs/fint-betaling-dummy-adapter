package no.fintlabs.provider.okonomi.handlers;

import lombok.extern.slf4j.Slf4j;
import no.fint.event.model.Event;
import no.fint.event.model.ResponseStatus;
import no.fint.model.okonomi.faktura.FakturaActions;
import no.fintlabs.provider.adapter.Handler;
import no.fintlabs.provider.okonomi.services.FakturaService;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.Set;

@Slf4j
public class GetFakturaHandler implements Handler {

    private final FakturaService fakturaService;

    public GetFakturaHandler(FakturaService fakturaService) {
        this.fakturaService = fakturaService;
    }

    @Override
    public void accept(Event response) {
        log.info("Get Faktura");

        if (!StringUtils.startsWith(response.getQuery(), "fakturanummer/")) {
            response.setResponseStatus(ResponseStatus.REJECTED);
            response.setMessage("Invalid query " + response.getQuery());
            return;
        }

        response.addData(fakturaService.getFaktura(StringUtils.removeStart(response.getQuery(), "fakturanummer/")));
        response.setResponseStatus(ResponseStatus.ACCEPTED);
    }

    @Override
    public Set<String> actions() {
        return Collections.singleton(FakturaActions.GET_FAKTURA.name());
    }
}
