package de.hfu;



import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
	

	
    public static void main( String[] args )
    {
    	/*
    	//erstellen von scanner
        Scanner scanner = new Scanner(System.in);
        //text einlesen
        String text = scanner.next();
        //text ausgeben
        System.out.println(text.toUpperCase());
        //scanner schliessen
        scanner.close();*/
    	
    	Resident resident1 = new Resident("Marian", "Stucke", "Strasse", "Furtwangen", new Date(2020,10,10));
		Resident resident2 = new Resident("Peter", "Stucke", "Test", "Furtwangen", new Date(2020,10,10));
		Resident resident3 = new Resident("Test", "Stucke", "Test", "Furtwangen", new Date(2020,10,10));
		
		
		ResidentRepositoryStub stubObject = new ResidentRepositoryStub();
		
		BaseResidentService residentService = new BaseResidentService();
		residentService.setResidentRepository(stubObject);
		
		
	
		try {
			residentService.getUniqueResident(resident2);
			residentService.getUniqueResident(resident2);
		} catch (ResidentServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			residentService.getUniqueResident(resident1);
		} catch (ResidentServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			residentService.getUniqueResident(resident3);
		} catch (ResidentServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		List<Resident> residentList1 = residentService.getFilteredResidentsList(resident1);
		List<Resident> residentList2 = residentService.getFilteredResidentsList(resident2);
		List<Resident> residentList3 = residentService.getFilteredResidentsList(resident3);
		

    }
}
