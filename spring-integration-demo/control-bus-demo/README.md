# 项目介绍
### 项目开发人员
* 作者： Victor Ma
* 开发日期： 2021-05-16

### 项目功能
项目的主要功能包括以下内容

* 实现通过xml定义spring integration channel
* 实现了通过control-bus channel对其他channel的控制。
* 实现了对测试结果日志的输出控制。通过提供专门的logback-test.xml，来将多余的日志全部抑制，仅显示我需要的结果。
* 实现了不用springboottest注解的测试。使用springboottest注解，会加载过多的context，从而导致测试变慢。

### 使用方法
通过一下命令可以体验本项目的功能:

* 运行本程序
```bash
    > gradle clean test
```
