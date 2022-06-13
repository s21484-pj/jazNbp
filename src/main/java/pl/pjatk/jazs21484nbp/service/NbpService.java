package pl.pjatk.jazs21484nbp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.jazs21484nbp.model.Gold;
import pl.pjatk.jazs21484nbp.model.Root;
import pl.pjatk.jazs21484nbp.model.NbpResponse;
import pl.pjatk.jazs21484nbp.repository.NbpResponseRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@Service
public class NbpService {

    private final RestTemplate restTemplate;
    private final NbpResponseRepository nbpResponseRepository;

    public NbpService(RestTemplate restTemplate, NbpResponseRepository nbpResponseRepository) {
        this.restTemplate = restTemplate;
        this.nbpResponseRepository = nbpResponseRepository;
    }

    public NbpResponse calculateAverageGoldPrice(String dateFrom, String dateTo) {
        String url = "http://api.nbp.pl/api/cenyzlota/" + dateFrom + "/" + dateTo;
        Root[] roots = restTemplate.getForObject(url, Root[].class);
        double average = calculate(roots);
        NbpResponse nbpResponse = getNbpResponse(dateFrom, dateTo, average);
        return nbpResponseRepository.save(nbpResponse);
    }

    private NbpResponse getNbpResponse(String dateFrom, String dateTo, double average) {
        NbpResponse nbpResponse = new NbpResponse();
        nbpResponse.setGold(Gold.GOLD);
        nbpResponse.setDateFrom(LocalDate.parse(dateFrom));
        nbpResponse.setDateTo(LocalDate.parse(dateTo));
        nbpResponse.setAverage(average);
        nbpResponse.setCreatedAt(LocalDateTime.now());
        return nbpResponse;
    }

    private double calculate(Root[] roots) {
        return Arrays.stream(roots)
                .mapToDouble(Root::getCena)
                .average()
                .orElse(0.0);
    }
}
