package edu.gde.alkfte_futok.repositories;

import edu.gde.alkfte_futok.models.Eredmeny;
import edu.gde.alkfte_futok.models.Verseny;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EredmenyRepo extends JpaRepository<Eredmeny, Long> {
    List<Eredmeny> findByVerseny(Verseny verseny);
}
