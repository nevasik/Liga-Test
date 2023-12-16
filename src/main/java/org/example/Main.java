package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(Persons.class);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                Persons persons = (Persons) unmarshaller.unmarshal(new File("import.xml"));

//              С помощью Set учитываем пункт с уникальностью
                Set<String> uniqueSNILS = new HashSet<>();
                persons.getPersons().removeIf(person -> !uniqueSNILS.add(person.getSNILS()));

                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
                objectMapper.writeValue(new File("db.json"), persons);

                System.out.println("Successful");

            } catch (JAXBException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}

//    private static List<Person> removingDuplicates(List<Person> people) {
//        return new ArrayList<>(people.stream()
//                .collect(Collectors.toMap(Person::getFIO, Function.identity(), (existing, replacement) -> existing))
//                .values());
//    }
