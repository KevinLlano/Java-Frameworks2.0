package com.example.demo.service;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;

import java.util.List;

/**
 *
 *
 *
 *
 */
public interface PartService {
    public List<Part> findAll();

    void update(Part part);

    public Part findById(int theId);
    public void save (Part thePart);
    public void deleteById(int theId);

    public List<Part> listAll(String keyword);

}
