package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.example.demo.domain.Municipio;
import com.example.demo.dto.SelectorDTO;
import com.example.demo.repository.MunicipioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MunicipioService {

    @Autowired
    private MunicipioRepository repo;

    public List<Municipio> listAll() {
        return repo.findAll();
    }

    public List<SelectorDTO> listAllAsSelectorDTO() {
        return repo.findAll().stream().map(e -> new SelectorDTO(e.getId(), e.getNombre())).collect(Collectors.toList());
    }

    public Municipio get(long id) {
        return repo.findById(id).get();
    }
}
