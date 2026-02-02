package model;

public class BoardLocation {
    private String locationName;
    private int location;

    public BoardLocation(String locationName, int location) {
        this.locationName = locationName;
        this.location = location;
    }

    //Getters and Setters
    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    //ToString
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BoardLocation{");
        sb.append("locationName='").append(locationName).append('\'');
        sb.append(", location=").append(location);
        sb.append('}');
        return sb.toString();
    }
}

