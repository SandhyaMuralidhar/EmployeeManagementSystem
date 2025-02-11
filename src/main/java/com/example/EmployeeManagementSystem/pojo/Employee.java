package com.example.EmployeeManagementSystem.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Table(name = "Employee")
    public class Employee {
        @Id
        @Column(name="id")
        private String id;
        @Column(name="name")
        private String employeeName;
        @Column(name="email")
        private  String employeeEmail;
        @Column(name="phone")
        private Long employeePhone;
        @Column(name="gender")
        private  String employeeGender;
        @Column(name="salary")
        private  String employeeSalary;
        @Column(name="role")
        private String employeeRole;

        public String getId() {
            return id;
        }

        public void setId(String employeeId) {
            this.id = employeeId;
        }

        public String getEmployeeName() {
            return employeeName;
        }

        public void setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
        }

        public String getEmployeeEmail() {
            return employeeEmail;
        }

        public void setEmployeeEmail(String employeeEmail) {
            this.employeeEmail = employeeEmail;
        }

        public Long getEmployeePhone() {
            return employeePhone;
        }

        public void setEmployeePhone(Long employeePhone) {
            this.employeePhone = employeePhone;
        }

        public String getEmployeeGender() {
            return employeeGender;
        }

        public void setEmployeeGender(String employeeGender) {
            this.employeeGender = employeeGender;
        }

        public String getEmployeeSalary() {
            return employeeSalary;
        }

        public void setEmployeeSalary(String employeeSalary) {
            this.employeeSalary = employeeSalary;
        }

        public String getEmployeeRole() {
            return employeeRole;
        }

        public void setEmployeeRole(String employeeRole) {
            this.employeeRole = employeeRole;
        }
    }

