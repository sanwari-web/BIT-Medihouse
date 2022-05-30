package com.bit.mediHouse.Services;

import com.bit.mediHouse.Models.Session;
import com.bit.mediHouse.Repository.SessionRepository;
import com.bit.mediHouse.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    @Autowired
    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public Session addSession(Session session) {
        return sessionRepository.save(session);
    }

    public List<Session> findAllSession() {
        return sessionRepository.findAll();
    }

    public Session updateSession(Session session) {
        return sessionRepository.save(session);
    }

    public List<Session> findSessionsByPatientEmail(String email) {
        return sessionRepository.findSessionsByPatientEmail(email);
    }

    public List<Session> findSessionsByUser_Email(String email) {
        return sessionRepository.findSessionsByUser_Email(email);
    }

    public Session findSessionBydiagnosis(String diagnosis) {
        return sessionRepository.findSessionBydiagnosis(diagnosis).orElseThrow(() -> new UserNotFoundException("User by diagnosis " + diagnosis + " was not found"));
    }


    public List<Object[]> findSessionsByDiagnosisAndUser_Distric(String diagnosis) {
       return sessionRepository.findSessionsByDiagnosisFeverAndUse_District(diagnosis);
    }
    public List<Object[]> findSessionsByDiagnosisAndUser_Gender(String diagnosis,String gender) {
        return sessionRepository.findSessionsByDiagnosisAndUser_Gender(diagnosis,gender);
    }


//    public List<Session> findSessionsByDate_Year(Date date) {
//        return sessionRepository.findSessionsByDate_Year(date);
//    }
//    public void deletePatient(Integer id){
//        patientRepository.deletePatientById(id);Z
//    }

}
