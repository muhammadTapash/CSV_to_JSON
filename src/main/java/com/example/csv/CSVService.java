package com.example.csv;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CSVService {
	
	
  @Autowired
  ProductRepository productRepository;

  public void save(MultipartFile file) {
    try {
      List<Product> products = CSVHelper.csvToTutorials(file.getInputStream());
      productRepository.saveAll(products);
      
    } catch (IOException e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }
  public List<Product> getAllTutorials() {
	    return productRepository.findAll();
	  }
  
  
  public ByteArrayInputStream load() {
	    List<Product> products = productRepository.findAll();

	    ByteArrayInputStream in = CSVHelper.tutorialsToCSV(products);
	    return in;
	  }
  
	}