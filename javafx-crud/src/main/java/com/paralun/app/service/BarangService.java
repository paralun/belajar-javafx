package com.paralun.app.service;

import com.paralun.app.dto.BarangDto;

import java.util.List;

public interface BarangService {
    void create(BarangDto barangDto);
    void update(String id, BarangDto barangDto);
    BarangDto getBarang(String id);
    void delete(String id);
    List<BarangDto> getAll();
}
