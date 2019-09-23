# java-agent-demo

运行方法:
### premain jvm 参数形式启动，运行此方法
启动参数需要添加 -javaagent:/Users/lizhihao/code/java-agent-demo/target/java-agent-demo-1.0-SNAPSHOT-jar-with-dependencies.jar
运行启动com.lzh.RunJvm#main

### agentmain 动态 attach 方式启动，运行此方法
启动com.lzh.RunJvm#main
jps -l
查找到 ,举例
> 1427 com.lzh.RunJvm

修改com.lzh.AttachAgent里面进行id为1427(举例,实际会不同)

启动 com.lzh.AttachAgent#main
