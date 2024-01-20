# AdWebStart
A snippet that can be used to create a web project with SpringBoot
that exposes REST API and utilizes PostgreSQL as a database engine and
React with TypeScript that is provided as an user interface.

## Requirements

- java
- docker

## Installation

### Build docker images

#### Build adwebstart server docker image

1. Build server

```shell
$ cd adwebstart-host/adwebstart-server
$ mvn clean install
$ docker build . -t adwebstart-server
```

#### Build database docker image

```shell
$ cd adwebstart-db
$ docker build . -t adwebstart-db
```

#### Build frontend docker image

```shell
$ cd adwebstart-webapp
$ docker build . -t adwebstart-webapp
```

## Running

### Compose containers from previously created images
```shell
$ cd adwebstart-host
$ docker-compose -f docker-compose.yml up -d
```

after this step you should have three containers running:
1. adwebstart listening on port 9000
2. adwebstart-db listening on port 2345
3. adwebstart-webapp listening on port 3000

you may check with command:

```shell
$ docker ps
```

### Open your favorite browser and navigate to:
```shell
http://localhost:3000
```


