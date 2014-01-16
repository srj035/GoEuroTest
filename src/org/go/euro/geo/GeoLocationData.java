package org.go.euro.geo;

public class GeoLocationData {
	
	public final String POS_TYPE = "_type";
	public final String POS_ID = "_id";
	public final String NAME = "name";
	public final String LOC_TYPE = "type";
	public final String LATITUDE = "latitude";
	public final String LONGITUDE ="longitude";
	public final String GEO_POS ="geo_position";
	
	
	private String posType;
	public String getPosType() {
		return posType;
	}
	public void setPosType(String posType) {
		this.posType = posType;
	}
	public int getPoId() {
		return poId;
	}
	public void setPoId(int poId) {
		this.poId = poId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocType() {
		return locType;
	}
	public void setLocType(String locType) {
		this.locType = locType;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	private int poId;
	private String name;
	private String locType;
	private double latitude;
	private double longitude;
	
	public boolean isObjectEmpty()
	{
		if(posType == null && poId == 0 && name == null
			&&
			locType == null && latitude == 0.00 && longitude == 0.00)
		{
			return true;
		}
		return false;
	}
	
	

}
