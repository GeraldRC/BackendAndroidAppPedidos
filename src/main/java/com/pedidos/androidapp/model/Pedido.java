package com.pedidos.androidapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "num_ped")
    @NotEmpty
    private Integer numPed;

    @Column(name = "can_art")
    @NotEmpty
    private Integer canArt;

    @Column(name = "cant_art_ent")
    @NotEmpty
    private Integer cantArtEnt;

    @Column(name = "detail")
    private String detail;

    @Column(name = "date")
    @NotEmpty
    private String date;

    @OneToMany(mappedBy = "pedido",cascade = { CascadeType.ALL }, orphanRemoval = true)
    private List<Images> images;

    @ManyToOne
    @JoinColumn(name = "user", foreignKey = @ForeignKey(name = "FK_PEDIDO_USER"))
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumPed() {
        return numPed;
    }

    public void setNumPed(Integer numPed) {
        this.numPed = numPed;
    }

    public Integer getCanArt() {
        return canArt;
    }

    public void setCanArt(Integer canArt) {
        this.canArt = canArt;
    }

    public Integer getCantArtEnt() {
        return cantArtEnt;
    }

    public void setCantArtEnt(Integer cantArtEnt) {
        this.cantArtEnt = cantArtEnt;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
