package com.dedun.converter;

import java.util.function.Supplier;

public abstract class JobEntityConverter<Entity,Response> {
    private final Supplier<Response> supplier;

    protected JobEntityConverter(Supplier<Response> supplier) {
        this.supplier = supplier;
    }

    public Response from(Entity entity) {
        return inflateResponse(entity, supplier.get());
    }

    protected abstract Response inflateResponse(Entity entity, Response response);
}
