package jcode.chunk.service;

import jcode.chunk.entities.Person;

import java.util.List;

public interface IPersonService {

    Iterable<Person> saveAll(List<Person> personList);
}