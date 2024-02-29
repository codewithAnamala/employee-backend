package com.EmployeeManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EmployeeManagement.model.Attendance;
import com.EmployeeManagement.model.Leave;



@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long>{

	List<Attendance> findByEmailId(String emailId);

	Attendance findByattendanceId(Long attendanceId);

}
