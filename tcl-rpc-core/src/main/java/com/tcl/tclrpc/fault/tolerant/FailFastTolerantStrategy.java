package com.tcl.tclrpc.fault.tolerant;


import com.tcl.tclrpc.model.RpcResponse;

import java.util.Map;

/**
 * 快速失败 - 容错策略（立刻通知外层调用方）
 *
 */
public class FailFastTolerantStrategy implements TolerantStrategy {

    @Override
    public RpcResponse doTolerant(Map<String, Object> context, Exception e) {
        System.out.println("failfast");
        throw new RuntimeException("服务报错", e);
    }
}
