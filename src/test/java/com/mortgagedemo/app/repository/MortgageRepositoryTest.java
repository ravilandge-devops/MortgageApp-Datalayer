package com.mortgagedemo.app.repository;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.mortgagedemo.app.model.Mortgage;

class MortgageRepositoryTest {

	@Autowired
	private MortgageRepository mortgageRepositoryr;
	
	@Mock
	private MortgageRepository mortgageRepositoryrMock;
	
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
		mortgageRepositoryr.add(getMortgageObj());
	}
	
	@Test
	void testAddEmptyObj() {
		mortgageRepositoryr.add(new Mortgage());
	}
	
	@Test
	void testAddNullObj() {
		when(mortgageRepositoryrMock.add(getMortgageObj())).thenReturn(null);
	}
	
	@Test
	void testSet() {
		mortgageRepositoryr.set(index,getMortgageObj());
	}
	
	@Test
	void testSetEmptyObj() {
		mortgageRepositoryr.set(index,new Mortgage());
	}
	
	@Test
	void testSetNullObj() {
		when(mortgageRepositoryrMock.set(index,getMortgageObj())).thenReturn(null);
	}
}
