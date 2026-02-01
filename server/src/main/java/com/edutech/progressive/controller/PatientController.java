package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.service.impl.PatientServiceImplArraylist;
import com.edutech.progressive.service.impl.PatientServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<Patient> getPatientById(@PathVariable int patientId) {
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
    public ResponseEntity<Integer> addPatient(@RequestBody Patient patient) {
        try{
            Integer id = patientService.addPatient(patient);
            return ResponseEntity.ok(id);
        }
        catch(Exception e){
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/{patientId}")
    public ResponseEntity<Void> updatePatient(@PathVariable int patientId,@RequestBody Patient patient) {
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

    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Patient>> getAllPatientFromArrayList() {
        try{
            List<Patient> patients = patientServiceArraylist.getAllPatients();
            return ResponseEntity.ok(patients);
        }
        catch(Exception e){
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/toArrayList")
    public ResponseEntity<Void> addPatientToArrayList(@RequestBody Patient patient) {
       try{
            patientServiceArraylist.addPatient(patient);
            return ResponseEntity.status(201).body(null);
        }
        catch(Exception e){
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/fromArrayList/sorted")
    public ResponseEntity<List<Patient>> getAllPatientSortedByNameFromArrayList() {
        try{
            List<Patient> patients = patientServiceArraylist.getAllPatientSortedByName();
            return ResponseEntity.ok(patients);
        }
        catch(Exception e){
            return ResponseEntity.status(500).build();
        }
    }
}