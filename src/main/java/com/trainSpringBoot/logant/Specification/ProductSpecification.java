package com.trainSpringBoot.logant.Specification;

import org.springframework.data.jpa.domain.Specification;

/*
 * Summary of Common Specification Methods:
    (1)Equality: equal, notEqual
    (2)String Matching: like, ilike, notLike
    (3)Range: between, greaterThan, lessThan, greaterThanOrEqual, lessThanOrEqual
    (4)Null Checks: isNull, isNotNull
    (5)Logical Operators: and, or, not
    (6)Joins: join, leftJoin, rightJoin
    (7)Ordering: orderBy (can be combined with CriteriaQuery)
 */
public class ProductSpecification {

    public static Specification<Product> hasName(String name) {
        return (root, query, criteriaBuilder) -> name == null ? null : criteriaBuilder.equal(root.get("name"), name);
    }

    public static Specification<Product> hasCategory(String category) {
        return (root, query, criteriaBuilder) -> category == null ? null
                : criteriaBuilder.equal(root.get("category"), category);
    }

    public static Specification<Product> priceGreaterThan(Double price) {
        return (root, query, criteriaBuilder) -> price == null ? null
                : criteriaBuilder.greaterThan(root.get("price"), price);
    }

    public static Specification<Product> priceLessThan(Double price) {
        return (root, query, criteriaBuilder) -> price == null ? null
                : criteriaBuilder.lessThan(root.get("price"), price);
    }
}
