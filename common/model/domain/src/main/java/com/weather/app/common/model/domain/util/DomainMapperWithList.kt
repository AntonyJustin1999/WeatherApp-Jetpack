package com.weather.app.common.model.domain.util

interface DomainMapperWithList<T,DomainModel>:DomainMapper<T,DomainModel> {
    fun toDomainList(initial: List<T>): List<DomainModel>

    fun fromDomainList(initial: List<DomainModel>): List<T>
}