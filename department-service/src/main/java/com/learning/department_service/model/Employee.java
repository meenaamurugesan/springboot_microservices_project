package com.learning.department_service.model;

public record Employee(long id, long departmentId, String name, int age, String position) {

}
