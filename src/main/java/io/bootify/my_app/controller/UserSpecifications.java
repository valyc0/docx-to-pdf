package io.bootify.my_app.controller;

import org.springframework.data.jpa.domain.Specification;

import io.bootify.my_app.domain.User;

public class UserSpecifications {

    public static Specification<User> hasFirstName(String firstName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("firstName"), firstName);
    }

    public static Specification<User> hasLastName(String lastName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("lastName"), lastName);
    }

    public static Specification<User> hasEmail(String email) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("email"), email);
    }

    public static Specification<User> hasFirstNameOrLastName(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.or(
                criteriaBuilder.like(root.get("firstName"), "%" + name + "%"),
                criteriaBuilder.like(root.get("lastName"), "%" + name + "%")
        );
    }
}
