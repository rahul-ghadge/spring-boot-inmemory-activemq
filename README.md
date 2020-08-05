# spring-boot-inmemory-activemq
Spring boot in memory ActiveMQ demo application


> GET request - http://localhost:8080/message/Good%20Morning
```
2020-03-29 15:24:27.206  INFO 9560 --- [nio-8080-exec-1] c.a.d.p.controller.ProducerController    : Inside ProducerController::sendTextMessage()  
2020-03-29 15:24:27.206  INFO 9560 --- [nio-8080-exec-1] c.a.d.p.controller.ProducerController    : Sending Message :: Good Morning   
2020-03-29 15:24:27.210  INFO 9560 --- [nio-8080-exec-1] c.a.d.p.controller.ProducerController    : Message sent successfully...!
2020-03-29 15:24:27.211  INFO 9560 --- [enerContainer-1] c.a.d.p.controller.ListenerController    : Inside ListenerController::getMessage()

Received Message : Good Morning

2020-03-29 15:24:27.213  INFO 9560 --- [enerContainer-1] c.a.d.p.controller.ListenerController    : Received Message : Good Morning
```

> POST request - http://localhost:8080/superhero

Request body: 
```
{ 
  "name": "Wade", 
  "superName": "Deadpool", 
  "profession": "Street fighter", 
  "age": 28, 
  "canFly": false }  
```

```
2020-03-29 15:24:43.667  INFO 9560 --- [nio-8080-exec-2] c.a.d.p.controller.ProducerController    : Inside ProducerController::sendObjectMessage()   
2020-03-29 15:24:43.667  INFO 9560 --- [nio-8080-exec-2] c.a.d.p.controller.ProducerController    : Sending Message :: SuperHero [name=Wade, superName=Deadpool, profession=Street fighter, age=28, canFly=false]  
2020-03-29 15:24:43.673  INFO 9560 --- [nio-8080-exec-2] c.a.d.p.controller.ProducerController    : Message sent successfully...!  
2020-03-29 15:24:43.675  INFO 9560 --- [enerContainer-1] c.a.d.p.controller.ListenerController    : Inside ListenerController::getMessage()   

Received Message : {"name":"Wade","superName":"Deadpool","profession":"Street fighter","age":28,"canFly":false}  

2020-03-29 15:24:43.675  INFO 9560 --- [enerContainer-1] c.a.d.p.controller.ListenerController    : Received Message : {"name":"Wade","superName":"Deadpool","profession":"Street fighter","age":28,"canFly":false}  
Super Hero : SuperHero [name=Wade, superName=Deadpool, profession=Street fighter, age=28, canFly=false]  
2020-03-29 15:24:43.676  INFO 9560 --- [enerContainer-1] c.a.d.p.controller.ListenerController    : Super Hero : SuperHero [name=Wade, superName=Deadpool, profession=Street fighter, age=28, canFly=false]  
```

![Alt text](https://github.com/rahul-ghadge/spring-boot-inmemory-activemq/blob/master/src/main/resources/static/InMemoryActiveMQOutput.PNG?raw=true "In Memory ActiveMQ Output")
