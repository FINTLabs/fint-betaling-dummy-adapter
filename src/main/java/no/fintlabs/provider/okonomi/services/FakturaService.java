package no.fintlabs.provider.okonomi.services;

import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.resource.okonomi.faktura.FakturaResource;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
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

        int lastDigit = Integer.parseInt(fakturanummer.substring(fakturanummer.length() - 1));

        switch (lastDigit) {
            case 0:
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DAY_OF_MONTH, 10);
                Date dueDate = calendar.getTime();

                faktura.setBetalt(false);
                faktura.setFakturert(true);
                faktura.setForfallsdato(dueDate);
                faktura.setKreditert(false);
                faktura.setRestbelop(500L);
                break;
            case 1:
                faktura.setBetalt(true);
                faktura.setFakturert(true);
                faktura.setKreditert(false);
                faktura.setRestbelop(0L);
                break;
            case 2:
                faktura.setBetalt(false);
                faktura.setFakturert(true);
                faktura.setKreditert(true);
                faktura.setRestbelop(0L);
                break;
            default:

        }

        return faktura;
    }

    private Identifikator createIdentifikator(String fakturanummer) {
        Identifikator identifikator = new Identifikator();
        identifikator.setIdentifikatorverdi(fakturanummer);
        return identifikator;
    }
}
