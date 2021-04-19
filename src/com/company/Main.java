package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Processor processor = new Processor();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido a la agenda");
        System.out.println("Donde se encuentra la ruta del archivo de la agenda?");
        String archivo = scanner.nextLine();
        String option = "0";

        while (!option.equals("6")){
            option = menu();
            if (option.equals("1")) {
                processor.leerArchivo(archivo);
                System.out.println("El archivo se cargo correctamente");
            } else if(option.equals("2")) {
                processor.guardarAgenda(archivo);
            } else if(option.equals("3")) {
                System.out.println("Nombre:");
                String name = scanner.nextLine();
                System.out.println("Apellido:");
                String surname = scanner.nextLine();
                System.out.println("Email:");
                String email = scanner.nextLine();
                processor.guardarContacto(name, surname, email);
            } else if(option.equals("4")) {
                System.out.println("Email:");
                String email = scanner.nextLine();
                processor.borrarContacto(email);
            } else if(option.equals("5")) {
                processor.getContacts().forEach(contact -> {
                            System.out.println(contact);
                        }
                );
            } else if (option.equals("6")){
                System.exit(0);
            }

        }
    }
    public static String menu (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------");
        System.out.println("1- Cargar archivo");
        System.out.println("2- Guardar agenda");
        System.out.println("3- Agregar contacto");
        System.out.println("4- Borrar contacto");
        System.out.println("5- Mostrar agenda");
        System.out.println("6- Salir");
        String option = scanner.nextLine();
        return option;
    }
}
