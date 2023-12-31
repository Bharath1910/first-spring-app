package com.example.studentsdata.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Entity
@Table(name = "student")
class StudentEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;


    public StudentEntity(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

@Repository
public class Student {
    private EntityManager entityManager;
    public Student(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void save(StudentEntity entity) {
        entityManager.persist(entity);
    }

    public StudentEntity findById(int id) {
        return entityManager.find(StudentEntity.class, id);
    }

    public List<StudentEntity> fetchAll() {
        TypedQuery<StudentEntity> query = entityManager.createQuery("SELECT StudentEntity", StudentEntity.class);
        return query.getResultList();
    }
}
