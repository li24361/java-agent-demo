# java-agent-demo

一个字节码增强的小demo

## 使用方法
首先打包

> mvn assembly:assembly
target/下面会生成java-agent-demo-1.0-SNAPSHOT-jar-with-dependencies.jar

运行方法:
### premain jvm 参数形式启动，运行此方法
启动参数需要添加 -javaagent:{你的路径}/java-agent-demo-1.0-SNAPSHOT-jar-with-dependencies.jar
运行启动com.lzh.RunJvm#main

### agentmain 动态 attach 方式启动，运行此方法
启动com.lzh.RunJvm#main
jps -l
查找到 ,举例
> 1427 com.lzh.RunJvm

修改com.lzh.AttachAgent里面进行id为1427(举例,实际会不同)

启动 com.lzh.AttachAgent#main


### 参考:

* [字节码增强技术探索](https://tech.meituan.com/2019/09/05/java-bytecode-enhancement.html)
* [Java 调式、热部署、JVM 背后的支持者 Java Agent](https://www.zhihu.com/search?q=Instrument%20java&utm_content=search_history&type=content)
