package com.yzq.mvpframe.data.repository;

import com.yzq.mvpframe.base.CoreBaseRepository;

import java.util.Map;

import io.reactivex.Observable;


public abstract class Repository<T> extends CoreBaseRepository {
    public T data;

    public Map<String, String> param;

    public abstract Observable<Data<T>> getPageAt(int page);
}
