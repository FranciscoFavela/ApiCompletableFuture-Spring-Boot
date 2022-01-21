package com.example.persona.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "appoiment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Appoiment extends Base {

    @Column(name = "appoimentreason")
    private String appoimentreason;

    @Column(name = "appoimentroom")
    private int appoimentroom;

    @Column(name = "clientid")
    private int clientid;

    @Column(name = "date")
    private int date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_client")
    private Client client;

}
