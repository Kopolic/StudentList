package ru.sapteh;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        //read
        ArrayList<Students> arrayList = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader("listStudents.txt"))) {
            while (bf.ready()) {
                Students students = studCreate(bf.readLine());
                arrayList.add(students);
            }
        }
        //input
        try(BufferedReader readId = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Введите id студента");
            int id = Integer.parseInt(readId.readLine());
            for (Students students: arrayList) {
                if(id == students.getId()){
                    System.out.printf("Студент: %s %s %s имеет возраст %d года.",students.getFirstName(), students.getLastName(), students.getSurname(),
                                    students.getYearToday());
                }
            }
        }

        //write
        try(FileWriter fw = new FileWriter("russianListStudents.txt")){
            for (Students student: arrayList) {
                fw.write(student.toString());
                fw.write("\n");
            }
        }
    }
    public static Students studCreate(String readLine) throws ParseException {
        String[] strPerson = readLine.split(" ");
        int id = Integer.parseInt(strPerson[0]);
        String lastName = strPerson[1];
        String firstName = strPerson[2];
        String surname = strPerson[3];
        Date date = new SimpleDateFormat("MM/dd/yyyy").parse(strPerson[4]);
        return new Students(id,lastName,firstName,surname,date);
    }
}
