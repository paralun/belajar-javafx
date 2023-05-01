package com.paralun.app.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "t_barang")
public class Barang {

    @Id
    private String kode;

    @Column(name = "nama_barang")
    private String namaBarang;

    @Column(name = "kategori")
    private String kategori;

    @Column(name = "stok")
    private Integer stok;

    @Column(name = "harga")
    private BigDecimal harga;
}
