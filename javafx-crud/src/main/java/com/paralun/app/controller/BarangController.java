package com.paralun.app.controller;

import com.paralun.app.dto.BarangDto;
import com.paralun.app.service.BarangService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BarangController {

    @FXML
    private TextField textKode;
    @FXML
    private TextField textNama;
    @FXML
    private TextField textKategori;
    @FXML
    private TextField textStok;
    @FXML
    private TextField textHarga;
    @FXML
    private TableView<BarangDto> tabelBarang;
    @FXML
    private TableColumn<BarangDto, Long> columnKode;
    @FXML
    private TableColumn<BarangDto, String> columnNama;
    @FXML
    private TableColumn<BarangDto, String> columnKategori;
    @FXML
    private TableColumn<BarangDto, Integer> columnStok;
    @FXML
    private TableColumn<BarangDto, BigDecimal> columnHarga;

    private ObservableList<BarangDto> data;
    private BarangService service;

    @Autowired
    public void setService(BarangService service) {
        this.service = service;
    }

    @FXML
    public void initialize() {
        columnKode.setCellValueFactory(new PropertyValueFactory<>("kode"));
        columnNama.setCellValueFactory(new PropertyValueFactory("namaBarang"));
        columnKategori.setCellValueFactory(new PropertyValueFactory("kategori"));
        columnStok.setCellValueFactory(new PropertyValueFactory("stok"));
        columnHarga.setCellValueFactory(new PropertyValueFactory("harga"));

        showData();
    }

    @FXML
    public void insert(ActionEvent event) {
        service.create(request());
        resetForm();
        showData();
    }

    @FXML
    public void update(ActionEvent event) {
    }

    @FXML
    public void delete(ActionEvent event) {
    }

    @FXML
    public void refresh(ActionEvent event) {
    }

    private void showData(){
        if(data != null){
            data.clear();
        }
        data = FXCollections.observableList(service.getAll());
        tabelBarang.setItems(data);
    }

    private BarangDto request() {
        BarangDto dto = new BarangDto();
        dto.setKode(textKode.getText());
        dto.setNamaBarang(textNama.getText());
        dto.setKategori(textKategori.getText());
        dto.setStok(Integer.parseInt(textHarga.getText()));
        dto.setHarga(new BigDecimal(textHarga.getText()));

        return dto;
    }

    private void resetForm(){
        textKode.setText("");
        textNama.setText("");
        textKategori.setText("");
        textStok.setText("");
        textHarga.setText("");
    }
}
