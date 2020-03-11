package com.greenproject.model;

import javax.persistence.*;

@Entity
@Table(name = "holiday_check", schema = "greenfield")
public class HolidayCheck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String Link;
    @Column(columnDefinition = "TEXT")
    private String Name;
    @Column(columnDefinition = "TEXT")
    private String Adresse;
    @Column(columnDefinition = "TEXT")
    private String Mail;
    @Column(columnDefinition = "TEXT")
    private String Telefon;
    @Column(columnDefinition = "TEXT")
    private String Stadt;
    @Column(columnDefinition = "TEXT")
    private String Region;
    @Column(columnDefinition = "TEXT")
    private String Land;
    @Column(columnDefinition = "TEXT")
    private String Kontinent;
    @Column(columnDefinition = "TEXT")
    private String Hotelbew;
    @Column(columnDefinition = "TEXT")
    private String Zimmerbew;
    @Column(columnDefinition = "TEXT")
    private String Servicebew;
    @Column(columnDefinition = "TEXT")
    private String Lagebew;
    @Column(columnDefinition = "TEXT")
    private String Gatronomiebew;
    @Column(columnDefinition = "TEXT")
    private String SportAndUnterhaltungbew;
    @Column(columnDefinition = "TEXT")
    private String BewAnzahl;
    @Column(columnDefinition = "TEXT")
    private String Weiterempfehlung;
    @Column(columnDefinition = "TEXT")
    private String Gesamtbewertung;
    @Column(columnDefinition = "TEXT")
    private String Sterne;
    @Column(columnDefinition = "TEXT")
    private String Award;
    @Column(columnDefinition = "TEXT")
    private String Position;
    @Column(columnDefinition = "TEXT")
    private String Zimmerausstattung;
    @Column(columnDefinition = "TEXT")
    private String Aktivitaeten;
    @Column(columnDefinition = "TEXT")
    private String Umgebung;
    @Column(columnDefinition = "TEXT")
    private String Gastronomie;
    @Column(columnDefinition = "TEXT")
    private String Ausstattung;
    @Column(columnDefinition = "TEXT")
    private String Strand;

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getTelefon() {
        return Telefon;
    }

    public void setTelefon(String telefon) {
        Telefon = telefon;
    }

    public String getStadt() {
        return Stadt;
    }

    public void setStadt(String stadt) {
        Stadt = stadt;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getLand() {
        return Land;
    }

    public void setLand(String land) {
        Land = land;
    }

    public String getKontinent() {
        return Kontinent;
    }

    public void setKontinent(String kontinent) {
        Kontinent = kontinent;
    }

    public String getHotelbew() {
        return Hotelbew;
    }

    public void setHotelbew(String hotelbew) {
        Hotelbew = hotelbew;
    }

    public String getZimmerbew() {
        return Zimmerbew;
    }

    public void setZimmerbew(String zimmerbew) {
        Zimmerbew = zimmerbew;
    }

    public String getServicebew() {
        return Servicebew;
    }

    public void setServicebew(String servicebew) {
        Servicebew = servicebew;
    }

    public String getLagebew() {
        return Lagebew;
    }

    public void setLagebew(String lagebew) {
        Lagebew = lagebew;
    }

    public String getGatronomiebew() {
        return Gatronomiebew;
    }

    public void setGatronomiebew(String gatronomiebew) {
        Gatronomiebew = gatronomiebew;
    }

    public String getSportAndUnterhaltungbew() {
        return SportAndUnterhaltungbew;
    }

    public void setSportAndUnterhaltungbew(String sportAndUnterhaltungbew) {
        SportAndUnterhaltungbew = sportAndUnterhaltungbew;
    }

    public String getBewAnzahl() {
        return BewAnzahl;
    }

    public void setBewAnzahl(String bewAnzahl) {
        BewAnzahl = bewAnzahl;
    }

    public String getWeiterempfehlung() {
        return Weiterempfehlung;
    }

    public void setWeiterempfehlung(String weiterempfehlung) {
        Weiterempfehlung = weiterempfehlung;
    }

    public String getGesamtbewertung() {
        return Gesamtbewertung;
    }

    public void setGesamtbewertung(String gesamtbewertung) {
        Gesamtbewertung = gesamtbewertung;
    }

    public String getSterne() {
        return Sterne;
    }

    public void setSterne(String sterne) {
        Sterne = sterne;
    }

    public String getAward() {
        return Award;
    }

    public void setAward(String award) {
        Award = award;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getZimmerausstattung() {
        return Zimmerausstattung;
    }

    public void setZimmerausstattung(String zimmerausstattung) {
        Zimmerausstattung = zimmerausstattung;
    }

    public String getAktivitaeten() {
        return Aktivitaeten;
    }

    public void setAktivitaeten(String aktivitaeten) {
        Aktivitaeten = aktivitaeten;
    }

    public String getUmgebung() {
        return Umgebung;
    }

    public void setUmgebung(String umgebung) {
        Umgebung = umgebung;
    }

    public String getGastronomie() {
        return Gastronomie;
    }

    public void setGastronomie(String gastronomie) {
        Gastronomie = gastronomie;
    }

    public String getAusstattung() {
        return Ausstattung;
    }

    public void setAusstattung(String ausstattung) {
        Ausstattung = ausstattung;
    }

    public String getStrand() {
        return Strand;
    }

    public void setStrand(String strand) {
        Strand = strand;
    }
}
