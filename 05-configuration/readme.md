


To refresh configuration
```
$ curl localhost:8080/actuator/refresh -d {} -H "Content-Type: application/json"
```


```
/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties

```