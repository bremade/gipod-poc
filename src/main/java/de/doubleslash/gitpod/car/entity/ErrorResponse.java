package de.doubleslash.gitpod.car.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@AllArgsConstructor
@Getter
public class ErrorResponse {
    long id;
    String message;
    Instant timestamp = Instant.now();

    public ErrorResponse(long id, String message) {
        this.id = id;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorResponse [id=" + id + ", message=" + message + ", timestamp=" + timestamp + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ErrorResponse other) {
            return this.id == other.id && this.message.equals(other.message) && this.timestamp.truncatedTo
                (ChronoUnit.SECONDS).equals(other.timestamp.truncatedTo(ChronoUnit.SECONDS));
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, timestamp.truncatedTo(ChronoUnit.SECONDS));
    }
}
