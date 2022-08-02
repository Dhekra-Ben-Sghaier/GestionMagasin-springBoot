package tn.esprit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.entities.Stock;
import tn.esprit.services.IStcokService;

@RestController
@Api(tags = "stock management")
@RequestMapping("/stock")
public class StockController {
	@Autowired
	IStcokService stockService;
	
	
	@ApiOperation(value = "Récupérer la liste des stocks")
	@GetMapping("/afficherStock")
	List<Stock> afficherStocks(){
		return stockService.retriveStock();
		
	}
	@GetMapping("/afficherStockById")
	@ResponseBody
	Stock afficherStock(@RequestParam Long idStock) {
		return stockService.retriveById(idStock);
		
	}
	
	@PostMapping("/ajouterStock")
	@ResponseBody
	Stock ajouterStock(@RequestBody Stock s) {
		return stockService.saveStock(s);
	}
	
	@PutMapping("/modifierStock")
	@ResponseBody
	Stock modifierStock(@RequestBody Stock s) {
		return stockService.updateStock(s);
	}
	@DeleteMapping("/deleteStock")
	@ResponseBody
	void supprimerStock(@RequestParam Long id) {
		stockService.deleteStock(id);
		
	}
	
	
	
	@GetMapping("/retrieveStatusStock")
	@ResponseBody
	public void retrieveStatusStock() {
		 stockService.retrieveStatusStock();
		
	}

}
