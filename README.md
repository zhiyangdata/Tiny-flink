# Tiny-flink
本项目计划实现一个简易的分布式流式计算系统
# 参与人
陈思芹，郝杰，马明川，王胜，杨昌安，朱志阳
# 模块说明
fink-core模块为数据流图建设的探索

flink-verification模块为技术选型验证，请大家将之前验证的代码已经说明文档合并进这个模块
包名为org.team3090.rpc-jars

# 项目模块
## Driver
1. 配置文件格式
2. 解析配置文件
3. 生成json
4. 实例化ExecutorClient,BlockManagerMaster
5. ExecutorService.BlockManager注册ip host
6. Driver.submitJob(//jar传过去)
7. ExecutorClient.submitJob
## Worker
1. ExecutorService启动，监听端口
2. 实例化ExecutorService.BlockManagerService 并向Driver注册
3. 处理ExecutorClient.submitJob请求
4. 运行task