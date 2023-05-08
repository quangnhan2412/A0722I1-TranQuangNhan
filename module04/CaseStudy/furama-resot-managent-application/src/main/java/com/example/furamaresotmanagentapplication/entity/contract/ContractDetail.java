package com.example.furamaresotmanagentapplication.entity.contract;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "contract_detail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractDetail {
    @Id
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "id")
    private Contract contracts;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name="attach_facility_id",referencedColumnName = "id")
    private AttachFacility attachFacility;
}
