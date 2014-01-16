package org.go.euro.geo.util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.go.euro.geo.GeoLocationData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class JSONObjectParser {


	private List<GeoLocationData> locationResult;
	public JSONObjectParser()
	{
		locationResult = new ArrayList<GeoLocationData>();
	}
	public List<GeoLocationData> getParserResult()
	{
		return locationResult;
	}
	public void startParsing(JSONObject queryJsonObj) throws JSONException
	{
		Iterator objList = queryJsonObj.keys();
		GeoLocationData locObj = new GeoLocationData();
		while(objList.hasNext())
		{
			Object jObj = objList.next();

			if(queryJsonObj.get(jObj.toString()) instanceof JSONArray)
			{
				startParsingJSONArray((JSONArray)queryJsonObj.get(jObj.toString()));
			}
			else
			{
				if(jObj.equals(locObj.POS_TYPE))
					locObj.setPosType(queryJsonObj.getString(locObj.POS_TYPE));

				else if(jObj.equals(locObj.POS_ID))
					locObj.setPoId(queryJsonObj.getInt(locObj.POS_ID));

				else if(jObj.equals(locObj.NAME))
					locObj.setName(queryJsonObj.getString(locObj.NAME));

				else if(jObj.equals(locObj.LOC_TYPE))
					locObj.setLocType(queryJsonObj.getString(locObj.LOC_TYPE));

				else if(jObj.equals(locObj.GEO_POS))
				{
					JSONObject geoPosObject = queryJsonObj.getJSONObject(locObj.GEO_POS);						
					locObj.setLatitude(geoPosObject.getDouble(locObj.LATITUDE));					
					locObj.setLongitude(geoPosObject.getDouble(locObj.LONGITUDE));
				}
			}	

		}
		if(!locObj.isObjectEmpty())
			locationResult.add(locObj);

	}
	private void startParsingJSONArray(JSONArray object) throws JSONException 
	{
		for(int i=0;i<object.length();i++)
		{
			startParsing(object.getJSONObject(i));
		}

	}

}

