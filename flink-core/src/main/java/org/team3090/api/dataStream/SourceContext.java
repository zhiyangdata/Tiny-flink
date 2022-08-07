package org.team3090.api.dataStream;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @BelongsProject: Tiny-flink
 * @BelongsPackage: org.team3090.api.dataStream
 * @Author: Zhiyang Zhu
 * @CreateTime: 2022-08-04  03:04
 * @Description:
 * @Version: 1.0
 */
public class SourceContext<T> {
    private BlockingDeque<T> buffer;
    public SourceContext(){
        buffer=new LinkedBlockingDeque<>();
    }
    public void collect(T message){
        buffer.offer(message);
    }
    public T read(){
        return buffer.poll();
    }
}
