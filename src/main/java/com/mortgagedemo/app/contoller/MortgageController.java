package com.mortgagedemo.app.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mortgagedemo.app.model.Mortgage;
import com.mortgagedemo.app.repository.MortgageRepository;

@RestController
@RequestMapping("/data")
public class MortgageController {

	@Autowired
	private MortgageRepository mortgageRepository;

	@PostMapping("/add")
	public ResponseEntity<Mortgage> add(@RequestBody Mortgage mortgage) {
		mortgage = mortgageRepository.add(mortgage);
		if (mortgage != null)
			return new ResponseEntity<Mortgage>(mortgage, HttpStatus.CREATED);
		else
			return new ResponseEntity<Mortgage>(mortgage, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PostMapping("/set/{index}")
	public ResponseEntity<Mortgage> set(@PathVariable int index, @RequestBody Mortgage mortgage) {
		mortgage = mortgageRepository.set(index, mortgage);
		if (mortgage != null)
			return new ResponseEntity<Mortgage>(mortgage, HttpStatus.OK);
		else
			return new ResponseEntity<Mortgage>(mortgage, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/getAll")
	public ResponseEntity<Mortgage[]> getAll() {

		Mortgage[] mortgages = mortgageRepository.array;

		if (mortgages != null && mortgages[0] != null)
			return new ResponseEntity<Mortgage[]>(mortgages, HttpStatus.OK);
		else
			return new ResponseEntity<Mortgage[]>(new Mortgage[0], HttpStatus.NO_CONTENT);
	}
}
