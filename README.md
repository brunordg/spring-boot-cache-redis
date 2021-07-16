![GitHub](https://img.shields.io/github/license/brunordg/spring-boot-cache-redis)
![GitHub top language](https://img.shields.io/github/languages/top/brunordg/spring-boot-cache-redis)

# Spring Boot com Redis
### Como o cache pode ajudar na performance das suas consultas

O cache normalmente é aplicado para otimizar algum tipo de acesso a dados, ou seja, a informação é armazenada em memória não sendo necessário a busca em um banco de dados ou serviço, melhorando a performance e evitando fazer requisições repetidas, onde normalmente são requisições bem custosas.

Com a evolução das aplicações, com a necessidade de escalabilidade e múltiplas instâncias veio a necessidade da implementação de um cache distribuído entre elas, com a possibilidade de inserir ou invalidar a informação do cache através de todas as instâncias para que a informação seja concreta e a mesma em todos os lugares.

Para este exemplo vamos utilizar uma aplicação criada em Spring Boot, Redis, Docker e o H2 um banco de dados em memória para facilitar o nosso exemplo.

![alt text](https://cdn-images-1.medium.com/max/800/1*kweAChrF5o0hO83KK2fQHQ.png)

Para evitar a instalação do Redis em nossa máquina vamos utilizar uma imagem do Docker, para executar o redis devemos executar o seguinte comando no seu terminal, tendo em vista que você já tenha o Docker instalado na sua máquina.

```
docker run -d --name redis -p 6379:6379 redis:5.0.3
```


