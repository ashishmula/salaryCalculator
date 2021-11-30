package com.example.salary;

import java.util.ArrayList;

public class Qualification {
    static ArrayList<Qualification> qualifications=new ArrayList<Qualification>();

    int id;
    int salary;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Qualification(int id, String name,int salary) {
        this.id = id;
        this.name = name;
        this.salary =salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public static void initQualification(){
        qualifications=new ArrayList<>();
        Qualification q1=new Qualification(1,"Secondary School",52000);
        Qualification q2=new Qualification(2,"Masters",76000);
        Qualification q3=new Qualification(3,"B.SC",70000);
        Qualification q4=new Qualification(4,"Diploma",65000);
        qualifications.add(q1);
        qualifications.add(q2);
        qualifications.add(q3);
        qualifications.add(q4);
    }

    public static ArrayList<Qualification> getQualifications() {
        return qualifications;
    }
    public static String[] qualificationNames(){
        String[] names=new String[qualifications.size()];
        for(int i=0;i<qualifications.size();i++){
            names[i]=qualifications.get(i).name;
        }
        return names;
    }
    public static int[] qualificationSalary(){
        int[] slaries=new int[qualifications.size()];
        for(int i=0;i<qualifications.size();i++){
            slaries[i]=qualifications.get(i).getSalary();
        }
        return slaries;
    }
}


