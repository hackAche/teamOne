/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hackathon.onibusUFPEL.model;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

/**
 *
 * @author aluno
 */
@Embeddable
public class Localizacao {

    private BigDecimal x;

    private BigDecimal y;

    private Long precisao;

    public Localizacao() {
    }

    public Localizacao(BigDecimal x, BigDecimal y) {
        this.x = x;
        this.y = y;
    }

    public BigDecimal getX() {
        return x;
    }

    public void setX(BigDecimal x) {
        this.x = x;
    }

    public BigDecimal getY() {
        return y;
    }

    public void setY(BigDecimal y) {
        this.y = y;
    }

    public Long getPrecisao() {
        return precisao;
    }

    public void setPrecisao(Long precisao) {
        this.precisao = precisao;
    }

    @Override
    public String toString() {
        return "Latitude: " + x + "Longitude: " + y;
    }
    
}
