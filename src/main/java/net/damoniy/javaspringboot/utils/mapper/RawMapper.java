package net.damoniy.javaspringboot.utils.mapper;

public interface RawMapper<T, U> {
    U map(T t);
}
