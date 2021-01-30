package ru.job4j.stream;

import java.util.Map;

public class Employee {
    private String name;
    private String department;
    private String position;
    private double salary;
    private int experience;
    private int age;
    private Map<String, Integer> children;

   static class Builder {
       private String name;
       private String department;
       private String position;
       private double salary;
       private int experience;
       private int age;
       private Map<String, Integer> children;

       Builder buildName(String name) {
           this.name = name;
           return this;
       }

       Builder buildDepartment(String department) {
           this.department = department;
           return this;
       }

       Builder buildPosition(String position) {
           this.position = position;
           return this;
       }

       Builder buildSalary(double salary) {
           this.salary = salary;
           return this;
       }

       Builder buildExperiance(int experience) {
           this.experience = experience;
           return this;
       }

       Builder buildAge(int age) {
           this.age = age;
           return this;
       }

       Builder buildChildren(Map<String, Integer> children) {
           this.children = children;
           return this;
       }

       Employee build() {
           Employee employee = new Employee();
           employee.name = name;
           employee.department = department;
           employee.position = position;
           employee.salary = salary;
           employee.experience = experience;
           employee.age = age;
           employee.children = children;
           return employee;
       }
   }
}
