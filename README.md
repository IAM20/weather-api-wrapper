# Weather-api-wrapper

```java
NewSky sky = new NewSkyBuilder()
		.setServiceKey("i2QEyuG9Dm77T723wkamJtWz2dpjS%2FDWi%2BatGI67oBWe47rG8A%3D%3D")
		.setNx(60)
		.setNy(127)
		.build();
ForecastGrib grib = sky.forecastGrib();
List<ForecastSpaceData> spaceData = sky.forecastSpaceData();
List<ForecastTimeData> timeData = sky.forecastTimeData();
```

> This is library of open weather api in Republic of Korea
> The API is from http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2

<p align=center>
<a target="_blank"><img src="https://img.shields.io/badge/build-passing-green.svg"></a>
<a target="_blank" href="http://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html" title="java version"><img src="https://img.shields.io/badge/java-11-green.svg"></a>
</p>

------------
### You can add as maven dependency
```xml
<dependencies>
    <dependency>
        <groupId>com.github.iam20</groupId>
        <artifactId>weather-api-wrapper</artifactId>
        <version>0.0.1</version>
    </dependency>
</dependencies>
```

### General usage
First you must make newsky object. every member has default value except service key.
But I recommend you to set nx and ny value.

```JAVA
NewSky sky = new NewSkyBuilder()
	.setServiceKey("YourServiceKey")
	.nx(60)
	.ny(127)
	.build();
```

Now it's done!
If you want to call forecastGrib just call api method `ForecastGrib`
```JAVA
ForecastGrib grib = sky.forecastGrib();
```

Method `ForecastSpaceData`
```JAVA
ForecastSpaceData spaceData = sky.forecastSpaceData();
```

Method `ForecastTimeData`
```JAVA
ForecastTimeData timeData = sky.forecastTimeData();
```

------------
### Dependencies
> JAVA 11 or more

### Build
```shell
$ mvn clean install
```

------------