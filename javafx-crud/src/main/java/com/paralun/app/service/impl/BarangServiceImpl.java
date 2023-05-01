package com.paralun.app.service.impl;

import com.paralun.app.dto.BarangDto;
import com.paralun.app.model.Barang;
import com.paralun.app.repository.BarangRepository;
import com.paralun.app.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BarangServiceImpl implements BarangService {

    private BarangRepository repository;

    @Autowired
    public BarangServiceImpl(BarangRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(BarangDto barangDto) {
        Barang barang = new Barang();
        barang.setKode(barangDto.getKode());
        barang.setNamaBarang(barangDto.getNamaBarang());
        barang.setKategori(barangDto.getKategori());
        barang.setStok(barangDto.getStok());
        barang.setHarga(barangDto.getHarga());

        repository.save(barang);
    }

    @Override
    public void update(String id, BarangDto barangDto) {

    }

    @Override
    public BarangDto getBarang(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<BarangDto> getAll() {
        List<Barang> all = repository.findAll();
        return all.stream().map(this::convertToObject).collect(Collectors.toList());
    }

    private BarangDto convertToObject(Barang barang) {
        BarangDto dto = new BarangDto();
        dto.setKode(barang.getKode());
        dto.setNamaBarang(barang.getNamaBarang());
        dto.setKategori(barang.getKategori());
        dto.setStok(barang.getStok());
        dto.setHarga(barang.getHarga());

        return dto;
    }
}
