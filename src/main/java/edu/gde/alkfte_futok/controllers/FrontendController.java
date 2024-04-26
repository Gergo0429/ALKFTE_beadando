package edu.gde.alkfte_futok.controllers;

import org.springframework.ui.Model;
import edu.gde.alkfte_futok.repositories.EredmenyRepo;
import edu.gde.alkfte_futok.repositories.VersenyRepo;
import edu.gde.alkfte_futok.models.Verseny;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FrontendController {
    @Autowired
    private VersenyRepo versenyRepo;

    @Autowired
    private EredmenyRepo eredmenyRepo;

    @GetMapping("/viewRaces")
    public String viewRaces(Model model) {
        List<Verseny> versenyek = versenyRepo.findAll();
        model.addAttribute("versenyek", versenyek);
        return "viewRaces";
    }

    @PostMapping("/addNewRace")
    public String addNewRace(@RequestParam("nev") String nev, @RequestParam("tav") double tav, Model model) {
        Verseny verseny = new Verseny();
        verseny.setNev(nev);
        verseny.setTav(tav);
        versenyRepo.save(verseny);

        return "redirect:/viewRaces";
    }
}
