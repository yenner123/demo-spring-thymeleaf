package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.domain.Aspirante;
import com.example.demo.dto.AspiranteDTO;
import com.example.demo.repository.AspiranteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.AspiranteMapper;

@Service
@Transactional
public class AspiranteService {

    @Autowired
    private AspiranteRepository repo;

    public List<Aspirante> listAll() {
        return repo.findAll();
    }

    public void save(AspiranteDTO aspiranteDTO) {
        Aspirante aspirante = AspiranteMapper.toEntity(aspiranteDTO);        
        repo.save(aspirante);
    }

    public AspiranteDTO get(long id) {
        Aspirante entity = repo.findById(id).get();        
        return AspiranteMapper.toDTO(entity);
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
