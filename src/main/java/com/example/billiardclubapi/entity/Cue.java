package com.example.billiardclubapi.entity;

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

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cues")
@Builder
public class Cue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 128)
    private String name;

    @Column(nullable = false, precision = 32, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private String tipType;

    @Column(nullable = false)
    private Integer amountOfParts;

    @Column(nullable = false, length = 64)
    private String material;

    @Column(nullable = false)
    private Integer diameter;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal weight;

    @Column(nullable = false)
    private BigDecimal length;

    @Column(nullable = false)
    private String category;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private CueType cueType;

    @OneToMany(mappedBy = "cue", cascade = CascadeType.ALL)
    private List<SelectedCue> selectedCues;

    @OneToMany(mappedBy = "cue", cascade = CascadeType.ALL)
    private List<ReservationCue> reservationCues;
}