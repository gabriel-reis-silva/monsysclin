/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.monsysclin.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class Log {

    public void validarLog(String texto, String tipoLog) throws IOException {
        File arquivo = new File("Log" + tipoLog + LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)) + ".txt");
        Date data = new Date();
        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }

        List<String> lista = new ArrayList<>();
        //lista.add("Fazendo um log simples");
        lista.add(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)) + " " + data.getHours() + ":" + data.getMinutes() + ": " + texto);

        Files.write(Paths.get(arquivo.getPath()), lista, StandardOpenOption.APPEND);
        System.out.println(Files.write(Paths.get(arquivo.getPath()), lista, StandardOpenOption.APPEND));
    }
}
