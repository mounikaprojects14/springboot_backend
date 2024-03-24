package com.hms.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.hms.model.AppointmentsModel;
import com.hms.pojo.AppointmentsSignUpRequest;
import com.hms.pojo.AppointmentsSignUpResponse;
import com.hms.repository.AppointmentsRepository;

@Service
public class AppointmentsDaoImpl {

	@Autowired
	private AppointmentsRepository appointmentsRepository;

	public AppointmentsSignUpResponse appointmentsSignUp(AppointmentsSignUpRequest request) {
		AppointmentsModel model = new AppointmentsModel();
//		model.setDoctorId(request.getDoctorId()); //FK
//		model.setPatientId(request.getPatientId()); //FK
		model.setAppointmentDate(request.getAppointmentDate());
		model.setSchedule(request.getSchedule());


		AppointmentsModel response = appointmentsRepository.save(model);
		if (response != null) {
			AppointmentsSignUpResponse appointmentsSignUpResponse = new AppointmentsSignUpResponse();
			appointmentsSignUpResponse.setMessage("SignUp Successfull");
//			appointmentsSignUpResponse.setDoctorId(response.getDoctorId()); //FK
//			appointmentsSignUpResponse.setPatientId(response.getPatientId()); //FK
			appointmentsSignUpResponse.setAppointmentDate(response.getAppointmentDate());
			appointmentsSignUpResponse.setSchedule(response.getSchedule());

			return appointmentsSignUpResponse;
		}


		return null;
	}


}
