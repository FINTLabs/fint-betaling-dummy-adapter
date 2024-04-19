package no.fintlabs.provider.okonomi.services;

import no.fint.model.resource.FintLinks;
import no.fint.model.resource.okonomi.faktura.FakturagrunnlagResource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FakturaGrunnlagService {

    public List<FakturagrunnlagResource> add(List<FintLinks> data) {
        return data.stream().map(this::convertToResource).collect(Collectors.toList());
    }

    private FakturagrunnlagResource convertToResource(FintLinks object) {
        FakturagrunnlagResource resource = new FakturagrunnlagResource();
        return resource;
    }

}
