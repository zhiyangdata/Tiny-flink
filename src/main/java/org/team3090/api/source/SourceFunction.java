package org.team3090.api.source;

import org.team3090.api.dataStream.SourceContext;

public interface SourceFunction<T> {
    void run(SourceContext<T> sourceContext);
}
