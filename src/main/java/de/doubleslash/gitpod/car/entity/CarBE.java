package de.doubleslash.gitpod.car.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "car")
@Getter
@Setter
public class CarBE extends PanacheEntityBase {

    // primary key
    @Id
    // use the named generator
    @GeneratedValue(generator = "car_sequence", strategy = GenerationType.SEQUENCE)
    // associate this generator with the sequence from the database
    @SequenceGenerator(name = "car_sequence", sequenceName = "car_sequence", allocationSize = 1)
    public Long id;

    @NotNull
    public String model;

    @NotNull
    public String brand;

    @Column(name = "created_at")
    @CreationTimestamp
    public Instant date;

    @Override
    public String toString() {
        return "Car{" +
            " id = " + id +
            ", model = " + model +
            ", brand = " + brand +
            " }";
    }

    @Override
    public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
        if (other instanceof CarBE carBE) {
            // Object.equals to account for possible null values
            return Objects.equals(this.id, carBE.id) && Objects.equals(this.model, carBE.model)
                && Objects.equals(this.brand, carBE.brand);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, brand);
    }
}
