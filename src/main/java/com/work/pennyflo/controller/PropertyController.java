package com.work.pennyflo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.work.pennyflo.dto.PropertyDTO;
import com.work.pennyflo.dto.UserDTO;
import com.work.pennyflo.entity.Property;
import com.work.pennyflo.entity.PropertyStatus;
import com.work.pennyflo.entity.User;
import com.work.pennyflo.service.PropertyService;
import com.work.pennyflo.service.UserService;

@RestController
@RequestMapping("/api/properties")
@CrossOrigin("*")
@ConditionalOnProperty(name = "swagger.enabled", havingValue = "true")
public class PropertyController {

	private final PropertyService propertyService;
	private final UserService userService;

	@Autowired
	public PropertyController(PropertyService propertyService, UserService userService) {
		this.propertyService = propertyService;
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<Property> addProperty(@RequestBody PropertyDTO propertyDTO) {
		Property property = convertToEntity(propertyDTO);
		Property savedProperty = propertyService.addProperty(property);
		return ResponseEntity.ok(savedProperty);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Property> getPropertyById(@PathVariable Long id) {
		Optional<Property> propertyOptional = propertyService.getPropertyById(id);
		return propertyOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@GetMapping
	public ResponseEntity<List<Property>> getAllProperties() {
		List<Property> properties = propertyService.getAllProperties();
		return ResponseEntity.ok(properties);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProperty(@PathVariable Long id) {
	    propertyService.deleteProperty(id);
	    return ResponseEntity.ok("Property with ID " + id + " has been successfully deleted");
	}
	 @PutMapping("/{id}")
	    public ResponseEntity<Property> updateProperty(@PathVariable Long id, @RequestBody PropertyDTO propertyDTO) {
	        Property existingProperty = propertyService.getPropertyById(id)
	                .orElseThrow(() -> new IllegalArgumentException("Property with ID " + id + " not found"));

	        Property updatedProperty = convertToEntity(propertyDTO);
	        updatedProperty.setId(existingProperty.getId());

	        Property savedProperty = propertyService.addProperty(updatedProperty);
	        return ResponseEntity.ok(savedProperty);
	    }


	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {

		User user = new User();
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setMobile(userDTO.getMobile());

		user.setRole(userDTO.getRole());

		userService.addUser(user);

		return ResponseEntity.ok("User registered successfully");
	}

	private Property convertToEntity(PropertyDTO propertyDTO) {
		Property property = new Property();
		property.setLocation(propertyDTO.getLocation());
		property.setNumberOfRooms(propertyDTO.getNumberOfRooms());
		property.setCost(propertyDTO.getCost());

		com.work.pennyflo.entity.User owner = userService.getUserById(propertyDTO.getOwnerId())
				.orElseThrow(() -> new IllegalArgumentException("Invalid owner ID: " + propertyDTO.getOwnerId()));

		property.setOwner(owner);

		property.setStatus(PropertyStatus.valueOf(propertyDTO.getStatus()));
		return property;
	}

}
