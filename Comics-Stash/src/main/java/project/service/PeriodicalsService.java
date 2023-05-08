package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.dao.PeriodicalRepository;
import project.domain.Periodical;

import java.util.List;

@Service
public class PeriodicalsService {

    @Autowired
    private PeriodicalRepository periodicalRepository;

    public Periodical save(Periodical periodical) {
        return periodicalRepository.save(periodical);
    }

    public List<Periodical> getAllPeriodicals(){
        return periodicalRepository.findAll();
    }



}
