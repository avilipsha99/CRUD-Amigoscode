package com.amigoscode;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerReposistory softwareEngineerReposistory;

    public SoftwareEngineerService(SoftwareEngineerReposistory softwareEngineerReposistory){
        this.softwareEngineerReposistory = softwareEngineerReposistory;
    }
    public List<SoftwareEngineer> getSoftwareEngineers(){
        return softwareEngineerReposistory.findAll();
    }
}
