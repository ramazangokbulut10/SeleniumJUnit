package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void test01() {

        System.out.println(System.getProperty("user.dir")); // bunlar dinamik
        // icinde oldugum projenin dosya yolunu(path) verir
        // C:\techpro Java\com_Batch81JUnit


        System.out.println(System.getProperty("user.home")); // bu da dinamik
        // benim bilgisayarimin bana ozel kismini verir
        // C:\Users\A

        // homePath + "/Dowlonds"

        //C:\techpro Java\com_Batch81JUnit
        //C:\techpro Java\com_Batch81JUnit\src\test\java\day05_JUnit

        // Masa ustunuzdeki text dosyasinin varligini test edin
          // "C:\Users\A\Desktop\text.txt"
        String dosyaYolu=System.getProperty("user.home")+ "\\Desktop\\text.txt"; // bu kod dinamik oldu her pc de calisir
        System.out.println(dosyaYolu);

        /*
        Bilgisayarimizdaki bir dosyanin varligini test etmemiz icin
        once o dosyaya ulasmamiz gerekir
        Java'da dosyaya erisim icin dosya yoluna (path) ihtiyac vardir
        Her bilgisayarin kullanici adi farkli olacagindan
        masaustu dosya yolu da birbirinden farkli olacaktir
        Testlerimizin tum bilgisayarlarda calismasi icin dosya yolunu DINAMIK yapmak zondayiz

        Bunun icin
        her bilgisayarin birbirinden farkli olan yolunu bulmak icin
         */
        String farkliKisim =System.getProperty("user.home");

        // herkesin bilgisayarinda ortak olan kisim
        String ortakKisim = "\\Desktop\\text.txt";
        // mac icin "/Desktop/text"

        String masaustuDosyaYolu = farkliKisim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(masaustuDosyaYolu)));
                   // bir dosyanin masaustunde var olup olmadigini kontorl eder

    }
}
