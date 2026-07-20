package fr.diginamic;

import jakarta.persistence.*;

@Entity
@Table(name = "regions")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nom;

    public Region() {}

    public Region(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
