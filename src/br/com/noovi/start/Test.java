/*
 * @Autor:Isaque Silva
 * @Dara:15/10/2020
 * @Descrição: Classe teste que inicia aplicação chamando método "deleteDmeno30"
 * */
package br.com.noovi.start;
import br.com.noovi.config.CopyPropertiesFile;
import br.com.noovi.core.FilePath;
import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
         FilePath echFile = new FilePath();
         echFile.deleteDMenos30();
    }
}






