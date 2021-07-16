#!/bin/bash
echo "Iniciando a criação do container docker"
docker run -d --name redis -p 6379:6379 redis:5.0.3
echo "Criação e start do container redis executada com sucesso"
docker container ls -a