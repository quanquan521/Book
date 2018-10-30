package com.hpw.mvpframe.data.repository;

import com.hpw.mvpframe.base.CoreBaseRepository;

import java.util.Map;

import io.reactivex.Observable;


public abstract class Repository<T> extends CoreBaseRepository {
    public T data;

    public Map<String, String> param;

    public abstract Observable<Data<T>> getPageAt(int page);
}
