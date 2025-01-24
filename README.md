# XxlJob兼容SpringBoot3 Native的示例

## 一、Admin

> 已支持Aot

**主要是是以下4点**

- 1.jakarta.annotation.Resource不是Spring标准的枚举，所以需要改用org.springframework.beans.factory.annotation.Autowired
- 2.MyBatis需要引用MyBatisNativeConfiguration
- 3.所有resources下的文件需要register以此保留，具体看AdminAotHints
- 4.所有需要参与反射的类，包括最后被freemarker所使用的类，都需要在reflection中注册，具体看AdminAotHints

## 二、Core

> 已支持Aot

**主要是是以下2点**

- 1.rpc Json解析类支持反射
- 2.XxlJob注解方法支持反射调用

## 三、Image

- SpringBoot 创建自带DockerImage插件`mvn -DskipNativeBuild=true spring-boot:build-image`
  - image-jvm.sh
- Native打包使用命令`mvn -Pnativ spring-boot:build-image`
  - image-native.sh
- 如果要使用OracleGraalVM打包并且想支持G1使用命令`mvn -Pnativ,oracle spring-boot:build-image`
  - image-native-oracle.sh
  - **需要注意G1只支持Linux [MemoryManagement](https://www.graalvm.org/latest/reference-manual/native-image/optimizations-and-performance/MemoryManagement/)**

## 四、Run

```shell
docker run --user root -p 8080:8080 \
  -e DB_URL="XxlJobDB地址" \
  -e DB_NAME="DB名称" \
  -e DB_PWD="DB密码" \
  com.xxl.job/xxl-job-admin:3.0.0
```

> 如果是OracleGraalVM使用`com.xxl.job/xxl-job-admin:3.0.0-oracle`