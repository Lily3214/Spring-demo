package com.yearup.dao.interfaces;

import com.yearup.model.Student;

public interface IRegistrationDAO {
    public Long persistStudent(Student student);
    public Student findById(Long id);
}
