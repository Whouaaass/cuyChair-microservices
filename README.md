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

## Más sobre el proyecto
[Backlog en Taiga](https://tree.taiga.io/project/julianmunoz-ingenieria-de-software-proyecto/)  
[Documentación hexagonal](https://docs.google.com/document/d/1NJrGFLo4_dWvO4RC3BdVi6tiEJbnImug/edit)  
[Diagrama de paquetes hexagonal](https://app.diagrams.net/#G1fqbP_FE2RKIUxI1XD1DA8pxBNTMlGSHl#%7B%22pageId%22%3A%22veiKcmJNPC1lriJcASmx%22%7D)  
[Diagrama de contexto y contenedores](https://app.diagrams.net/#G1Iy7UcD2-vUqZlGaul9AM26uHsfjHpcMv#%7B%22pageId%22%3A%22ViGfiyizJ6LLW8R1jasp%22%7D)  
[Diagrama de bounded context de microservicios](https://app.diagrams.net/#G1FY6b9xRI23bshFKl-4m459JFAv-3c7Pa#%7B%22pageId%22%3A%22ApDRb7ci62jY-3dptMDl%22%7D)  
[Link del video]()

