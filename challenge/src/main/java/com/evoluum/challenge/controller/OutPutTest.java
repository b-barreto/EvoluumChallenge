package com.evoluum.challenge.controller;

import com.evoluum.challenge.model.CidadeCustomized;
import com.evoluum.challenge.model.Regiao;
import org.springframework.http.HttpOutputMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;

@RestController
public class OutPutTest {

    String COMMA_DELIMITER = ",";
    String NEW_LINE_SEPARATOR = "\n";
    String FILE_HEADER = "idEstado,siglaEstado,regiaoNome,nomeCidade,nomeMesorregiao,nomeFormatado";

    @GetMapping("/download")
    public void getOutputStream(HttpServletResponse response) throws IOException {

        CidadeController cidadeController = new CidadeController();
        Collection<CidadeCustomized> cidadeCustomized = (ArrayList) cidadeController.listCidades();

        response.setContentType("text/csv"); // tipo do conteúdo na resposta
        response.setHeader("Content-Disposition", "attachment; filename=cidadesJ.csv");
        OutputStream output = response.getOutputStream();
        Writer writer = new OutputStreamWriter(output);
        BufferedWriter bw = new BufferedWriter(writer);

        bw.append(FILE_HEADER);

        for (CidadeCustomized cc : cidadeCustomized) {
            bw.append(NEW_LINE_SEPARATOR);
            bw.append(Long.toString(cc.getIdEstado()));
            bw.append(COMMA_DELIMITER);
            bw.append(cc.getSiglaEstado());
            bw.append(COMMA_DELIMITER);
            bw.append(cc.getRegiaoNome());
            bw.append(COMMA_DELIMITER);
            bw.append(cc.getNomeCidade());
            bw.append(COMMA_DELIMITER);
            bw.append(cc.getNomeMesorregiao());
            bw.append(COMMA_DELIMITER);
            bw.append(cc.getNomeFormatado());
            //bw.flush();
        }

        //File arquivo = new File("C:\\Datas\\Development\\Java\\EvoluumChallenge\\challenge\\cidades.csv");
        //int tamanho = (int) arquivo.length();
        // Files.copy(arquivo.toPath(), output); // escreve bytes no fluxo de saída
        //Files.createFile()
        //response.setContentLength(tamanho); // opcional. ajuda na barra de progresso


        //bw.close();
        //output.close();
        System.out.println("Rodou");
        return output;
    }
}

