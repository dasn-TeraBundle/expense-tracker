rem mvn clean package -DskipTests=true

cd eureka
docker build -t eureka .
cd ..

cd config-server
docker build -t config-server .
cd ..

cd admin-service
docker build -t admin-service .
cd ..

cd expense-service
docker build -t expense-service .
cd ..
