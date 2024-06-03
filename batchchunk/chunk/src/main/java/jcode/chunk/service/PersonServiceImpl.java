package jcode.chunk.service;


import jcode.chunk.entities.Person;
import jcode.chunk.persistence.IPersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private IPersonDAO personDAO;

    @Override
    public Iterable<Person> saveAll(List<Person> personList) {
        return personDAO.saveAll(personList);
    }
}
