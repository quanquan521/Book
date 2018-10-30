package com.hpw.mvpframe.base;

import com.hpw.mvpframe.data.repository.Repository;

/**
 *   xml  仓库
 */

public class CoreBaseRepository {
    @Override
    public Object clone() {
        Repository stu = null;
        try {
            stu = (Repository) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return stu;
    }
}
