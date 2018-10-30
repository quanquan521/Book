package com.hpw.mvpframe.utils.helper;

import com.hpw.mvpframe.data.entity.CoreDataResponse;
import com.hpw.mvpframe.data.net.CoreApiException;

import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import rx.Observable.Transformer;
import rx.Subscriber;

public class RxUtil {

    /**
     * 统一线程处理
     *
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<T, T> rxSchedulerHelper() {    //compose简化线程
        return new ObservableTransformer<T, T>() {
            @Override
            public Observable<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());

            }
        };
    }

    /**
     * 统一返回结果处理
     *
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<CoreDataResponse<T>, T> handleResult() {   //compose判断结果
        return new ObservableTransformer<CoreDataResponse<T>, T>() {
            @Override
            public Observable<T> apply(Observable<CoreDataResponse<T>> upstream) {
                return upstream.flatMap(new Function<CoreDataResponse<T>, Observable<T>>() {
                    @Override
                    public Observable<T> apply(CoreDataResponse<T> tCoreDataResponse) throws Exception {
                        if (tCoreDataResponse.getCode() == 200) {
                            return createData(tCoreDataResponse.getData());
                        } else {
                            return Observable.error(new CoreApiException(tCoreDataResponse.getMsg()));
                        }
                    }
                });
            }
        };
    }

    /**
     * 生成Observable
     *
     * @param <T>
     * @return
     */
    public static <T> Observable<T> createData(final T t) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> e){
                try {
                    e.onNext(t);
                    e.onComplete();
                } catch (Exception e1) {
                    e.onError(e1);
                }
            }
        });
    }
}
