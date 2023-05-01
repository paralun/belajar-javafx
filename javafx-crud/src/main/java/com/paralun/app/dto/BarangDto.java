package com.paralun.app.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BarangDto {
    private String kode;
    private String namaBarang;
    private String kategori;
    private Integer stok;
    private BigDecimal harga;
}
