package org.team3090.api.dataStream;


import org.team3090.api.source.Source;

/**
 * @BelongsProject: Tiny-flink
 * @BelongsPackage: org.team3090.api.dataStream
 * @Author: Zhiyang Zhu
 * @CreateTime: 2022-08-04  03:03
 * @Description: 数据源
 * @Version: 1.0
 */
public class DataStreamSource<T> extends DataStream {
    public SourceContext<T> sourceContext;
    public DataStreamSource(){
        sourceContext=new SourceContext<>();
    }
    public DataStreamSource<T> addSource(Source<T> source){
        return new DataStreamSource<>();
    }
}
