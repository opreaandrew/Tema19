package ro.fasttrackit.homework19;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Long.*;

@Component
public class CountryReader {
    List<Country> countries = new ArrayList<>();


    public List<Country> readCountries() {
        int id = 1;
        try (Scanner reader = new Scanner(Path.of("src/main/resources/files/countries.txt"))) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] tokens = line.split("[|]");

                countries.add(Country.builder()
                        .id(id++)
                        .name(tokens[0])
                        .capital(tokens[1])
                        .population(parseLong(tokens[2]))
                        .area(parseLong(tokens[3]))
                        .continent(tokens[4])
                        .neighbours(neighbourValidator(tokens))
                        .build());
            }
            return countries;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String neighbourValidator(String[] string) {
        if (string.length < 6 || string[5].isEmpty()) {
            return null;
        }
        return string[5];
    }
}
