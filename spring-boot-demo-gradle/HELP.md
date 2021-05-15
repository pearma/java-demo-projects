# 项目介绍
### 项目开发人员
* 作者： Victor Ma
* 开发日期： 2021-05-15

### 项目功能
项目的主要功能包括以下内容

* 实现了对数据库的连接，演示使用的数据库是h2内存数据库，支持数据初始化，和数据插入
* 通过mybatis对数据进行访问，实现了数据查询功能
* 提供了controller服务，支持通过http get对数据进行查询
* 提供了关于多线程的演示代码，主要通过springboot的线程池管理机制和@Async注解来实现多线程功能的实现。
* 完成了部分测试代码的编写，主要是实现了集成测试的测试代码编写

### 使用方法
通过一下命令可以体验本项目的功能:

* 运行本程序
```bash
    > gradle bootRun
```

* 查询功能
```bash
    > curl http://localhost:8080/query/studentid?userid=1
    > curl http://localhost:8080/query/grade?grade=20
```
* 多线程演示
```bash
    > curl http://localhost:8080/query/mt
```

