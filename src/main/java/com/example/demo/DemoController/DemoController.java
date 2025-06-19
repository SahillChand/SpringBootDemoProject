package com.example.demo.DemoController;

import com.example.demo.Dao.Student;
import com.example.demo.Dao.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    @Autowired
    private StudentRepo stRepo;

    @GetMapping("/base")
    public String sayHello(){
        return "Hello";
    }

    @GetMapping("/getStudent/{id}")
    public Student getStudent(@PathVariable int id){
        return stRepo.getStudent(id);
    }

    @PostMapping("/add")
    public int add(@RequestBody Student student){
        return stRepo.add(student);
    }

    @PutMapping("/update/{id}")
    public int update(@RequestBody Student student,@PathVariable int id){
        return stRepo.update(student,id);
    }

    @PatchMapping("/modify/{id}")
    public int modify(@RequestBody Student student,@PathVariable int id){
        return stRepo.modify(student,id);
    }
}
