package org.team3090.api.source;

import org.team3090.api.common.Collect;
import org.team3090.api.common.function.Function;
import org.team3090.api.operators.AbstractUdfStreamOperator;

/**
 * @BelongsProject: Tiny-flink
 * @BelongsPackage: org.team3090.api.source
 * @Author: Zhiyang Zhu
 * @CreateTime: 2022-08-04  03:41
 * @Description:
 * @Version: 1.0
 */
public class StreamSource<OUT,F extends SourceFunction> extends AbstractUdfStreamOperator<OUT,F> {
    F userFunction;
    public StreamSource(F function){
        userFunction=function;
    }
    @Override
    public void open() {

    }

    @Override
    public void close() {

    }

    @Override
    public void dispose() {

    }
    public void run(Collect<OUT> collect){
//        userFunction.run(collect);
    }
}
