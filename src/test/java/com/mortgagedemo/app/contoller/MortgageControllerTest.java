package com.mortgagedemo.app.contoller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mortgagedemo.app.model.Mortgage;

@SpringBootTest
class MortgageControllerTest {

	@Autowired
	private MortgageController mortgageController;
	
	@Mock
	private MortgageController mortgageControllerMock;
	
	public static Mortgage getMortgageObj() {
		Mortgage obj = new Mortgage();
		obj.setOfferID("123");
		obj.setMortgageId("123");
		obj.setProductId("123");
		obj.setVersion(1);
		obj.setCreatedDate("05/02/2020");
		obj.setOfferDate("05/02/2020");
		obj.setOfferExpired('N');
		return obj;
	}

	int index = 0;
	
	@Test
	void testAdd() {
		mortgageController.add(getMortgageObj());
	}
	
	@Test
	void testAddEmptyObj() {
		mortgageController.add(new Mortgage());
	}
	
	@Test
	void testAddNullObj() {
		when(mortgageControllerMock.add(getMortgageObj())).thenReturn(null);
	}
	
	@Test
	void testSet() {
		mortgageController.set(index,getMortgageObj());
	}
	
	@Test
	void testSetEmptyObj() {
		mortgageController.set(index,new Mortgage());
	}
	
	@Test
	void testSetNullObj() {
		when(mortgageControllerMock.set(index,getMortgageObj())).thenReturn(null);
	}
	
	@Test
	void testGetAll() {
		when(mortgageControllerMock.getAll()).thenReturn(null);
	}
	
}
