package com.work.pennyflo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.work.pennyflo.entity.Property;
import com.work.pennyflo.repository.PropertyRepository;

@Service
public class PropertyService {
	private final PropertyRepository propertyRepository;

	public PropertyService(PropertyRepository propertyRepository) {
		this.propertyRepository = propertyRepository;
	}

	public Property addProperty(Property property) {
		return propertyRepository.save(property);
	}

	public List<Property> getAllProperties() {
		return propertyRepository.findAll();
	}

	public Optional<Property> getPropertyById(Long id) {
		return propertyRepository.findById(id);
	}

	public void deleteProperty(Long id) {
		propertyRepository.deleteById(id);
	}
}
