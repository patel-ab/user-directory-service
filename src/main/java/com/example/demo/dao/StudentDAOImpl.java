package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

	private EntityManager entityManager;

	@Override
	@Transactional
	public void save(Student student) {
		entityManager.persist(student);

	}

	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Student findById(Integer id) {
		return this.entityManager.find(Student.class, id);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Student student = entityManager.find(Student.class, id);
		entityManager.remove(student);

	}

}
