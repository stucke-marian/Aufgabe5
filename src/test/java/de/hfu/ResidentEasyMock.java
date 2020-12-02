package de.hfu;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*; 
import static org.easymock.EasyMock.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class ResidentEasyMock {

	@Test
	public void test() throws ResidentServiceException {
		Resident resident1 = new Resident("Marian", "Stucke", "Strasse", "Furtwangen", new Date(2020,10,10));
		Resident resident2 = new Resident("Peter", "Stucke", "Test", "Furtwangen", new Date(2020,10,10));
		Resident resident3 = new Resident("Test", "Stucke", "Test", "Furtwangen", new java.util.Date(2020,10,10));
		
	    List<Resident> residentList1 = new ArrayList<>();
		residentList1.add(resident1);
		residentList1.add(resident2);
		residentList1.add(resident3);
		 
		
		ResidentRepository mockObject = createMock(ResidentRepository.class);
		expect(mockObject.getResidents()).andReturn(residentList1);
		
		replay(mockObject);
		
		BaseResidentService residentService = new BaseResidentService();
		residentService.setResidentRepository(mockObject);
		
		int size1 = residentService.getFilteredResidentsList(resident2).size();
		
		
		verify(mockObject);
		
		assertThat(size1, equalTo(1));
	}
	
	
	@Test
	public void test2() throws ResidentServiceException {
		Resident resident1 = new Resident("Marian", "Stucke", "Strasse", "Furtwangen", new Date(2020,10,10));
		Resident resident2 = new Resident("Peter", "Stucke", "Test", "Furtwangen", new Date(2020,10,10));
		Resident resident3 = new Resident("Test", "Stucke", "Test", "Furtwangen", new java.util.Date(2020,10,10));
		
	    List<Resident> residentList1 = new ArrayList<>();
		residentList1.add(resident1);
		residentList1.add(resident2);
		residentList1.add(resident3);
		 
		
		ResidentRepository mockObject = createMock(ResidentRepository.class);
		expect(mockObject.getResidents()).andReturn(residentList1);
		
		replay(mockObject);
		
		BaseResidentService residentService = new BaseResidentService();
		residentService.setResidentRepository(mockObject);
		
		Resident resident = residentService.getUniqueResident(resident3);
		
		
		verify(mockObject);
		
		assertThat(resident, equalTo(resident3));
	}
}
