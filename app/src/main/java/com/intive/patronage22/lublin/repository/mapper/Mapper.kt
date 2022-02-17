package com.intive.patronage22.lublin.repository.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}