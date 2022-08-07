package org.team3090.api.common.funcImpl;

import org.team3090.api.common.Collect;

/**
 * @BelongsProject: Tiny-flink
 * @BelongsPackage: org.team3090.api.common.funcImpl
 * @Author: Zhiyang Zhu
 * @CreateTime: 2022-08-04  03:28
 * @Description:
 * @Version: 1.0
 */
public class MapFunction<T,O> {
    public void map(T value, Collect<O> collect){
        //转化逻辑
        collect.collect((O)value);
    }
}
