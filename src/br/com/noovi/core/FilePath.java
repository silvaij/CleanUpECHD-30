/*
 * @Autor:Isaque Silva
 * @Dara:15/10/2020
 * @Descrição: Classe FilePath n
 * */

package br.com.noovi.core;

import br.com.noovi.config.CopyPropertiesFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class FilePath {

    public FilePath() throws IOException {}

    CopyPropertiesFile prop = new CopyPropertiesFile();
    String p = prop.getPath();
    Integer dayFile = Integer.parseInt(prop.getDays());

    File startingDirectory = new File(p);
    ArrayList<File> files = new ArrayList<>();
    Long days = 0L;

    public void deleteDMenos30() throws IOException {
        if (startingDirectory.isDirectory()) {
            File[] sub = startingDirectory.listFiles();

            for (File fileDir: sub) {
                    files.add(fileDir);
            }

            for(int i=0; i < files.size(); i++) {
                // arquivos do diretório FTP ou diretorio a ser deletado
                File deleteFile = files.get(i);

                // obtenho caminho absoluto do arquivo
                Path path = Path.of(deleteFile.getAbsolutePath());

                // obetenho a data de criação
                FileTime creationTime = (FileTime)Files.getAttribute(path,"creationTime");

                Instant fileInstant = creationTime.toInstant();
                Instant now = Instant.now();
                Duration difference = Duration.between(fileInstant,now);
                days = difference.toDays();

                if(days >= dayFile) {
                    deleteFile.delete();
                    System.out.println("Arquivos deletados"+" "+deleteFile);
                }
            }
        }
    }
}