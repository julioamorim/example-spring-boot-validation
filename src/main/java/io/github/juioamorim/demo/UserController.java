package io.github.juioamorim.demo;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	// in the context for the validation, the annotation @valid is the most
	// important annotation
	// when some argument/field failure, Spring boot throws a
	// ArgumentNotValidxception exception
	@PostMapping("/users")
	ResponseEntity<String> addUser(@Valid @RequestBody User user) {

		// persisting user
		return ResponseEntity.ok("User is valid");
	}

}
