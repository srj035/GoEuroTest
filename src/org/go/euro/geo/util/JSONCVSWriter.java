package org.go.euro.geo.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.go.euro.geo.GeoLocationData;

import au.com.bytecode.opencsv.CSVWriter;

public class JSONCVSWriter 
{
	
	public static void writeCVSFile(List<GeoLocationData> geoLocData, String cwdPath) throws IOException
	{
		
		String csvFileName = cwdPath + "GeoLocation.csv";
		CSVWriter csvWriter = new CSVWriter(new FileWriter(csvFileName));		
		for(GeoLocationData geoObj:geoLocData)
		{
			csvWriter.writeNext(geoObj.getPosType()+ ", "+geoObj.getPoId()+", "+geoObj.getName()+", "+
								geoObj.getLocType()+ ", "+geoObj.getLatitude()+", "+geoObj.getLongitude());
		}
		System.out.println("CSV file created in "+cwdPath);
		csvWriter.close();
		
	}
}
