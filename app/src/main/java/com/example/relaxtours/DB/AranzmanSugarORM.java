package com.example.relaxtours.DB;

import com.orm.SugarRecord;

public class AranzmanSugarORM extends SugarRecord<AranzmanSugarORM> {
    public int aranzmanid;
    public String userid;

    public AranzmanSugarORM() {
    }

    public AranzmanSugarORM(int aranzmanId, String userUID) {
        aranzmanid = aranzmanId;
        userid = userUID;
    }
}
