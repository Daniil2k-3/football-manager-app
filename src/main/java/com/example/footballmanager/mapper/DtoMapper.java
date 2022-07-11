package com.example.footballmanager.mapper;

public interface DtoMapper<R, E, M> {
    R toDto(M o);

    M toModel(E o);
}
