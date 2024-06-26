# Overview

This project contains the different versions of how to load a heavy in-memory structure in your Spring application.
It is meant as a companion to the blog post [here](https://devflection.com/posts/2024-06-06-lookup-structure/).

## Description

This project is implemented in two branches representing the two options we discuss in the blog of when to initialize a lookup structure in a Java application.
One branch represents the on-request model, the other on-startup model.
To start either application you can do

```bash
./mvnw spring-boot:run
```

or if you are on a Windows machine

```bash
./mvnw.cmd spring-boot:run
```
