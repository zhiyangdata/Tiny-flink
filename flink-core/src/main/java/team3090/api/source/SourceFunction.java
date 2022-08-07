package org.team3090.api.source;

import org.team3090.api.common.function.Function;
import org.team3090.api.dataStream.SourceContext;

import java.io.Serializable;

public interface SourceFunction<T> extends Function, Serializable {
    void run(SourceContext<T> sourceContext) throws Exception;
    void cancel();
}
