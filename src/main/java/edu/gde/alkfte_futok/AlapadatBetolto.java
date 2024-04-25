package edu.gde.alkfte_futok;

import edu.gde.alkfte_futok.models.Eredmeny;
import edu.gde.alkfte_futok.models.Futo;
import edu.gde.alkfte_futok.models.Verseny;
import edu.gde.alkfte_futok.repositories.EredmenyRepo;
import edu.gde.alkfte_futok.repositories.FutoRepo;
import edu.gde.alkfte_futok.repositories.VersenyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class AlapadatBetolto implements CommandLineRunner {

    @Autowired
    private final FutoRepo futoRepo;
    @Autowired
    private final VersenyRepo versenyRepo;
    @Autowired
    private final EredmenyRepo eredmenyRepo;

    public AlapadatBetolto(FutoRepo futoRepo, VersenyRepo versenyRepo, EredmenyRepo eredmenyRepo) {
        this.futoRepo = futoRepo;
        this.versenyRepo = versenyRepo;
        this.eredmenyRepo = eredmenyRepo;
    }

    @Override
    public void run(String... args) {

        // Futok hozzaadasa

        Futo futo1 = new Futo();
        futo1.setNev("Zsigmond Gergő");
        futo1.setKor(23);
        futo1.setNem(false);
        futoRepo.save(futo1);

        Futo futo2 = new Futo();
        futo2.setNev("Nagy Csilla");
        futo2.setKor(22);
        futo2.setNem(true);
        futoRepo.save(futo2);

        Futo futo3 = new Futo();
        futo3.setNev("Kis Miska");
        futo3.setKor(25);
        futo3.setNem(false);
        futoRepo.save(futo3);

        Futo futo4 = new Futo();
        futo4.setNev("Feher Boglárka");
        futo4.setKor(24);
        futo4.setNem(true);
        futoRepo.save(futo4);


        //Versenyek hozzaadasa

        Verseny verseny1 = new Verseny();
        verseny1.setNev("Gyors Sprint");
        verseny1.setTav(0.1);
        versenyRepo.save(verseny1);

        Verseny verseny2 = new Verseny();
        verseny2.setNev("Hosszú Terepfutás");
        verseny2.setTav(20.0);
        versenyRepo.save(verseny2);


        //Eredmenyek hozzaadasa

        Eredmeny eredmeny1 = new Eredmeny();
        eredmeny1.setVerseny(verseny1);
        eredmeny1.setFuto(futo1);
        eredmeny1.setIdo(10.0);
        eredmenyRepo.save(eredmeny1);

        Eredmeny eredmeny2 = new Eredmeny();
        eredmeny2.setVerseny(verseny1);
        eredmeny2.setFuto(futo2);
        eredmeny2.setIdo(12.3);
        eredmenyRepo.save(eredmeny2);

        Eredmeny eredmeny3 = new Eredmeny();
        eredmeny3.setVerseny(verseny1);
        eredmeny3.setFuto(futo3);
        eredmeny3.setIdo(15.8);
        eredmenyRepo.save(eredmeny3);

        Eredmeny eredmeny4 = new Eredmeny();
        eredmeny4.setVerseny(verseny2);
        eredmeny4.setFuto(futo1);
        eredmeny4.setIdo(126);
        eredmenyRepo.save(eredmeny4);

        Eredmeny eredmeny5 = new Eredmeny();
        eredmeny5.setVerseny(verseny2);
        eredmeny5.setFuto(futo2);
        eredmeny5.setIdo(123);
        eredmenyRepo.save(eredmeny5);

        Eredmeny eredmeny6 = new Eredmeny();
        eredmeny6.setVerseny(verseny2);
        eredmeny6.setFuto(futo4);
        eredmeny6.setIdo(130);
        eredmenyRepo.save(eredmeny6);
    }
}

