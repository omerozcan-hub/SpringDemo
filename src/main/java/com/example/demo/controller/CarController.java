package com.example.demo.controller;

import com.example.demo.model.Car;
import com.example.demo.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(path = "/AllCars")
    public List<Car> getAllCar(){
        return carService.getAllCars();
    }

    @PostMapping(path = "/byId")
    public Car getCarById(@RequestParam Integer id){
        return carService.getCarById(id);
    }

    @GetMapping(path = "/byName")
    public Car getCarByName(@RequestParam("name") String name){
        return carService.getCarByName(name);
    }

    //-------------------update(put) ve create(post)-----------------------------
    @PutMapping(path="/updateName")
    public Car updateCarName(@RequestParam("id") int id, @RequestParam("name") String name){
        return carService.updateCarName(id,name);
    }

    @PutMapping(path = "/updateCountry")
    public Car updateCarCountry(@RequestParam("id") int id, @RequestParam("country") String country){
        return carService.updateCarCountry(id,country);
    }

    @PostMapping(path = "createCar")
    public Car createCar(@RequestBody Car c){
        return carService.createCar(c.getName(),c.getCountry());
    }

    @DeleteMapping(path = "/deleteCar")
    public List<Car> deleteCar(@RequestParam("id") int id){
        carService.deleteCar(id);
        return carService.getAllCars();
    }

    @GetMapping(path = "getByDate")
    public List<Car> getByDate(@RequestParam("date") LocalDate date){
        return carService.getByDate(date);
    }

    @GetMapping(path = "getCarProducedAfterDate")
    public List<Car> getCarProducedAfterDate(@RequestParam("date") LocalDate date){
        return carService.getCarProducedAfterDate(date);
    }

    @GetMapping(path = "getCarProducedBeforeDate")
    public List<Car> getCarProducedBeforeDate(@RequestParam("date") LocalDate date){
        return carService.getCarProducedBeforeDate(date);
    }
}
