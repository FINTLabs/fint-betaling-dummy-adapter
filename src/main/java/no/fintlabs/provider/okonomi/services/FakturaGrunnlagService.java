package no.fintlabs.provider.okonomi.services;

import no.fint.model.resource.Link;
import no.fint.model.resource.okonomi.faktura.FakturagrunnlagResource;
import no.fint.model.resource.okonomi.faktura.FakturagrunnlagResources;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FakturaGrunnlagService {

    public static final int INITIAL_ORDER_NUMBER = 10000;

    private final Map<String, FakturagrunnlagResource> fakturagrunnlag = new HashMap<>();

    public List<FakturagrunnlagResource> add(List<FakturagrunnlagResource> data) {
        return data
                .stream()
                .peek(this::handleNewResource)
                .peek(resource -> fakturagrunnlag.put(resource.getOrdrenummer().getIdentifikatorverdi(), resource))
                .collect(Collectors.toList());
    }

    private void handleNewResource(FakturagrunnlagResource resource) {

        int ordrenummer = Integer.parseInt(resource.getOrdrenummer().getIdentifikatorverdi());
        int fakturanummer = ordrenummer - INITIAL_ORDER_NUMBER;

        int lastNumber = ordrenummer % 10;

        if (lastNumber < 3) {
            Link fakturaLink = new Link();
            fakturaLink.setVerdi("${okonomi.faktura.faktura}/fakutranummer/" + fakturanummer);
            resource.addFaktura(fakturaLink);
        }
    }

    public FakturagrunnlagResource get(String ordernummer) {
        FakturagrunnlagResource resource = fakturagrunnlag.get(ordernummer);
        if (resource != null) {
            return resource;
        }

        FakturagrunnlagResource newResource = new FakturagrunnlagResource();
        handleNewResource(newResource);
        fakturagrunnlag.put(ordernummer.toString(), newResource);
        return newResource;
    }
}
