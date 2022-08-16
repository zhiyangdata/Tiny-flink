package org.team3090.framework;

import java.util.List;

/**
 * @BelongsProject: Tiny-flink
 * @BelongsPackage: org.team3090.framework
 * @Author: Zhiyang Zhu
 * @CreateTime: 2022-08-09  02:34
 * @Description:
 * @Version: 1.0
 * <T> The type of the elements in this stream.
 */
public class DataStream<T> {
    StreamExecutionEnvironment env;
    Transformation transformation;

//    public <R> SingleOutputStreamOperator<T> map(MapFunction<T, R> mapper) {
////        return
//    }
}
