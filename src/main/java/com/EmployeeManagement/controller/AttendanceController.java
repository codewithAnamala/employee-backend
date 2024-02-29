package com.EmployeeManagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeManagement.exception.ResourceNotFoundException;
import com.EmployeeManagement.model.Attendance;
import com.EmployeeManagement.model.Certification;
import com.EmployeeManagement.model.Leave;
import com.EmployeeManagement.model.Status;
import com.EmployeeManagement.repository.AttendanceRepository;
import com.EmployeeManagement.repository.CertificationRepository;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("api/v1/")
public class AttendanceController {
	@Autowired
	  private AttendanceRepository attendanceRepository;

	//get all attendance details
	  @GetMapping("/attendance")
		public List<Attendance>getAllCertification(){
			return attendanceRepository.findAll();
		}
		
	  //create attendance
	  @PostMapping("/attendance")	
      public Attendance createAttendance(@RequestBody Attendance attendance) {
     	 return attendanceRepository.save(attendance);
      }
		
	  //get attendance details by emailId
		@GetMapping("/attendance/emailId/{emailId}")
		public ResponseEntity<?> getAttendanceDetailsByEmailId(@PathVariable String emailId){
			List<Attendance> attendanceObj;
			attendanceObj = attendanceRepository.findByEmailId(emailId);
			return ResponseEntity.ok(attendanceObj);
		}

		//delete leave rest api
		@DeleteMapping("/attendance/{attendanceId}")
		public ResponseEntity<Map<String,Boolean>> deleteAttendance(@PathVariable Long attendanceId){
			Attendance attendance=attendanceRepository.findByattendanceId(attendanceId);
			attendanceRepository.delete(attendance);
			Map<String,Boolean>response=new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		
		@GetMapping("/attendance/{id}")
		public ResponseEntity<Attendance>getAttendanceById(@PathVariable Long id){
			Attendance attendance =attendanceRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Attendance not exist with id :" +id));
			return ResponseEntity.ok(attendance);
		}
}
