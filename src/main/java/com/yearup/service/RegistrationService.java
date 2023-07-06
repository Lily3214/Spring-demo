package com.yearup.service;

import com.yearup.dao.interfaces.IRegistrationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yearup.model.Student;
@Component
public class RegistrationService {
    private final IRegistrationDAO registrationDAO;
    // Autowired tells Spring to automatically inject a
    // object into this constructor when a RegistrationService
    // is created, more on this later
// When there’s only one constructor with args, @autowired
// is optional
    @Autowired
    public RegistrationService(IRegistrationDAO registrationDAO) {
        this.registrationDAO = registrationDAO;
    }
    public Long registerStudent(Student student) throws
            StudentAlreadyRegisteredException {
        if (this.registrationDAO.findById(student.getId())
                != null) {
            throw new StudentAlreadyRegisteredException();
        }
        return registrationDAO.persistStudent(student);
    }
}
