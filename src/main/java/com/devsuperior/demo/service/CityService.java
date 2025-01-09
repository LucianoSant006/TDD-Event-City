package com.devsuperior.demo.service;

import com.devsuperior.demo.dto.CityDTO;
import com.devsuperior.demo.entities.City;
import com.devsuperior.demo.repositories.CityRepository;
import com.devsuperior.demo.service.exceptions.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Transactional(readOnly = true)
    public List<CityDTO> findAll() {
        List<City> list = cityRepository.findAll(Sort.by("name"));
        return list.stream().map(CityDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public CityDTO insert(CityDTO dto) {
        City entity = new City();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        cityRepository.save(entity);

        return new CityDTO(entity);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void  delete(Long id) {

        if (!cityRepository.existsById(id)) {
            throw new ResourceNotFound("id Not Fund");
        }
        try {
            cityRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Error deleting city with ID " + id, e);
        }
    }
}
