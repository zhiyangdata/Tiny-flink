package org.team3090.simple.Driver;

/**
 * @BelongsProject: Tiny-flink
 * @BelongsPackage: org.team3090.simple.Driver
 * @Author: Zhiyang Zhu
 * @CreateTime: 2022-08-19  03:21
 * @Description: 算子包装类，用于启动算子的配置
 * @Version: 1.0
 */
public class Operator {
//
    String name;
    String opFunc;

    int parallelism;
//    向上游读取数据的key,默认为name_并行度顺序

    String readKey;
//    下游节点的并行度，防止rebalance
    int writeParallelism;
    public Operator(String name, String opFunc, int parallelism) {
        this.name = name;
        this.opFunc = opFunc;
        this.parallelism = parallelism;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "name='" + name + '\'' +
                ", opFunc='" + opFunc + '\'' +
                ", parallelism=" + parallelism +
                ", readKey='" + readKey + '\'' +
                ", writeParallelism=" + writeParallelism +
                '}';
    }
}
