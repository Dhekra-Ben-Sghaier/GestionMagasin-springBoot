package tn.esprit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.entities.Stock;
import tn.esprit.repository.StockRepository;


@Slf4j
@Service
public class StockServiceImpl implements IStcokService{

	
	@Autowired
	StockRepository stockRepository;
	@Override
	public List<Stock> retriveStock() {
		// TODO Auto-generated method stub
		return (List<Stock>) stockRepository.findAll();
	}

	@Override
	public Stock retriveById(Long id) {
		// TODO Auto-generated method stub
		Stock stock = stockRepository.findById(id).orElse(null); //ou bien .get qui retourne un obj vide si id n'existe pas
		//System.out.println("Stock :" + stock);
		log.info("Stock :" + stock);
		return stock;
	}

	@Override
	public Stock saveStock(Stock s) {
		// TODO Auto-generated method stub
		
		return stockRepository.save(s);
	}

	@Override
	public Stock updateStock(Stock s) {
		// TODO Auto-generated method stub
		return stockRepository.save(s);
	}

	@Override
	public void deleteStock(Long id) {
		
		// TODO Auto-generated method stub
		Stock s = stockRepository.findById(id).orElse(null);
		stockRepository.delete(s);
		
	}
	


	@Override
	//@Scheduled(cron = "*/10 * * * * *" )
	public void retrieveStatusStock() {
		List<Stock> s=(List<Stock>) stockRepository.findAll();
		for (Stock stock : s) {
			if(stock.getQteMin()>stock.getQte()){
				System.out.println(stock.toString());
				log.info("stock "+stock.toString());

			}
		}
		
	}
	

}
