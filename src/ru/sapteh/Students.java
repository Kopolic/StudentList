package ru.sapteh;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Students {
    private int id;
    private String lastName;
    private String firstName;
    private String surname;
    private Date date;
    public Students(int id, String lastName, String firstName, String surname, Date date){
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.surname = surname;
        this.date = date;
    }
    public int getYearToday(){
        Date dataToday = new Date();
        return (int)((dataToday.getTime()-getDate().getTime())/1000/60/60/24/365);
    }
    public int getId() {
        return id;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getSurname() {
        return surname;
    }
    public Date getDate() {
        return date;
    }
    public String russianDate(){
        return new SimpleDateFormat("dd.MM.yyyy").format(getDate());
    }
    public String toString(){
       return String.format("%d %s %s %s %s \nВозраст: %d \n", getId(),getLastName(),getFirstName(),getSurname(),russianDate(), getYearToday());
    }
}
