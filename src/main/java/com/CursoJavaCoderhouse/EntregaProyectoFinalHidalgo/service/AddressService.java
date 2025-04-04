package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.service;

import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.AddressCreateDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.AddressResponseDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.mapper.AddressMapper;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.model.Address;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.repository.AddressRepository;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.model.Vendor;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.repository.VendorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class AddressService {
    private static final Logger logger = LoggerFactory.getLogger(AddressService.class);

    @Autowired
    private AddressRepository addressRepository; // Inyección de dependencia
    @Autowired
    private VendorRepository vendorRepository; // Inyección de dependencia

    // Crear una nueva dirección
    @Transactional
    public AddressResponseDTO createAddress(AddressCreateDTO addressDTO, UUID vendorId) {
        // Buscar el vendor asociado
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new EntityNotFoundException("⚠️ El proveedor con ID " + vendorId + " no existe."));

        // Convierte el DTO a entidad
        Address address = AddressMapper.toEntity(addressDTO);

        // Asocia el vendor a la dirección
        address.setVendor(vendor);
        logger.info("✅ Dirección asociada al proveedor: {}", vendor.getBrandName()); // Log de información

        // Guardar la dirección en la base de datos
        Address savedAddress = addressRepository.save(address);
        logger.info("✅ Dirección creada con ID: {} en proveedor {}", savedAddress.getId(), vendor.getBrandName()); // Log de información

        // Asignar la dirección al vendor y actualizarlo
        vendor.setAddress(savedAddress);
        vendorRepository.save(vendor);

        return AddressMapper.toResponseDTO(savedAddress); // Convierte la entidad a DTO y lo devuelve
    }

    // Obtener el listado de direcciones
    public List<AddressResponseDTO> getAllAddresses() {
        List<Address> addresses = addressRepository.findAll();

        if (addresses.isEmpty()) {
            logger.warn("⚠️ No se encontraron direcciones en la base de datos."); // Log de advertencia
        } else {
            logger.info("✅ Se han encontrado {} direcciones en la base de datos.", addresses.size()); // Log de información
        }

        return addresses.stream().map(AddressMapper::toResponseDTO).toList(); // Convierte cada entidad a DTO
    }

    // Obtener una dirección por su ID
    public AddressResponseDTO getAddressById(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("⚠️ La dirección con ID " + id + " no existe."));
        logger.info("✅ Dirección encontrada con ID: {}", id); // Log de información
        return AddressMapper.toResponseDTO(address); // Convierte la entidad a DTO
    }

    // Actualizar una dirección por su ID
    @Transactional
    public AddressResponseDTO updateAddress(Long id, AddressCreateDTO addressDTO) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("⚠️ La dirección con ID " + id + " no existe."));
        // Actualiza los campos de la dirección
        address.setStreet(addressDTO.getStreet());
        address.setNumber(addressDTO.getNumber());
        address.setApartment(addressDTO.getApartment());
        address.setCity(addressDTO.getCity());
        address.setState(addressDTO.getState());
        address.setCountry(addressDTO.getCountry());
        address.setZipCode(addressDTO.getZipCode());

        Address updatedAddress = addressRepository.save(address);
        logger.info("✅ Dirección actualizada con ID: {}", updatedAddress.getId()); // Log de información
        return AddressMapper.toResponseDTO(updatedAddress); // Convierte la entidad a DTO y lo devuelve
    }

    // Eliminar una dirección por su ID
    @Transactional
    public void deleteAddressById(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("⚠️ La dirección con ID " + id + " no existe."));
        addressRepository.delete(address);
        logger.info("✅ Dirección eliminada con ID: {}", id); // Log de información
    }

    // Eliminar todas las direcciones
    public void deleteAllAddresses() {
        addressRepository.deleteAll();
        logger.info("✅ Todas las direcciones han sido eliminadas correctamente"); // Log de información
    }
}
