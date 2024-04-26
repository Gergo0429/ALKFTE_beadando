package edu.gde.alkfte_futok.controllers;

import edu.gde.alkfte_futok.controllers.dto.EredmenyDTO;
import edu.gde.alkfte_futok.controllers.dto.VersenyDTO;
import edu.gde.alkfte_futok.models.Eredmeny;
import edu.gde.alkfte_futok.models.Verseny;
import edu.gde.alkfte_futok.repositories.EredmenyRepo;
import edu.gde.alkfte_futok.repositories.VersenyRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class VersenyCtrl {

    @Autowired
    private VersenyRepo versenyRepo;

    @Autowired
    private EredmenyRepo eredmenyRepo;

    @PostMapping("/addRace")
    public ResponseEntity<Verseny> addRace(@RequestBody @Valid VersenyDTO versenyDto) {
        Verseny verseny = new Verseny();
        verseny.setNev(versenyDto.getNev());
        verseny.setTav(versenyDto.getTav());

        versenyRepo.save(verseny);

        return ResponseEntity.ok(verseny);
    }

    @GetMapping("/getRace/{ID}")
    public ResponseEntity<Verseny> getRace(@PathVariable long ID) {
        if (versenyRepo.existsById(ID)) {
            Verseny verseny = versenyRepo.findById(ID).get();
            return ResponseEntity.ok(verseny);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getRaces")
    public List<Verseny> getRaces() {
        List<Verseny> versenyek = versenyRepo.findAll();
        return versenyek;
    }

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

    @PostMapping("/updateRace/{ID}")
    public ResponseEntity<Verseny> updateRace(@PathVariable long ID, @RequestBody @Valid VersenyDTO versenyDto) {
        if (versenyRepo.existsById(ID)) {
            Verseny verseny = versenyRepo.findById(ID).get();
            verseny.setNev(versenyDto.getNev());
            verseny.setTav(versenyDto.getTav());

            return ResponseEntity.ok(verseny);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
