package com.hbkd.hyx.app.sence.bean;

/**
 * Created by anke on 2017/4/22.
 */
//大棚 bean
public class Monitor {

    private String idno;
    private String mushroomPointid;
    private String mushroomName;
    private String userId;
    private String mushroomDesc;
    private String mushroomStatus;
    private String mushroomLong;
    private String mushroomLat;
    private String delFlag;
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

    public String getMushroomName() {
        return mushroomName;
    }

    public void setMushroomName(String mushroomName) {
        this.mushroomName = mushroomName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMushroomDesc() {
        return mushroomDesc;
    }

    public void setMushroomDesc(String mushroomDesc) {
        this.mushroomDesc = mushroomDesc;
    }

    public String getMushroomStatus() {
        return mushroomStatus;
    }

    public void setMushroomStatus(String mushroomStatus) {
        this.mushroomStatus = mushroomStatus;
    }

    public String getMushroomLong() {
        return mushroomLong;
    }

    public void setMushroomLong(String mushroomLong) {
        this.mushroomLong = mushroomLong;
    }

    public String getMushroomLat() {
        return mushroomLat;
    }

    public void setMushroomLat(String mushroomLat) {
        this.mushroomLat = mushroomLat;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
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
        return "Monitor{" +
                "idno='" + idno + '\'' +
                ", mushroomPointid='" + mushroomPointid + '\'' +
                ", mushroomName='" + mushroomName + '\'' +
                ", userId='" + userId + '\'' +
                ", mushroomDesc='" + mushroomDesc + '\'' +
                ", mushroomStatus='" + mushroomStatus + '\'' +
                ", mushroomLong='" + mushroomLong + '\'' +
                ", mushroomLat='" + mushroomLat + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", memo='" + memo + '\'' +
                ", ctime='" + ctime + '\'' +
                '}';
    }
}
