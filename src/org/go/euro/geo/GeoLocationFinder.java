package org.go.euro.geo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

import org.go.euro.geo.util.JSONCVSWriter;
import org.go.euro.geo.util.JSONObjectParser;
import org.json.JSONException;
import org.json.JSONObject;

public class GeoLocationFinder {

	public JSONObject getJSONQueryObject(String strInput) throws IOException,
	JSONException {
		URL queryURL = new URL(
				"https://api.goeuro.com/api/v1/suggest/position/en/name/"
						+ strInput);
		BufferedReader urlReader = new BufferedReader(new InputStreamReader(
				queryURL.openStream(), Charset.forName("UTF-8")));
		StringBuilder queryResult = new StringBuilder();
		String strLine = urlReader.readLine();
		while (strLine != null) {
			queryResult.append(strLine);
			strLine = urlReader.readLine();
		}
		return new JSONObject(queryResult.toString());

	}

	public String getCurrentWorkingDir() {
		return this.getClass().getProtectionDomain().getCodeSource()
				.getLocation().getPath();
	}

	public static void main(String args[]) {
		GeoLocationFinder fetchJson = new GeoLocationFinder();
		try {
			String strInput = args[0];
			JSONObject jsonObj = fetchJson.getJSONQueryObject(strInput);
			if(jsonObj == null)
				throw new NullPointerException();
			JSONObjectParser parseJson = new JSONObjectParser();
			parseJson.startParsing(jsonObj);
			if(parseJson.getParserResult().size() > 0)
			{
				JSONCVSWriter.writeCVSFile(parseJson.getParserResult(),
						fetchJson.getCurrentWorkingDir());
			}
			else
			{
				System.out.println("No results found for string "+strInput);
			}
		}
		catch(IndexOutOfBoundsException noArgExp)
		{
			System.out.println("No input string");
		}
		catch(NullPointerException exp)
		{
			System.out.println("No results");
		}

		catch (Exception exp) 
		{
			//something else is wrong
			exp.printStackTrace();
		}



	}
}
