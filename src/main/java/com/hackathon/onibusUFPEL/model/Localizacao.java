/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hackathon.onibusUFPEL.model;

import javax.persistence.Embeddable;

/**
 *
 * @author aluno
 */
@Embeddable
public class Localizacao {

    private Long x;

    private Long y;

    private Long precisao;

    public Long getX() {
        return x;
    }

    public void setX(Long x) {
        this.x = x;
    }

    public Long getY() {
        return y;
    }

    public void setY(Long y) {
        this.y = y;
    }

    public Long getPrecisao() {
        return precisao;
    }

    public void setPrecisao(Long precisao) {
        this.precisao = precisao;
    }

}
