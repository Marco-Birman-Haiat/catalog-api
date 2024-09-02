package com.marcohaiat.catalog_api.utils.idGenerator;

import java.math.BigInteger;

public class CounterIdGenerator implements IdGenerator {
    private BigInteger counter = BigInteger.valueOf(0);

    @Override
    public String getNewId() {
        String newId = counter.toString();
        this.counter = this.counter.add(BigInteger.valueOf(1));
        return newId;
    }
}
