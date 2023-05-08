package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import project.domain.Periodical;
import project.service.PeriodicalsService;

import javax.validation.Valid;

@Controller
public class PeriodicalsController {

    @Autowired
    PeriodicalsService periodicalsService;

    @RequestMapping(value = "/addPeriodical", method = RequestMethod.POST)
    public ModelAndView createPeriodical(@Valid @ModelAttribute("periodical") Periodical periodical,
                                         BindingResult bindingResult) {
        periodicalsService.save(periodical);
        return new ModelAndView("redirect:/home");
    }

}
