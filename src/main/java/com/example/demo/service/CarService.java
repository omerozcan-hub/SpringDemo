package com.example.demo.service;

import com.example.demo.exception.CarCouldNotDeletedException;
import com.example.demo.exception.CarListNotFoundException;
import com.example.demo.exception.CarNotFoundException;
import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;


@Service
public class CarService {
        private final CarRepository carRepository;

        public CarService(CarRepository carRepository){
            this.carRepository = carRepository;
        }
        public List<Car> getAllCars(){
            List<Car> Cars = carRepository.findAll();
            if (Cars.isEmpty()) {
                throw new CarListNotFoundException("Car list is empty ");
            }else{
                return Cars;
            }
        }
        public Car getCarByName(String name){
            return carRepository.findOneByName(name).orElseThrow(() ->
                    new CarNotFoundException("car not found with name: " + name));
        }
        public Car getCarById(int id) {
            return carRepository.findById(id).orElseThrow(() -> new CarNotFoundException("car not found with id: " + id));
        }
        public Car updateCarName(int id, String name){
            if(name != null){
                 Car c = carRepository.findById(id).orElseThrow(()->new CarNotFoundException("car not found with id: " + id));
                 c.setName(name);
                 carRepository.save(c);
                 return c;
            }else{
                System.out.println("updateCarName / null");
                return null;
            }
        }
        public Car updateCarCountry(int id, String country) {
            if (country != null) {
                Car c = carRepository.findById(id).orElseThrow(() -> new CarNotFoundException("car not found with id: " + id));
                c.setCountry(country);
                carRepository.save(c);
                return c;
            } else {
                System.out.println("Country is null");
                return null;
            }
        }
        public Car createCar(String name, String country){
            if (name!=null && country != null){
                Car c = new Car(name,country);
                carRepository.save(c);
                return c;
            }else {
                System.out.println("createCar / null");
                return null;
            }
        }
        public void deleteCar(int id){
            try {
                carRepository.deleteById(id);
            } catch (EmptyResultDataAccessException ex) {
                throw new CarCouldNotDeletedException("Car could not be deleted. Car not found with id: " + id);
            }
            /*
            car c = carRepository.getById(id);
            carRepository.delete(c);
             */
        }
        public List<Car> getByDate(LocalDate date){
            try {
                return carRepository.findByProductionDate(date);
            }catch (RuntimeException x){
                throw new CarNotFoundException("No Car produced on date:"+date);
            }
        }
        public List<Car> getCarProducedAfterDate(LocalDate date){
            try {
                return carRepository.findByProductionDateAfter(date);
            }catch (RuntimeException s){
                throw new CarListNotFoundException("there is no car produced on dates");
            }
        }
        public List<Car> getCarProducedBeforeDate(LocalDate date){
            try {
                return carRepository.findByProductionDateBefore(date);
            }catch (RuntimeException s){
                throw new CarListNotFoundException("there is no car produced on dates");
            }
        }
}
