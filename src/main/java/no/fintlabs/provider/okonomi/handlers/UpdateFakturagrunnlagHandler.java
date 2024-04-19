package no.fintlabs.provider.okonomi.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
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

    private final FakturaGrunnlagService fakturaGrunnlagService;

    private final ObjectMapper objectMapper;

    public UpdateFakturagrunnlagHandler(FakturaGrunnlagService fakturaGrunnlagService, ObjectMapper objectMapper) {
        this.fakturaGrunnlagService = fakturaGrunnlagService;
        this.objectMapper = objectMapper;
    }

    @Override
    public void accept(Event event) {
        log.info("Fakturagrunnlag recieved: {}", event.getCorrId());

        List<FakturagrunnlagResource> data = mapToResource(event.getData());

        event.setResponseStatus(ResponseStatus.ACCEPTED);
        event.setData(fakturaGrunnlagService.add(data));
    }

    @Override
    public Set<String> actions() {
        return Collections.singleton(FakturaActions.UPDATE_FAKTURAGRUNNLAG.name());
    }

    private List<FakturagrunnlagResource> mapToResource(List<FintLinks> fintLinks) {
        return objectMapper.convertValue(
                fintLinks,
                objectMapper.getTypeFactory().constructCollectionType(List.class, FakturagrunnlagResource.class)
        );
    }
}
