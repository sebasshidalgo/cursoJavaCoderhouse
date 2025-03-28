package com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.mapper;

import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.AddressCreateDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.dto.AddressResponseDTO;
import com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
// Convertir de DTO a entidad
    public static Address toEntity(AddressCreateDTO dto) {
        return Address.builder()
                .street(dto.getStreet())
                .number(dto.getNumber())
                .apartment(dto.getApartment())
                .city(dto.getCity())
                .state(dto.getState())
                .country(dto.getCountry())
                .zipCode(dto.getZipCode())
                .build();
    }
    // Convertir de entidad a DTO
    public static AddressResponseDTO toResponseDTO(Address address) {
        if (address == null) {
            return null;
        }
        return AddressResponseDTO.builder()
                .id(address.getId())
                .street(address.getStreet())
                .number(address.getNumber())
                .apartment(address.getApartment())
                .city(address.getCity())
                .state(address.getState())
                .country(address.getCountry())
                .zipCode(address.getZipCode())
                .build();
    }
}
