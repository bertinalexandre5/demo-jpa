package fr.diginamic;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Emprunt {

    @Id
    private int id;

    @Column(name="DATE_DEBUT")
    private String dateDebut;

    @Column(name="DATE_FIN")
    private String dateFin;

    private int delai;

    @ManyToMany
    @JoinTable(name="COMPO",
            joinColumns = @JoinColumn(name="ID_EMP", referencedColumnName="ID"),
            inverseJoinColumns = @JoinColumn(name="ID_LIV", referencedColumnName="ID")
    )
    private Set<Livre> livres;


@ManyToOne
    @JoinColumn(name="ID_CLIENT")
    private Client client;
    public Emprunt() {}

    public Emprunt(int id, int delai, String dateDebut, String dateFin) {
        this.id = id;
        this.delai = delai;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Set<Livre> getLivres() {
        return livres;
    }

    public int getId() {
        return id;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public int getDelai() {
        return delai;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }

    public Client getClient() {
        return client;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", dateDebut='" + dateDebut + '\'' +
                ", dateFin='" + dateFin + '\'' +
                ", delai=" + delai +
                '}';
    }
}
