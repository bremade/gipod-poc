package de.doubleslash.gitpod.car.boundary;

import de.doubleslash.gitpod.car.control.CarService;
import de.doubleslash.gitpod.car.entity.CarBE;
import de.doubleslash.gitpod.car.entity.CarCheckMappingRequest;
import de.doubleslash.gitpod.car.entity.exceptions.CarNotFoundException;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.jboss.resteasy.reactive.RestResponse;


@AllArgsConstructor
@Path("/cars")
public class CarResource {

    @Inject
    private CarService carService;

    @GET
    public RestResponse<List<CarBE>> all() {
        List<CarBE> cars = carService.findAllCars();
        if (cars.isEmpty()) {
            throw new CarNotFoundException();
        } else {
            return RestResponse.ok(cars);
        }
    }

    @GET
    @Path("/{id}")
    public RestResponse<CarBE> get(@PathParam("id") Long id) throws CarNotFoundException {
        Optional<CarBE> carOptional = carService.findById(id);
        if (carOptional.isPresent()) {
            return RestResponse.ok(carOptional.get());
        } else {
            throw new CarNotFoundException(id);
        }
    }

    @POST
    public RestResponse<CarBE> replaceCar(CarCheckMappingRequest carCheckRequest) {
        return RestResponse.ok(carService.replaceCar(carCheckRequest.mapToCarEntity()));
    }

    @DELETE
    @Path("/{id}")
    public RestResponse<Void> deleteCar(@PathParam("id") Long id) {
        Optional<CarBE> car = carService.findById(id);
        if (car.isPresent()) {
            carService.deleteCar(id);
            return RestResponse.noContent();
        } else {
            throw new CarNotFoundException(id);
        }
    }

    @DELETE()
    @Path("/brand/{brand}")
    public RestResponse<Void> deleteCarByBrand(@PathParam("brand") String brand) {
        carService.deleteCarByBrand(brand);
        return RestResponse.noContent();
    }
}
