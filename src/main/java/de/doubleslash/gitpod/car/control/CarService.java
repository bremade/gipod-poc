package de.doubleslash.gitpod.car.control;

import static jakarta.transaction.Transactional.TxType.REQUIRED;
import static jakarta.transaction.Transactional.TxType.SUPPORTS;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;
import de.doubleslash.gitpod.car.entity.CarBE;
import java.util.Optional;

@ApplicationScoped
@Transactional(REQUIRED)
public class CarService {

    @Transactional(SUPPORTS)
    public List<CarBE> findAllCars() {
        return CarBE.listAll();
    }

    @Transactional(SUPPORTS)
    public Optional<CarBE> findById(@NotNull Long id) {
        return CarBE.findByIdOptional(id);
    }

    public CarBE persistCar(@Valid CarBE carBE) {
        carBE.persist();
        return carBE;
    }

    public CarBE replaceCar(@Valid CarBE carBE) {
        CarBE old = CarBE.findById(carBE.id);
        // error handling
        if (old == null) {
            return null;
        }
        old.brand = carBE.brand;
        old.model = carBE.model;
        return old;
    }

    public void deleteCar(@NotNull Long id) {
        CarBE.deleteById(id);
    }

    public void deleteCarByBrand(@NotNull String brand) {
        CarBE.delete("brand", brand);
    }

    public void deleteByDateBefore(Instant expiration) {
        CarBE.delete("date < ?1", expiration);
    }
}
