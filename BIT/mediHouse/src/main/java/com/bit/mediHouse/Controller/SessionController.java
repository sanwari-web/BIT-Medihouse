package com.bit.mediHouse.Controller;

import com.bit.mediHouse.Models.Session;
import com.bit.mediHouse.Models.User;
import com.bit.mediHouse.Services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    public SessionController(SessionService sessionService){
        this.sessionService = sessionService;
    }

    @GetMapping("/session/find")
    public ResponseEntity<List<Session>> getAllSession() {
        List<Session> session = sessionService.findAllSession();
        return new ResponseEntity <>(session, HttpStatus.OK);
    }

    @GetMapping("/session/find/diagnosis/{diagnosis}")
    public ResponseEntity <Session> findSessionBydiagnosis(@PathVariable("diagnosis") String diagnosis){
        Session session = sessionService.findSessionBydiagnosis(diagnosis);
        return new ResponseEntity <>( session, HttpStatus.OK);
    }
    @GetMapping("/session/find/diagnosisgender/{diagnosis}/{gender}")
    public ResponseEntity<List<Object[]>> findSessionsByDiagnosisAndUser_Gender(@PathVariable("diagnosis") String diagnosis,@PathVariable("gender") String gender) {
        List<Object[]> session = sessionService.findSessionsByDiagnosisAndUser_Gender(diagnosis,gender);
        return new ResponseEntity <>(session, HttpStatus.OK);
    }

    @GetMapping("/session/find/user/patient/{email}")
    public ResponseEntity<List<Session>> findSessionsByPatientEmail(@PathVariable("email")String email) {
        List<Session> session = sessionService.findSessionsByPatientEmail(email);
        return new ResponseEntity <>(session, HttpStatus.OK);
    }
    @GetMapping("/session/find/user/{email}")
    public ResponseEntity<List<Session>> findSessionsByUser_Email(@PathVariable("email")String email) {
        List<Session> session = sessionService.findSessionsByUser_Email(email);
        return new ResponseEntity <>(session, HttpStatus.OK);
    }


    @GetMapping("/session/find/diagnosisdistrict/{diagnosis}")
    public ResponseEntity<List<Object[]>> findSessionsByDiagnosisAndUser_Distric(@PathVariable("diagnosis") String diagnosis) {
        List<Object[]> session = sessionService.findSessionsByDiagnosisAndUser_Distric(diagnosis);
        return new ResponseEntity <>(session, HttpStatus.OK);
    }


    @PostMapping("/session/add")
    public ResponseEntity <Session> addSession(@RequestBody Session session){
        Session newSession = sessionService.addSession(session);
        return new ResponseEntity <>(newSession, HttpStatus.CREATED);
    }

    @PostMapping("/session/update")
    public ResponseEntity <Session> updateSession(@RequestBody Session session){
        Session updateSession = sessionService.updateSession (session);
        return new ResponseEntity <>(updateSession, HttpStatus.CREATED);
    }

//    @Transactional
//    @DeleteMapping("/user/delete/{id}")
//    public ResponseEntity <?> deleteUser(@PathVariable("id") Integer id){
//        userService.deleteUser(id);
//        return new ResponseEntity <>(HttpStatus.OK);
//    }
}
