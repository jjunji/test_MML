package com.jjunji.android.test_mml.model;

/**
 * Created by jhjun on 2018-02-27.
 */

public class MovieList {
    peopleListResult peopleListResult;

    public class peopleListResult{
        int totCnt;
        String source;
        peopleList[] peopleList;
    }

    public class peopleList{
        String peopleCd;
        String peopleNm;
        String peopleNmEn;
        String repRoleNm;
        String filmoNames;
    }
}
