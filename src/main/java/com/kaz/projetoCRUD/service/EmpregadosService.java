package com.kaz.projetoCRUD.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kaz.projetoCRUD.entity.Empregado;
import com.kaz.projetoCRUD.persistence.EmpregadosDAO;

@Service
public class EmpregadosService implements IEmpregadosService{

    private EmpregadosDAO empregadosDAO;
        
    EmpregadosService(EmpregadosDAO empregadosDAO){
        this.empregadosDAO = empregadosDAO;
    }
    
    @Override
    public List<Empregado> findAll() {
        return empregadosDAO.findAll();
    }

    @Override
    public Empregado findById(int id) {
        Optional<Empregado> result = empregadosDAO.findById(id);
        Empregado empregado = null;

        if(result.isPresent()){
            empregado = result.get();
        }else{
            throw new RuntimeException("Empregado não encontrado - "+id);
        }

        return empregado;
    }

    @Override
    public Empregado save(Empregado empregado) {
        return empregadosDAO.save(empregado);
    }

    @Override
    public void deleteById(int id) {
        empregadosDAO.deleteById(id);
    }

}
