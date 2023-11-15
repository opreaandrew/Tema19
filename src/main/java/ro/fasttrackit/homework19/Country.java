package ro.fasttrackit.homework19;

import lombok.Builder;

@Builder
public record Country(
        int id,
        String name,
        String capital,
        long population,
        long area,
        String continent,
        String neighbours) {
}
