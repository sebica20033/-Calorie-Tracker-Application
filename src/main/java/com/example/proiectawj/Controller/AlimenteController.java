package com.example.proiectawj.Controller;

import com.example.proiectawj.Dto.CalculationRequest;
import com.example.proiectawj.Model.Alimente;
import com.example.proiectawj.Service.AlimenteService;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/alimente")



@CrossOrigin(origins = "http://localhost:8080")
public class AlimenteController {
    private final AlimenteService alimenteService;

    public AlimenteController(AlimenteService alimenteService) {
        this.alimenteService = alimenteService;
    }
/// Preluare elemente din baza de date
    @GetMapping("/getall")
    public List<Alimente> getAllAlimente() {
        return alimenteService.getAllAlimente();
    }
///  Adaugare elemnte in baza de date
    @PostMapping
    public Alimente addAlimente(@RequestBody Alimente alimente) {
        return alimenteService.saveAlimente(alimente);
    }
    ///  Sterge element din baza de date
    @DeleteMapping("/{id}")
    public void deleteAliment(@PathVariable int id) {
        alimenteService.deleteAliment(id);
    }
/// Update element in baza de date
    @PutMapping("/{id}")
    public Alimente updateAliment(@PathVariable int id, @RequestBody Alimente updatedAliment) {
        return alimenteService.updateAliment(id, updatedAliment);
    }
    ///  Calculator
    @PostMapping("/calculate")
    public Map<String, Object> calculate(@RequestBody CalculationRequest request) {
        System.out.println("Received request: " + request);

        double BMR = 66 + (13.7 * request.getWeight()) + (5 * request.getHeight()) - (6.8 * request.getAge());
        System.out.println("Calculated BMR: " + BMR);

        double TDEE = BMR * request.getActivityLevel();
        System.out.println("Calculated TDEE: " + TDEE);

        double totalCalories = request.getFoods().stream()
                .mapToDouble(food -> {
                    Alimente aliment = alimenteService.getAlimentById(food.getId());
                    if (aliment != null) {
                        System.out.println("Found aliment: " + aliment.getNume());
                        return (aliment.getCalorii() / 100.0) * food.getQuantity();
                    }
                    System.out.println("Aliment not found for ID: " + food.getId());
                    return 0.0;
                })
                .sum();

        System.out.println("Total Calories: " + totalCalories);

        String message = totalCalories <= TDEE * 0.8
                ? "Ești în deficit caloric. Continuă așa!"
                : "Nu ești în deficit caloric. Revizuiește alimentația.";

        System.out.println("Message: " + message);

        Map<String, Object> response = new HashMap<>();
        response.put("TDEE", TDEE);
        response.put("totalCalories", totalCalories);
        response.put("message", message);

        return response;
    }


}
