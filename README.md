# Sistema de Gestión de Biblioteca

Aplicación de consola en Java para gestionar libros, usuarios y préstamos de una biblioteca. Desarrollada aplicando principios de Programación Orientada a Objetos.

---

## Funcionalidades

- Registro de libros (título, autor, disponibilidad)
- Registro de usuarios: estudiantes y profesores
- Préstamo de libros con validación de:
  - Disponibilidad del libro
  - Límite de préstamos por tipo de usuario
- Devolución de libros
- Listado de libros, usuarios y préstamos

---

## Reglas de negocio

- Los **estudiantes** pueden tener hasta **3 préstamos** por **7 días**.
- Los **profesores** pueden tener hasta **5 préstamos** por **14 días**.
- Un libro no puede prestarse si ya está prestado.

---

## Tecnologías

- **Java 17**
- **Programación Orientada a Objetos**
  - Herencia (`Usuario` → `Estudiante`, `Profesor`)
  - Clase abstracta (`Usuario`)
  - Polimorfismo (métodos `limitePrestamos()` y `diasPrestados()`)
  - Encapsulación con validaciones
- **Colecciones** (`ArrayList`)
- **Fechas** (`LocalDate`)
- **Manejo de excepciones** (`IllegalArgumentException`, `IllegalStateException`)

---

## Estructura del proyecto

```
src/
├── app/                # Punto de entrada
│   └── Main.java
├── modelo/             # Clases del dominio
│   ├── Usuario.java
│   ├── Estudiante.java
│   ├── Profesor.java
│   ├── Libro.java
│   └── Prestamo.java
└── servicio/           # Lógica de negocio
    └── Biblioteca.java
```

---

## Cómo ejecutar

1. Clona el repositorio:

```bash
git clone https://github.com/ErickSanz1/biblioteca-java.git
```

2. Abre el proyecto en tu IDE favorito (IntelliJ, VS Code, Eclipse).

3. Compila y ejecuta la clase `Main`.

---

## Ejemplo de uso

```
╔══════════════════════════════╗
║     SISTEMA BIBLIOTECA       ║
╠══════════════════════════════╣
║ 1. Agregar libro             ║
║ 2. Agregar estudiante        ║
║ 3. Agregar profesor          ║
║ 4. Prestar libro             ║
║ 5. Devolver libro            ║
║ 6. Ver libros                ║
║ 7. Ver usuarios              ║
║ 8. Ver préstamos             ║
║ 0. Salir                     ║
╚══════════════════════════════╝
```

---

## Autor

**Erick Josue Sanchez Lizana**

- GitHub: [@ErickSanz1](https://github.com/ErickSanz1)
- Email: erick.slizana@gmail.com