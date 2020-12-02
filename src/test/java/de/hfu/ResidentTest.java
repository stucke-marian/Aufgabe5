package de.hfu;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;


public class ResidentTest {

	@Test
	public void test() throws ResidentServiceException {
		Resident resident1 = new Resident("Marian", "Stucke", "Strasse", "Furtwangen", new Date(2020,10,10));
		Resident resident2 = new Resident("Peter", "Stucke", "Test", "Furtwangen", new Date(2020,10,10));
		Resident resident3 = new Resident("Test", "Stucke", "Test", "Furtwangen", new java.util.Date(2020,10,10));
		
		
		ResidentRepositoryStub stubObject = new ResidentRepositoryStub();
		
		BaseResidentService residentService = new BaseResidentService();
		residentService.setResidentRepository(stubObject);
		
		
		
		//selbe person
		assertTrue(resident2.getGivenName().equals(residentService.getUniqueResident(resident2).getGivenName()));
		//unterschiedliche person
		assertEquals(false, resident1.getGivenName().equals(residentService.getUniqueResident(resident2).getGivenName()));

		
		
		
		List<Resident> residentList1 = residentService.getFilteredResidentsList(resident1);
		List<Resident> residentList2 = residentService.getFilteredResidentsList(resident2);
		List<Resident> residentList3 = residentService.getFilteredResidentsList(resident3);
		
		assertTrue(residentList1.size() == 2);
		assertTrue(residentList2.size() == 1);
		assertTrue(residentList3.size() == 0);
		
	}
	
	
	@Test(expected = ResidentServiceException.class)
	public void noMatch() throws ResidentServiceException {
		Resident resident3 = new Resident("Test", "Stucke", "Test", "Furtwangen", new Date(2020,10,10));
		
		ResidentRepositoryStub stubObject = new ResidentRepositoryStub();
		BaseResidentService residentService = new BaseResidentService();
		residentService.setResidentRepository(stubObject);
		
		residentService.getUniqueResident(resident3);
	}
	
	
	@Test(expected = ResidentServiceException.class)
	public void moreThanOne() throws ResidentServiceException {
		Resident resident1 = new Resident("Marian", "Stucke", "Strasse", "Furtwangen", new Date(2020,10,10));
		
		ResidentRepositoryStub stubObject = new ResidentRepositoryStub();
		BaseResidentService residentService = new BaseResidentService();
		residentService.setResidentRepository(stubObject);
		
		residentService.getUniqueResident(resident1);
	}

}
