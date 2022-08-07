package org.team3090.api.source;

import org.team3090.api.dataStream.SourceContext;

/**
 * @BelongsProject: Tiny-flink
 * @BelongsPackage: org.team3090.api.source
 * @Author: Zhiyang Zhu
 * @CreateTime: 2022-08-04  03:00
 * @Description:
 * @Version: 1.0
 */
public class KafkaSource<T> implements SourceFunction{
    private boolean flag = true;

    public void run(SourceContext sourceContext) {
        while (flag) {
            //内部读取kafka数据，并写到阻塞队列中，并发度为1
            T message = null;
            sourceContext.collect(message);
        }
    }

    public void cancel() {
        flag = false;
    }
}
