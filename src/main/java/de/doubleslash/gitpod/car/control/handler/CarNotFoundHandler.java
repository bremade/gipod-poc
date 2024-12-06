package de.doubleslash.gitpod.car.control.handler;

import static jakarta.ws.rs.core.Response.Status.NOT_FOUND;

import de.doubleslash.gitpod.car.entity.ErrorEnum;
import de.doubleslash.gitpod.car.entity.ErrorResponse;
import de.doubleslash.gitpod.car.entity.exceptions.CarNotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class CarNotFoundHandler implements ExceptionMapper<CarNotFoundException> {

    @Override
    public Response toResponse(CarNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(ErrorEnum.CAR_NOT_FOUND.getId(), e.getMessage());
        return Response.status(NOT_FOUND.getStatusCode()).entity(errorResponse).build();
    }
}
