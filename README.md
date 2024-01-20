# AdWebStart
Snippet for creating web application with SpringBoot as a web server
that exposes REST API and utilizes PostgreSQL as a database engine.
React with TypeScript is provided as an user interface.

## Requirements

- java
- docker

## Installation

### Build docker images

#### Build adwebstart server docker image

1. Build server
```shell
$ cd adwebstart-server
$ mvn clean install
```

2. Build container
```shell
$ cd adwebstart-host/adwebstart-server
$ docker build . -t adwebstart-server
```

#### Build database docker image

```shell
$ cd adwebstart-host/adwebstart-db
$ docker build . -t adwebstart-db
```

#### Build frontend docker image

```shell
$ cd adwebstart-host/adwebstart-webapp
$ docker build . -t adwebstart-webapp
```

### Compose containers from previously created images
```shell
$ cd adwebstart-host
$ docker-compose -f docker-compose.yml up -d
```

## Running

Open your favorite browser and navigate to:
```shell
http://localhost:3000
```

## Troubleshooting

#### Check if all components are running within their containers.
1. adwebstart-server (springboot application) on port: 9000
2. adwebstart-db (postgresql server) on port: 2345
3. adwebstart-webapp (react app) on port: 3000

You may use telnet:
```shell
$ telnet localhost 9000
```

#### Check logs of adwebstart-server
```shell
$ docker ps
$ docker exec -it [container_id_of_adwebstart_server] bash
$ cat adwebstart.log
```

