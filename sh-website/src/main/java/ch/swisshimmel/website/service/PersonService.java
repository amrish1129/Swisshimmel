package ch.swisshimmel.website.service;

import java.util.List;

import ch.swisshimmel.website.persist.entity.Person;

 
public interface PersonService {
 
    public void addPerson(Person p);
    public void updatePerson(Person p);
    public List<Person> listPersons();
    public Person getPersonById(int id);
    public void removePerson(int id);
     
}