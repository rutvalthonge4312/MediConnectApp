package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Patient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientServiceImplJpa patientService ;

    @Autowired
    private PatientServiceImplArraylist patientServiceArraylist;   
    
    @GetMapping("")
    public ResponseEntity<List<Patient>> getAllPatients() {
        try{
            List<Patient> patients = patientService.getAllPatients();
            return ResponseEntity.ok(patients);
        }
        catch(Exception e){
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<Patient> getPatientById(int patientId) {
        try{
            Patient patient = patientService.getPatientById(patientId);
            if (patient != null) {
                return ResponseEntity.ok(patient);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        catch(Exception e){
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("")
    public ResponseEntity<Integer> addPatient(Patient patient) {
        try{
            Integer id = patientService.addPatient(patient);
            return ResponseEntity.ok(id);
        }
        catch(Exception e){
            return ResponseEntity.status(500).build();
        }
    }

    @ PutMapping("/{patientId}")
    public ResponseEntity<Void> updatePatient(int patientId, Patient patient) {
        try{
            patientService.updatePatient(patientId, patient);
            return ResponseEntity.ok().build();
        }
        catch(Exception e){
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<Void> deletePatient(int patientId) {
        try{
            patientService.deletePatient(patientId);
            return ResponseEntity.ok().build();
        }
        catch(Exception e){
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/toArraylist")
    public ResponseEntity<List<Patient>> getAllPatientFromArrayList() {
        try{
            List<Patient> patients = patientServiceArraylist.getAllPatients();
            return ResponseEntity.ok(patients);
        }
        catch(Exception e){
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/toArraylist")
    public ResponseEntity<Void> addPatientToArrayList() {
       try{
            patientServiceArraylist.addPatientToArrayList();
            return ResponseEntity.ok().build();
        }
        catch(Exception e){
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/fromArraylist/sorted")
    public ResponseEntity<List<Patient>> getAllPatientSortedByNameFromArrayList() {
        try{
            List<Patient> patients = patientServiceArraylist.getAllPatientSortedByNameFromArrayList();
            return ResponseEntity.ok(patients);
        }
        catch(Exception e){
            return ResponseEntity.status(500).build();
        }
    }
}