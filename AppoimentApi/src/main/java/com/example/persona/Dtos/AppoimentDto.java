package com.example.persona.Dtos;

import lombok.*;

import java.io.Serializable;



@Getter
@Setter
public class AppoimentDto implements Serializable {
    private  String appoimentreason;
    private  int appoimentroom;
    private  int clientid;
    private  int date;

    public AppoimentDto(String appoimentreason, int appoimentroom, int clientid, int date) {
        this.appoimentreason = appoimentreason;
        this.appoimentroom = appoimentroom;
        this.clientid = clientid;
        this.date = date;
    }
    public AppoimentDto() {
    }
}
