package edu.gde.alkfte_futok.controllers;

import edu.gde.alkfte_futok.controllers.dto.FutoDTO;
import edu.gde.alkfte_futok.models.Futo;
import edu.gde.alkfte_futok.repositories.EredmenyRepo;
import edu.gde.alkfte_futok.repositories.FutoRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/futok")
public class FutoCtrl {
    @Autowired
    private FutoRepo futoRepo;

    @GetMapping("/getRunners")
    public List<Futo> getRunners() {return futoRepo.findAll();}

    @PostMapping("/addRunner")
    public ResponseEntity<Futo> addRunner(@RequestBody @Valid FutoDTO futoDto) {
        Futo futo = new Futo();
        futo.setNev(futoDto.getNev());
        futo.setKor(futoDto.getKor());
        futo.setNem(futoDto.isNem());
        futoRepo.save(futo);

        return ResponseEntity.ok(futo);
    }
}
