package com.example.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Anotación para indicar que esta clase es una entidad JPA
@Entity(name = "Alumno")
// Anotación para especificar el nombre de la tabla en la base de datos
@Table(name = "alumno")
public class Alumno {
    // Atributos de la clase Alumno mapeados a columnas de la base de datos

    // Atributo id con anotación para ser la clave primaria autoincremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    // Atributo nombre mapeado a la columna 'nombre'
    @Column(name = "nombre")
    private String nombre;

    // Atributo apellidos mapeado a la columna 'apellidos'
    @Column(name = "apellidos")
    private String apellidos;

    // Atributo curso mapeado a la columna 'curso'
    @Column(name = "curso")
    private String curso;

    // Atributo n_asignaturas_matriculado mapeado a la columna 'n_asignaturas_matriculado'
    @Column(name = "n_asignaturas_matriculado")
    private int n_asignaturas_matriculado;

    // Atributo edad mapeado a la columna 'edad'
    @Column(name = "edad")
    private int edad;

    // Constructor con parámetros para crear instancias de Alumno
    public Alumno(String nombre, String apellidos, String curso, int n_asignaturas_matriculado, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curso = curso;
        this.n_asignaturas_matriculado = n_asignaturas_matriculado;
        this.edad = edad;
    }

    // Constructor vacío requerido por Hibernate
    public Alumno() { }

    // Getters y setters para cada atributo
    // ...

    // Método toString para representar el objeto Alumno como una cadena de texto
    @Override
    public String toString() {
        return "Alumno [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", curso=" + curso
                + ", n_asignaturas_matriculado=" + n_asignaturas_matriculado + ", edad=" + edad + "]";
    }

}
