package org.team3090.api.operators;

import java.io.Serializable;

//最小执行单元
public interface StreamOperator extends Serializable {
    void open();
    void close();
    void dispose();
}
