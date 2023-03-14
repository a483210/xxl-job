cd ../
mvn clean install
cd xxl-job-admin
mvn -Pnative spring-boot:build-image
docker tag com.xxl.job/xxl-job-admin:3.0.0 com.xxl.job/xxl-job-admin-native:3.0.0-rc1