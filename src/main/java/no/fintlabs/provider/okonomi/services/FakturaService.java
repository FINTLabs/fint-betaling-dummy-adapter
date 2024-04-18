package no.fintlabs.provider.okonomi.services;

import no.fint.model.resource.okonomi.faktura.FakturaResource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FakturaService {

    public List<FakturaResource> add(List<FakturaResource> data) {
        return data.stream().collect(Collectors.toList());
    }
}
