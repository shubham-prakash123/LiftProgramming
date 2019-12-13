package com.example.liftprogramming;

public class FloorDetails {

    private int floorNo;

    private boolean isCurrentFloor;

    public FloorDetails(int floorNo, boolean isCurrentFloor) {
        this.floorNo = floorNo;
        this.isCurrentFloor = isCurrentFloor;
    }

    public boolean isCurrentFloor() {
        return isCurrentFloor;
    }

    public void setIsCurrentFloor(boolean isCurrentFloor) {
        this.isCurrentFloor = isCurrentFloor;
    }

    public int getFloorNo() {
        return floorNo;
    }
}
