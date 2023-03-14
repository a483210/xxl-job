cd ../
mvn clean install
cd xxl-job-admin
mvn -DskipNativeBuild=true spring-boot:build-image
docker tag com.xxl.job/xxl-job-admin:3.0.0 com.xxl.job/xxl-job-admin-jvm:3.0.0-rc1