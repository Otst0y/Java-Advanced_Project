package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import project.service.PeriodicalsDTOHelper;
import project.service.PeriodicalsService;

import java.io.IOException;

@Controller
public class PeriodicalsController {

    @Autowired
    PeriodicalsService periodicalsService;

    @RequestMapping(value = "/addPeriodical", method = RequestMethod.POST)
    public ModelAndView createPeriodical(
            @RequestParam MultipartFile image,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam Double price) throws IOException {

        periodicalsService.save(PeriodicalsDTOHelper.createEntity(image, name, description, price));
        return new ModelAndView("redirect:/home");
    }
}
