# spring-boot集成dubbo

### 参考官方整合示例
1. 参考官方示例https://github.com/apache/incubator-dubbo-spring-boot-project/tree/0.1.0

2. 这里并没有参考最新的0.2.0版本，因为该版本要求spring-boot2.0.x

3. 所以使用0.1.0版本，该版本支持spring-boot1.5.x，我们项目spring-boot用的是1.5.1.RELEASE

4. 找到dubbo-spring-boot-samples例子，就能成功启动

5. 注意并没有使用zookeeper，因此无需启动zookeeper

### 注意
因为dubbo-spring-boot-starter项目从2018年1月份才开始维护，好多地方还没有完善，因此初次整合，再因为网上关于这方面的内容比较少，存在的也不一定能跑同，所以刚开始踩了好多坑。2018年5月18日16:54:54。