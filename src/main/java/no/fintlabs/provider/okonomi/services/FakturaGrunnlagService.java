package no.fintlabs.provider.okonomi.services;

import no.fint.model.resource.okonomi.faktura.FakturagrunnlagResource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FakturaGrunnlagService {

    public List<FakturagrunnlagResource> add(List<FakturagrunnlagResource> data) {
        return data.stream().collect(Collectors.toList());
    }

}
