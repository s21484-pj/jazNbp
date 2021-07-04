package pl.pjatk.jazs21484nbp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.jazs21484nbp.model.NbpResponse;
import pl.pjatk.jazs21484nbp.model.Root;
import pl.pjatk.jazs21484nbp.repository.NbpResponseRepository;

@Service
public class NbpService {

    private final RestTemplate restTemplate;
    private final NbpResponseRepository nbpResponseRepository;

    public NbpService(RestTemplate restTemplate, NbpResponseRepository nbpResponseRepository) {
        this.restTemplate = restTemplate;
        this.nbpResponseRepository = nbpResponseRepository;
    }

    public NbpResponse calculateAverageGoldPrice(String dateFrom, String dateTo) {
//        String url = "http://api.nbp.pl/api/cenyzlota/" + dateFrom + "/" + dateTo;
//        Root root = restTemplate.getForObject(url, Root.class);
        return nbpResponseRepository.save(new NbpResponse());
    }

//    private NbpResponse getNbpResponse(String dateFrom, String dateTo) {
//        NbpResponse nbpResponse = new NbpResponse();
//        nbpResponse.setGold(Gold.GOLD);
//        nbpResponse.setDateFrom(String.);
//
//        return nbpResponse;
//    }

}
