# RewardsPoints
there is in memory db (H2) and RESTful service is developed using Spring boot
Pre-requite-site
POSTMAN is needed to test app
Java 8
IntelliJ
Maven

DB Url : http://localhost:8080/h2-console/login.jsp 
Username : sa
There is no password

Refer configuration file : resources/application.properties

Launch IntelliJ
Open project in IntelliJ
Build project using maven
Run as application RewardPointsApplication

File resources/data.sql contains ddl to insert

Endpoint:
1. get -> http://localhost:8080/1001/rewards
no body in json required

for testing used docker desktop

command will be executed from RewardsPoints folder

docker for build image : docker build -t docker-reward-point-0.0.1 .

to see all images in docker desktop not inside container : docker images

to stop docker container : control C

to run docker image : docker run -p 8080:8080 docker-reward-point-0.0.1

to see history what all included in Dockerfile : docker inspect docker-reward-point-0.0.1

enables actuator where server running or not:

management.endpoints.web.exposure.include=*
http://localhost:8080/actuator/health

swagger-ui documentation

java configuration required to enable swagger

to invoke swagger on running server : http://localhost:8080/swagger-ui/index.html

<img width="1583" alt="image" src="https://user-images.githubusercontent.com/24884750/197445071-85c3a9a9-f4b3-4d94-90f5-68511eed3589.png">

<img width="523" alt="image" src="https://user-images.githubusercontent.com/24884750/197445173-94da98ac-3d2e-4552-b029-b43dac522523.png">

<img width="497" alt="image" src="https://user-images.githubusercontent.com/24884750/197445293-bed0a64c-96d0-495c-ba52-e80e49cd7189.png">

<img width="1683" alt="image" src="https://user-images.githubusercontent.com/24884750/197445411-b64ad5f4-0218-4d88-bdde-3a1a0a174bd4.png">



