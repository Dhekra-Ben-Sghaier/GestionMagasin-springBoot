package tn.esprit.services;

import java.util.List;

import tn.esprit.entities.Stock;

public interface IStcokService {
	
	
	List<Stock> retriveStock();
	Stock retriveById(Long id);
	Stock saveStock (Stock s);
	
	Stock updateStock (Stock s);
	
	void deleteStock(Long id);
	void retrieveStatusStock(); 

}
