# CuyChair Microservices
Aplicación de cuychair pero esta vez con microservicios  

---

## Instalación
Para la instalación de los microservicios se debe de tener:
- Java JDK 21
- Docker Compose
- Make

Se debe de ejecutar el comando
```bash
make
```
con este comando se ejecutaran todos los archivos de los `mvnw` de los microservicios, lo que permitira generar archivos `.jar` de cada microservicio, para finalmente ejecutar el comando `docker compose up` para crear y ejecutar todas las imagenes de los microservicios.

Si solo se desea hacer una creacion de los microservicios, ejecutar:
```bash
make build
```

## Microservicios
- Microservicio de Usuarios
- Microservicio de Conferencias
- Microservicio de Articulos
- microservicio de revision de paper
  
## Documentación ultima entrega
[Link del video]()

[Diagrama C4](https://app.diagrams.net/#G1Iy7UcD2-vUqZlGaul9AM26uHsfjHpcMv#%7B%22pageId%22%3A%22ViGfiyizJ6LLW8R1jasp%22%7D)

[Requisitos funcionales](https://tree.taiga.io/project/julianmunoz-ingenieria-de-software-proyecto/)

[Requisitos no funcionales](https://docs.google.com/document/d/1HOp93v0lM7z1wPbofkjeh6hn_0jUgbNK/edit)

[Justificación de decisiones](https://docs.google.com/document/d/1rmaoELAfKBVflwoe3xz2owzL8wIemMekIn_zTKWYW_Q/edit?tab=t.0)

[Documentación caracteristicas de usabilidad](https://docs.google.com/document/d/1t1SPB97FQIfBaC0ebXdAZMeYV0YEodbuVYu55hysFlo/edit?tab=t.0)

[Informe Thinking aloud](https://docs.google.com/document/d/1tASSWj2--O9J28BdLxib8TeDR8qKCwGRDsKNPWjV4xI/edit?tab=t.0)

## Más sobre el proyecto
[Backlog en Taiga](https://tree.taiga.io/project/julianmunoz-ingenieria-de-software-proyecto/)  
[Documentación hexagonal](https://docs.google.com/document/d/1NJrGFLo4_dWvO4RC3BdVi6tiEJbnImug/edit)  
[Diagrama de paquetes hexagonal](https://app.diagrams.net/#G1fqbP_FE2RKIUxI1XD1DA8pxBNTMlGSHl#%7B%22pageId%22%3A%22veiKcmJNPC1lriJcASmx%22%7D)  
[Diagrama de contexto y contenedores](https://app.diagrams.net/#G1Iy7UcD2-vUqZlGaul9AM26uHsfjHpcMv#%7B%22pageId%22%3A%22ViGfiyizJ6LLW8R1jasp%22%7D)  
[Diagrama de bounded context de microservicios](https://app.diagrams.net/#G1FY6b9xRI23bshFKl-4m459JFAv-3c7Pa#%7B%22pageId%22%3A%22ApDRb7ci62jY-3dptMDl%22%7D)  
[Documentación RabbitMQ](./docs/RabbitMQ.md)  



