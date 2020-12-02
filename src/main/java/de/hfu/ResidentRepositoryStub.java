package de.hfu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResidentRepositoryStub implements ResidentRepository {

	public ResidentRepositoryStub() {
		
	}

	@Override
	public List<Resident> getResidents() {
		Resident resident1 = new Resident("Marian", "Stucke", "Strasse", "Furtwangen", new Date(2020,10,10));
		Resident resident5 = new Resident("Marian", "Stucke", "Strasse", "Furtwangen", new Date(2020,10,10));
		Resident resident2 = new Resident("Peter", "Stucke", "Test", "Furtwangen", new Date(2020,10,10));
		Resident resident3 = new Resident("Markus", "Stucke", "AndererTest", "Furtwangen", new Date(2020,10,10));
		Resident resident4 = new Resident("Felix", "Stucke", "TestDrei", "Furtwangen", new Date(2020,10,10));
		
		
		List<Resident> residentList = new ArrayList<>();
		residentList.add(resident1);
		residentList.add(resident2);
		residentList.add(resident3);
		residentList.add(resident4);
		residentList.add(resident5);
		
		return residentList;
	}

}
