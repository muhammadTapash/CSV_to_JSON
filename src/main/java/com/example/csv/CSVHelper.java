package com.example.csv;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;

public class CSVHelper {
	
  public static String TYPE = "text/csv";
  
 
  static String[] HEADERs = { "Id","Title", "Description"};

  public static boolean hasCSVFormat(MultipartFile file) {
	  
	  CSVFormat.EXCEL.withHeader();

    if (!TYPE.equals(file.getContentType())) {
    	 return false;
    }

    return true;
  }

  public static List<Product> csvToTutorials(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
    		
    		
        //CSVParser csvParser = new CSVParser(fileReader, CSVFormat.EXCEL.DEFAULT.withFirstRecordAsHeader());) {
    		CSVParser csvParser = new CSVParser(fileReader, CSVFormat.EXCEL.withHeader(  ));) {
    		//CSVParser csvParser = new CSVParser(fileReader, CSVFormat.EXCEL.withFirstRecordAsHeader().withHeader( "Title","Description"
                 //  ));) {
        		

      List<Product> products = new ArrayList<Product>();

    
      
      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
        Product product = new Product(
              Long.parseLong(csvRecord.get("Id")),
              csvRecord.get("Title"),
              csvRecord.get("Description")
             
            );

        products.add(product);
      }

      return products;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
    }
  
  
  
  public static ByteArrayInputStream tutorialsToCSV(List<Product> products) {
	    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

	    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
	        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
	      for (Product product : products) {
	        List<String> data = Arrays.asList(
	              String.valueOf(product.getId()),
	              product.getTitle(),
	              product.getDescription()
	              //String.valueOf(tutorial.isPublished())
	            );

	        csvPrinter.printRecord(data);
	      }

	      csvPrinter.flush();
	      return new ByteArrayInputStream(out.toByteArray());
	    } catch (IOException e) {
	      throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
	    }
	  }
 
	}

