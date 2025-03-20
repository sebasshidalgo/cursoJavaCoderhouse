package com.CursoJavaCoderhouse.SegundaEntregaHidalgo.service;

import com.CursoJavaCoderhouse.SegundaEntregaHidalgo.repository.ColaboradoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColaboradoresService {

    @Autowired
    private ColaboradoresRepository colaboradoresRepository; // Inyección de dependencia

    public void deleteAll() {
        colaboradoresRepository.deleteAll();
    }

    public void findById(Long id) {
        colaboradoresRepository.findById(id);
    }
}
