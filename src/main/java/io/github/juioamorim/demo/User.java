package io.github.juioamorim.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class User {

	@Id
	/*
	 * Indicates that the persistence provider should pick an appropriate strategy
	 * for the particular database. The AUTO generation strategy may expect a
	 * database resource to exist, or it may attempt to create one. A vendor may
	 * provide documentation on how to create such resources in the event that it
	 * does not support schema generation or cannot create the schema resource at
	 * runtime.
	 */
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@NotBlank(message = "Username is required")
	private String userName;

	@NotBlank(message = "Email is reqeuired")
	private String userEmail;

}
