package com.bidnerdintent.android.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab  {
    private  List<Crime> mCrime;
     private static CrimeLab sCrimeLab;
    private CrimeLab(Context context){
        mCrime = new ArrayList<>();
        int i = 0;
        while(i<100 ){
            Crime crime = new Crime();
            crime.setmTitle("Crime no " + i);
            crime.setmSolved(i%2==0);
            mCrime.add(crime);
            i++;
        }
    }
    public static CrimeLab get(Context context){
        if(sCrimeLab==null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }
    public List<Crime> getCrimes(){
        return mCrime;
    }
    public Crime getCrime(UUID id){
        for(Crime crime : mCrime){
            if(crime.getmId()==id){
                return crime;
            }
        }
        return null;
    }
}
