package edu.gde.alkfte_futok.controllers;

import edu.gde.alkfte_futok.controllers.dto.Eredmeny2DTO;
import edu.gde.alkfte_futok.models.Eredmeny;
import edu.gde.alkfte_futok.repositories.EredmenyRepo;
import edu.gde.alkfte_futok.repositories.FutoRepo;
import edu.gde.alkfte_futok.repositories.VersenyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EredmenyCtrl {
    @Autowired
    private EredmenyRepo eredmenyRepo;
    @Autowired
    private VersenyRepo versenyRepo;
    @Autowired
    private FutoRepo futoRepo;

    @PostMapping("/addResult")
    public ResponseEntity<Eredmeny> addResult(@RequestBody Eredmeny2DTO eredmenyDto) {
        if(versenyRepo.existsById(eredmenyDto.getVersenyID()) && futoRepo.existsById(eredmenyDto.getFutoID()) && eredmenyDto.getIdo() >= 0.0) {
            Eredmeny eredmeny = new Eredmeny();
            eredmeny.setVerseny(versenyRepo.findById(eredmenyDto.getVersenyID()).get());
            eredmeny.setFuto(futoRepo.findById(eredmenyDto.getFutoID()).get());
            eredmeny.setIdo(eredmenyDto.getIdo());
            eredmenyRepo.save(eredmeny);

            return ResponseEntity.ok(eredmeny);
        }
        else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/getAverageTime/{VERSENYID}")
    public ResponseEntity<Double> getAverageTime(@PathVariable long VERSENYID) {
        if(versenyRepo.existsById(VERSENYID)) {
            List<Eredmeny> eredmenyek = eredmenyRepo.findByVerseny(versenyRepo.findById(VERSENYID).get());
            Double sum = 0.0;
            Double count = 0.0;
            for (Eredmeny eredmeny : eredmenyek) {
                sum += eredmeny.getIdo();
                count ++;
            }
            return ResponseEntity.ok(sum / count);
        }
        else return ResponseEntity.badRequest().body(null);
    }

}
