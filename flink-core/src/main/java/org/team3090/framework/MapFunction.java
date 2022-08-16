package org.team3090.framework;

import java.io.Serializable;

/**
 * @BelongsProject: Tiny-flink
 * @BelongsPackage: org.team3090.framework
 * @Author: Zhiyang Zhu
 * @CreateTime: 2022-08-09  02:38
 * @Description:
 * @Version: 1.0
 */
public interface MapFunction<T,O> extends Function, Serializable {
    O map(T value) throws Exception;
}
