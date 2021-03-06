package ar.com.meli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ar.com.meli.exceptions.BadRequestException;
import ar.com.meli.exceptions.NotMutantException;
import ar.com.meli.mutant.service.MutantDetectorService;
import ar.com.meli.mutant.valueobjects.DnaRecordStats;
import ar.com.meli.mutant.valueobjects.MutantRequest;

@RestController
public class MutantService {

	@Autowired
	private MutantDetectorService mutantDetectorService;

	@RequestMapping(method = RequestMethod.POST, path = "/mutant", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void isMutant(@RequestBody MutantRequest request) throws NotMutantException, BadRequestException {

		try {
			if (!mutantDetectorService.isMutant(request.getDna())) {
				throw new NotMutantException("DNA is not mutant.");
			}
		} catch (IllegalArgumentException e) {
			throw new BadRequestException(e.getMessage());
		}

	}

	@RequestMapping(method = RequestMethod.GET, path = "/stats")
	public DnaRecordStats stats() {

		return mutantDetectorService.getDnaStats();

	}

}
