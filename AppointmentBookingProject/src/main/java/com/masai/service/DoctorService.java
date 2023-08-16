package com.masai.service;

import java.util.List;

import com.masai.model.Doctor;

public interface DoctorService {

	Doctor registerDoctor(Doctor doctor);
	Doctor updateDoctor(Integer id, Doctor doctor);
	String deleteDoctor(Integer id);
	List<Doctor> getAllDoctors();
}
