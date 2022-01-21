package com.example.persona.Dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class AppoimentDto implements Serializable {
    private final String appoimentreason;
    private final int appoimentroom;
    private final int clientid;
    private final int date;
}
