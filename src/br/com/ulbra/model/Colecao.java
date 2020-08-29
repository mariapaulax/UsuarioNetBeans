/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ulbra.model;

/**
 *
 * @author maria
 */
public class Colecao {
    private int id;
    private String nomeColecao;
    private String marca;
    private String fabricante;
    private int ano;
    private String volume;

    public Colecao() {
    }

    public Colecao(int id, String nomeColecao, String marca, String fabricante, int ano, String volume) {
        this.id = id;
        this.nomeColecao = nomeColecao;
        this.marca = marca;
        this.fabricante = fabricante;
        this.ano = ano;
        this.volume = volume;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeColecao() {
        return nomeColecao;
    }

    public void setNomeColecao(String nomeColecao) {
        this.nomeColecao = nomeColecao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Colecao{" + "id=" + id + ", nomeColecao=" + nomeColecao + ", marca=" + marca + ", fabricante=" + fabricante + ", ano=" + ano + ", volume=" + volume + '}';
    }
    
}
