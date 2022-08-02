package tn.esprit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.entities.Stock;
import tn.esprit.services.IStcokService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplTest {
	
	@Autowired
	private IStcokService stockService;
	
	@Test
	public void testAddStock() {
		List<Stock> stocks = stockService.retriveStock();
		int expected=stocks.size();
		Stock s = new Stock();
		s.setLibelleStock("stock test");
		s.setQte(10);
		s.setQteMin(100);
		Stock savedStock= stockService.saveStock(s);
		assertEquals(expected+1, stockService.retriveStock().size());
		assertNotNull(savedStock.getLibelleStock());
		stockService.deleteStock(savedStock.getIdStock());
		}
	
	@Test
	public void testAddOptimizedStock() {
		Stock s =  Stock.builder().libelleStock("test stock").qte(50).qteMin(10).build();
		Stock savedStock = stockService.saveStock(s);
	    assertNotNull(savedStock.getIdStock());
		assertSame(10, savedStock.getQte());
		assertTrue(savedStock.getQteMin()>0);
		stockService.deleteStock(savedStock.getIdStock());
		}
	
	@Test
	public void testDeleteStock() {
		Stock s =  Stock.builder().libelleStock("test stock").qte(50).qteMin(10).build();
		Stock savedStock = stockService.saveStock(s);
		stockService.deleteStock(savedStock.getIdStock());
	    assertNotNull(savedStock.getIdStock());
		}
	
	
	

}
