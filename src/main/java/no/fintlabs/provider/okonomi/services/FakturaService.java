package no.fintlabs.provider.okonomi.services;

import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.resource.okonomi.faktura.FakturaResource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FakturaService {

    public List<FakturaResource> add(List<FakturaResource> data) {
        return data.stream().collect(Collectors.toList());
    }

    public FakturaResource getFaktura(String fakturanummer) {
        FakturaResource faktura = new FakturaResource();
        faktura.setFakturanummer(createIdentifikator(fakturanummer));

        faktura.setBetalt(true);
        faktura.setFakturert(true);
        //faktura.setForfallsdato();
        faktura.setKreditert(false);
        faktura.setRestbelop(0L);

        char lastChar = fakturanummer.charAt(fakturanummer.length() - 1);

//        switch (lastChar) {
//            case '0':
//                faktura.setBetalt(true);
//                faktura.setFakturert(true);
//                faktura.setForfallsdato();
//                faktura.setKreditert(true);
//                faktura.setRestbelop(1000);
//            default:
//
//        }

        return faktura;
    }

    private Identifikator createIdentifikator(String fakturanummer) {
        Identifikator identifikator = new Identifikator();
        identifikator.setIdentifikatorverdi(fakturanummer);
        return identifikator;
    }
}
