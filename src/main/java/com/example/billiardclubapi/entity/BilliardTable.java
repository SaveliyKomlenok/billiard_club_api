package com.example.billiardclubapi.entity;

import com.example.billiardclubapi.enumiration.NumberOfPockets;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "billiard_tables")
@Builder
public class BilliardTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 128)
    private String name;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false, length = 64)
    private String size;

    @Column(nullable = false, length = 64)
    private String sizeOfPockets;

    @Column(nullable = false, length = 64)
    private String frameMaterial;

    @Column(nullable = false, length = 64)
    private String clothMaterial;

    @Column(nullable = false)
    private String clothColor;

    @Column(nullable = false)
    private NumberOfPockets numberOfPockets;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String imagePath;

    @Column(nullable = false)
    private boolean isReserved;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private BilliardTableType billiardTableType;

    @OneToMany(mappedBy = "billiardTable", cascade = CascadeType.ALL)
    private List<SelectedTable> selectedTables;

    @OneToMany(mappedBy = "billiardTable", cascade = CascadeType.ALL)
    private List<ReservationTable> reservationTables;
}
