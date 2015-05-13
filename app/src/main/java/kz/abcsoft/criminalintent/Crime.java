package kz.abcsoft.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime {
    private UUID mId ;
    private String mTitle ;
    private Date mDate ;
    private boolean mSolved ;

    public Crime(){
        mId = UUID.randomUUID() ;
        mDate = new Date() ;
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setDate(Date newDate){
        mDate = newDate ;
    }

    public Date getDate(){
        return mDate ;
    }

    public void setSolved(boolean solved){
        mSolved = solved ;
    }

    public boolean isSolved(){
        return mSolved ;
    }

    public String toString(){
        return mTitle ;
    }
}
