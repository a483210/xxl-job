cd ../
mvn clean install
cd xxl-job-admin
mvn -Pnative spring-boot:build-image -Ddocker-image.native=com.xxl.job/xxl-job-admin:3.0.0