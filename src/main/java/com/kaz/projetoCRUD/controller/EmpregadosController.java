package com.kaz.projetoCRUD.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaz.projetoCRUD.entity.Empregado;
import com.kaz.projetoCRUD.service.EmpregadosService;

@RestController
@RequestMapping("/api")
public class EmpregadosController {

    private EmpregadosService empregadosService;

    // quick and dirty: inject employee dao
    public EmpregadosController(EmpregadosService empregadosService){
        this.empregadosService = empregadosService;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/empregados")
    public List<Empregado> findAll(){
        return empregadosService.findAll();
    }

    // add mapping for GET /employees/{employeeId}

    @GetMapping("/empregados/{empregadoId}")
    public Empregado getEmpregado(@PathVariable int empregadoId){

        Empregado empregado = empregadosService.findById(empregadoId);

        if(empregado == null){
            throw new RuntimeException("Empregado não encontrado - " + empregadoId);
        }
        return empregado;
    }

    // add mapping for POST /employees - add new employee

    @PostMapping("/empregados")
    public Empregado addEmpregados(@RequestBody Empregado empregado){
        // also just in case theu pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        empregado.setId(0);

        Empregado dbEmpregado = empregadosService.save(empregado);

        return dbEmpregado;
    }

    // add mapping for PUT /employees - update existing employee
    @PutMapping("/empregados")
    public Empregado updateEmpregado(@RequestBody Empregado empregado){

        Empregado dbEmpregado = empregadosService.save(empregado);

        return dbEmpregado;
    }

    // add mapping for DELETE /employees/{employeeId} - delete employee
    @DeleteMapping("/empregados/{empregadoId}")
    public String deleteEmpregado(@PathVariable int empregadoId){

        Empregado tempEmpregado = empregadosService.findById(empregadoId);

        // throw exception if null

        if(tempEmpregado == null){
            throw new RuntimeException("Empregado não encontrado - "+empregadoId);
        }

        empregadosService.deleteById(empregadoId);

        return "Empregado deletado - " + empregadoId;
    }
}
