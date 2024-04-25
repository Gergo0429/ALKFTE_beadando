package edu.gde.alkfte_futok.controllers;

import edu.gde.alkfte_futok.controllers.dto.EredmenyDTO;
import edu.gde.alkfte_futok.models.Eredmeny;
import edu.gde.alkfte_futok.models.Verseny;
import edu.gde.alkfte_futok.repositories.EredmenyRepo;
import edu.gde.alkfte_futok.repositories.VersenyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class VersenyCtrl {

    @Autowired
    private VersenyRepo versenyRepo;

    @Autowired
    private EredmenyRepo eredmenyRepo;

    @GetMapping("/getRaceRunners/{ID}")
    public List<EredmenyDTO> getRaceRunners(@PathVariable long ID) {
        try {
            Verseny verseny = versenyRepo.findById(ID).get();
            List<Eredmeny> eredmenyek = eredmenyRepo.findByVerseny(verseny);
            List<EredmenyDTO> eredmenyDTO = new ArrayList<>();
            for (Eredmeny eredmeny : eredmenyek) {
                eredmenyDTO.add(new EredmenyDTO(eredmeny.getFuto().getNev(), eredmeny.getIdo()));
            }
            eredmenyDTO.sort(Comparator.comparingDouble(EredmenyDTO::getIdo));

            return eredmenyDTO;
        }
        catch (Exception e) {
            throw new NoSuchElementException();
        }
    }
}
