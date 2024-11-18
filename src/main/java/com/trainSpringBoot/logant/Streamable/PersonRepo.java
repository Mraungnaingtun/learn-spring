package com.trainSpringBoot.logant.Streamable;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {
    Streamable<Person> findByLastNameContaining(String lastname);

    Streamable<Person> findByFirstNameContaining(String firstname);
}

/*
 * Using Streamable in the service layer offers several advantages:
 * 
 * Flexibility to apply stream operations directly in service methods.
 * Easy combination of multiple Streamable results.
 * Ability to transform and map data without needing to convert to List or Set
 * right away.
 * Clean code that leverages the lazy evaluation of streams for potentially
 * large datasets.
 */

@Service
class PersonService {

    @Autowired
    private PersonRepo repo;

    // --------------Basic------------------------------
    public Streamable<Person> findByLastname(String lastname) {
        return repo.findByLastNameContaining(lastname);
    }

    // -- Using Streamable's Features in Service Methods --
    public Streamable<Person> getPeopleWithFilteredLastNames(String lastname) {
        return repo.findByLastNameContaining(lastname)
                .filter(person -> !person.getLastName().startsWith("Z")); // Exclude last names starting with "Z"
    }

    // Combining Results from Multiple Methods in a Single Streamable
    public Streamable<Person> findByFirstAndLastName(String firstname, String lastname) {
        Streamable<Person> firstNameResults = repo.findByFirstNameContaining(firstname);
        Streamable<Person> lastNameResults = repo.findByLastNameContaining(lastname);

        return firstNameResults.and(lastNameResults)
                .filter(person -> person.isActive());
    }

    // Transforming Streamable to a Different Type or Collection
    public List<String> getActiveUserEmails(String firstname) {
        return repo.findByFirstNameContaining(firstname)
                .filter(Person::isActive)
                .map(Person::getEmail)
                .toList();
    }
}
