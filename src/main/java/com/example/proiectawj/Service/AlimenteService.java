package com.example.proiectawj.Service;

import com.example.proiectawj.Model.Alimente;
import org.springframework.stereotype.Service;
import com.example.proiectawj.Repository.AlimenteRepository;

import java.util.List;

@Service
public class AlimenteService {
    private final AlimenteRepository alimenteRepository;

    public AlimenteService(AlimenteRepository alimenteRepository) {
        this.alimenteRepository = alimenteRepository;
    }

    public List<Alimente> getAllAlimente() {
        return alimenteRepository.findAll();
    }

    public Alimente saveAlimente(Alimente alimente) {
        return alimenteRepository.save(alimente);
    }
    public void deleteAliment(int id) {
        alimenteRepository.deleteById(id);
    }
    public Alimente updateAliment(int id, Alimente updatedAliment) {
        return alimenteRepository.findById(id).map(aliment -> {
            aliment.setNume(updatedAliment.getNume());
            aliment.setCalorii(updatedAliment.getCalorii());
            aliment.setProteine(updatedAliment.getProteine());
            aliment.setCarbohidrati(updatedAliment.getCarbohidrati());
            aliment.setGrasimi(updatedAliment.getGrasimi());
            return alimenteRepository.save(aliment);
        }).orElseThrow(() -> new RuntimeException("Aliment not found with id " + id));
    }

    public Alimente getAlimentById(int id) {
        return alimenteRepository.findById(id).orElse(null);
    }

}
