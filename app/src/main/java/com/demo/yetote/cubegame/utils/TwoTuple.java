package com.demo.yetote.cubegame.utils;

/**
 * 二维元组
 *
 * @param <S> s
 * @param <T> t
 */
public class TwoTuple<S, T> {
    private final S s;
    private final T t;

    public S getS() {
        return s;
    }

    public T getT() {
        return t;
    }

    public TwoTuple(S s, T t) {
        this.s = s;
        this.t = t;
    }

    @Override
    public String toString() {
        return "TwoTuple{" +
                "s=" + s +
                ", t=" + t +
                '}';
    }
}
