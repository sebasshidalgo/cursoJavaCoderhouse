package com.CursoJavaCoderhouse.SegundaEntregaHidalgo.service;

import com.CursoJavaCoderhouse.SegundaEntregaHidalgo.model.Domicilio;
import com.CursoJavaCoderhouse.SegundaEntregaHidalgo.repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService {

    @Autowired
    private DomicilioRepository domicilioRepository; // Inyección de dependencia

    public Domicilio save(Domicilio domicilio) {
        // Verificar si ya existe un domicilio con la misma combinación de calle + numero + pisoDepto
        Optional<Domicilio> existingDomicilio = domicilioRepository.findByCalleAndNumeroAndPisoDepto(
                domicilio.getCalle(),
                domicilio.getNumero(),
                domicilio.getPisoDepto()
        );

        if (existingDomicilio.isPresent()) {
            System.out.println("❌ Domicilio ya existe: " + domicilio.getCalle() + " " + domicilio.getNumero() + " " + domicilio.getPisoDepto());
            return existingDomicilio.get();
        }

        return domicilioRepository.save(domicilio);
    }

    public Optional<Domicilio> findById(Long id) {
        return domicilioRepository.findById(id);
    }

    public void deleteAll() {
        domicilioRepository.deleteAll();
    }

    public Domicilio update(Long id, Domicilio domicilio) {
        Optional<Domicilio> existingDomicilio = domicilioRepository.findById(id);

        if (existingDomicilio.isPresent()) {
            Domicilio domicilioToUpdate = existingDomicilio.get();
            domicilioToUpdate.setCalle(domicilio.getCalle());
            domicilioToUpdate.setNumero(domicilio.getNumero());
            domicilioToUpdate.setPisoDepto(domicilio.getPisoDepto());
            domicilioToUpdate.setCiudad(domicilio.getCiudad());
            domicilioToUpdate.setCodigoPostal(domicilio.getCodigoPostal());
            domicilioToUpdate.setVendor(domicilio.getVendor());

            return domicilioRepository.save(domicilioToUpdate);
        } else {
            return null;
        }
    }

    public List<Domicilio> findAll() {
        return domicilioRepository.findAll();
    }
}
