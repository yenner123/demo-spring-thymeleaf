package com.example.demo.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.example.demo.domain.Aspirante;
import com.example.demo.domain.Municipio;
import com.example.demo.dto.AspiranteDTO;

public class AspiranteMapper {

    public static Aspirante toEntity(AspiranteDTO dto) {
        if (dto == null) {
            return null;
        }

        Aspirante entity = new Aspirante();
        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }
        entity.setTipoDocumento(dto.getTipoDocumento());
        entity.setDocumento(dto.getDocumento());
        entity.setNombres(dto.getNombres());
        entity.setApellidos(dto.getApellidos());
        entity.setFechaNacimiento(LocalDate.parse(dto.getFechaNacimiento()));
        entity.setCargo(dto.getCargo());

        Municipio municipio = new Municipio();
        municipio.setId(dto.getMunicipioId());
        entity.setMunicipio(municipio);

        return entity;
    }

    public static AspiranteDTO toDTO(Aspirante entity) {
        AspiranteDTO dto = new AspiranteDTO();
        dto.setId(entity.getId());
        dto.setTipoDocumento(entity.getTipoDocumento());
        dto.setDocumento(entity.getDocumento());
        dto.setNombres(entity.getNombres());
        dto.setApellidos(entity.getApellidos());
        dto.setFechaNacimiento(entity.getFechaNacimiento().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        dto.setMunicipioId(entity.getMunicipio().getId());
        dto.setCargo(entity.getCargo());
        return dto;
    }
}
