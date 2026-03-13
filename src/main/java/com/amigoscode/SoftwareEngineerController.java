package com.amigoscode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {
    @GetMapping
    public List<SoftwareEngineer> getSoftwareEngineers(){
        return List.of(
                new SoftwareEngineer(1,"John","JS, node, React, Python"),
                new SoftwareEngineer(2,"mike","python, django, pyspark")
        );
    }
}
