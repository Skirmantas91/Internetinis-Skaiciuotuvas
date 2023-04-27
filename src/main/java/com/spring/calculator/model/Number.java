package com.spring.calculator.model;

import jakarta.validation.constraints.Min;

import javax.persistence.*;

//Entity tai POJO klase sujungta su duomenu bazeje esancia lentele naudojant ORM technika
@Entity
//Anotacija nurodo jog susiesime POJO klase su duomenu bazeje esancia lentele, kurios pavadinimas "numbers"
@Table(name = "numbers") //DB lentele - augiskaita pagal klases pavadinima
public class Number {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Atitinka DB autoincrement f-ja
    @Column(name= "id")
    private int id;

    @Column(name = "sk1")
    @Min(value=0, message="Validacijos klaida:skaicius negali buti neigiamas")
    private int sk1;

    @Column(name = "sk2")
    @Min(value=0, message="Validacijos klaida:skaicius negali buti neigiamas")
    private int sk2;

    @Column(name = "action")
    private String action;

    @Column(name = "result")
    private double result;



    //Esamu duomenu bazeje irasu paieskai, redagavimui, trynimui
    public Number(int id, int sk1, int sk2, String action, double result) {
        this.id = id;
        this.sk1 = sk1;
        this.sk2 = sk2;
        this.action = action;
        this.result = result;
    }
    //Naujo iraso DB kurimui
    public Number(int sk1, int sk2, String action, double result) {
        this.sk1 = sk1;
        this.sk2 = sk2;
        this.action = action;
        this.result = result;
    }

    //butinas tuscias konstruktorius naudojant Spring framerwork
    public Number() {

    }

    public int getId() {
        return id;
    }


    public int getSk1() {
        return sk1;
    }

    public void setSk1(int sk1) {
        this.sk1 = sk1;
    }

    public int getSk2() {
        return sk2;
    }

    public void setSk2(int sk2) {
        this.sk2 = sk2;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Number{" +
                "id=" + id +
                ", sk1=" + sk1 +
                ", sk2=" + sk2 +
                ", action='" + action + '\'' +
                ", result=" + result +
                '}';
    }
}
