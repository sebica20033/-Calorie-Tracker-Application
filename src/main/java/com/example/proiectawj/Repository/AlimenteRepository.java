package com.example.proiectawj.Repository;

import com.example.proiectawj.Model.Alimente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlimenteRepository extends JpaRepository<Alimente, Integer> {
    // Poți adăuga metode personalizate, dacă e nevoie.
}
