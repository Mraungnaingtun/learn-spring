package com.trainSpringBoot.logant.PropertyExpressions;

public class Property {
}

//then can call in repo like this 
//List<Person> findByAddressZipCode(ZipCode zipCode);

/*
 * @Entity
 * public class Person {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY)
 * private Long id;
 * private String name;
 * 
 * @OneToOne(cascade = CascadeType.ALL)
 * private Address address;
 * 
 * // Constructors, getters, and setters
 * }
 */

/*
 * @Entity
 * public class Address {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY)
 * private Long id;
 * private String street;
 * 
 * @OneToOne(cascade = CascadeType.ALL)
 * private ZipCode zipCode;
 * 
 * // Constructors, getters, and setters
 * }
 */

/*
 * @Entity
 * public class ZipCode {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY)
 * private Long id;
 * private String code;
 * 
 * // Constructors, getters, and setters
 * }
 */