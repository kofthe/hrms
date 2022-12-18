package com.mehmetari.hrms.entity;

public enum GeneralJobPosition {
    JAVA_DEVELOPER("java developer"),
    REACT_DEVELOPER("react-developer"),
    OGRETMEN("öğretmen");

    private final String positions;

    private GeneralJobPosition(String positions) {
        this.positions = positions;
    }

    public String getPositions(){
        return positions;
    }
}
