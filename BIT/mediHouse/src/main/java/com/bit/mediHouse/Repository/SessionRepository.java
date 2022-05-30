package com.bit.mediHouse.Repository;

import com.bit.mediHouse.Models.Patient;
import com.bit.mediHouse.Models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface SessionRepository  extends JpaRepository<Session,Integer> {

    Session getById(Integer session_id);

    public Optional<Session> findSessionBydiagnosis(String diagnosis);

    @Query("SELECT count (s.session_id) as count, u.gender as gender,s.diagnosis as diagnosis from Session  s inner join user u on s.patient.id = u.id where gender=?1 group by u.gender,s.diagnosis order by s.diagnosis")
    public List<Map<String, Object>> getSesionCount(String gender);


    @Query("SELECT count (s.session_id)as usercount, u.district as district from Session  s inner join user u on s.patient.id = u.id where s.diagnosis=?1 group by u.district,s.diagnosis")
    public List<Object[]> findSessionsByDiagnosisFeverAndUse_District(String diagnosis);

    List<Session> findSessionsByPatientEmail(String email);
    List<Session> findSessionsByUser_Email(String email);

    List<Object[]> findSessionsByDiagnosisAndUser_Gender(String diagnosis, String gender);


}