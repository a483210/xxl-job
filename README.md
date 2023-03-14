# XxlJob兼容SpringBoot3 Native的示例

## 一、Admin

> 目前Admin已升级到SpringBoot3，但是未兼容Native，因为Mybatis目前还存在问题[#776](https://github.com/mybatis/spring-boot-starter/issues/776)

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