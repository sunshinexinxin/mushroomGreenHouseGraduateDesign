package com.hbkd.hyx.app.sence.bean;

/**
 * Created by anke on 2017/5/1.
 */
public class ChartsCollectionBean {
    private String idno;
    private String mushroomPointid;
    private String mushroomAirtemp;
    private String mushroomAirhumidity;
    private String mushroomSoiltemp;
    private String mushroomSoilmoisture;
    private String mushroomIghtintensity;
    private String mushroomCo2densuty;
    private String memo;
    private String ctime;

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getMushroomPointid() {
        return mushroomPointid;
    }

    public void setMushroomPointid(String mushroomPointid) {
        this.mushroomPointid = mushroomPointid;
    }

    public String getMushroomAirtemp() {
        return mushroomAirtemp;
    }

    public void setMushroomAirtemp(String mushroomAirtemp) {
        this.mushroomAirtemp = mushroomAirtemp;
    }

    public String getMushroomAirhumidity() {
        return mushroomAirhumidity;
    }

    public void setMushroomAirhumidity(String mushroomAirhumidity) {
        this.mushroomAirhumidity = mushroomAirhumidity;
    }

    public String getMushroomSoiltemp() {
        return mushroomSoiltemp;
    }

    public void setMushroomSoiltemp(String mushroomSoiltemp) {
        this.mushroomSoiltemp = mushroomSoiltemp;
    }

    public String getMushroomSoilmoisture() {
        return mushroomSoilmoisture;
    }

    public void setMushroomSoilmoisture(String mushroomSoilmoisture) {
        this.mushroomSoilmoisture = mushroomSoilmoisture;
    }

    public String getMushroomIghtintensity() {
        return mushroomIghtintensity;
    }

    public void setMushroomIghtintensity(String mushroomIghtintensity) {
        this.mushroomIghtintensity = mushroomIghtintensity;
    }

    public String getMushroomCo2densuty() {
        return mushroomCo2densuty;
    }

    public void setMushroomCo2densuty(String mushroomCo2densuty) {
        this.mushroomCo2densuty = mushroomCo2densuty;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        return "ChartsCollectionBean{" +
                "idno='" + idno + '\'' +
                ", mushroomPointid='" + mushroomPointid + '\'' +
                ", mushroomAirtemp='" + mushroomAirtemp + '\'' +
                ", mushroomAirhumidity='" + mushroomAirhumidity + '\'' +
                ", mushroomSoiltemp='" + mushroomSoiltemp + '\'' +
                ", mushroomSoilmoisture='" + mushroomSoilmoisture + '\'' +
                ", mushroomIghtintensity='" + mushroomIghtintensity + '\'' +
                ", mushroomCo2densuty='" + mushroomCo2densuty + '\'' +
                ", memo='" + memo + '\'' +
                ", ctime='" + ctime + '\'' +
                '}';
    }
}
