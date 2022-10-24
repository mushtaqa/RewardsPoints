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

Use postman to browse mainly below url 2 and 3

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
