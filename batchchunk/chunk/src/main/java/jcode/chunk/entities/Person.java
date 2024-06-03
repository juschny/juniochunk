package jcode.chunk.entities;


import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "persons")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "last_name")
    private String lastName;
    private Integer age;
    private String createAt;

    private static final long serialVersionUID = -3670843597762726141L;
}