package jcode.chunk.steps;

import jcode.chunk.entities.Person;
import jcode.chunk.service.IPersonService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
@Slf4j
public class PersonItemWriter implements ItemWriter<Person> {



           @Autowired
    private IPersonService personService;





    @Override
    public void write(List<? extends Person> list) throws Exception {
         List<Person> personList = new ArrayList<Person>();
        for (Person person : list) {
            personList.add(person);
        }
        personService.saveAll(personList);
    }
}

