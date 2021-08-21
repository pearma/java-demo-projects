功能说明：
1. 本代码演示了2个功能。
  1.1 借助spring integration ，实现了http get功能
  1.2 实现了对大文件的压缩打包功能


使用方法：

```bash
curl http://localhost:8080/welcome/username
```
访问上述endpoint，会返回欢迎词，同时会触发压缩打包功能，会将test目录下的文件打包成test.tar.gz
