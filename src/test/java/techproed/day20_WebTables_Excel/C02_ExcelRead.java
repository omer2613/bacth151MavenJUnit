package techproed.day20_WebTables_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import techproed.utilities.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ExcelRead  {
    /*

     EXCEL dosyasından veri okuyabilmemiz için öncelikle pom.xml dosyamıza poi ve poi.ooxml dependency'lerini
yüklememiz gerekir.
    Sonra üzerinde çalışacağımız excel dosyasını projemizde src>test>java>techpoed>resources package'i içine
kayarız.
     */
    @Test
    public void test01() throws IOException {
        //1. -dosya yolunu aliniz.
        String dosyayolu="src/test/java/techproed/resources/Capitals.xlsx";

        //2. -dosyayi okuyabilmemiz icin javada akisa almamiz gerekir.
        FileInputStream fis= new FileInputStream(dosyayolu);

        //3. -java ortaminda bir excel dosyasi olusturabilmek icin;
        Workbook workbook= WorkbookFactory.create(fis);//--> akisa aldigimiz dosyayi okuyoruz.

        //4.-olusturdugumuz excel den sayfa yani sheet secmemiz gerekir
        Sheet sheet=workbook.getSheet("Sheet1");

        //5. -belirttigimiz sayfadaki satir(row) bilgisini secmeniz gerekir.
        Row row=sheet.getRow(0);//--> satirda index sifirdan basladigi icin 1.satiri getirir.

        //6.-Belirrtigimiz satirdaki hucreyi (cell) bilgisini secmemiz gerekir.
        Cell cell=row.getCell(0);

        //Son olarakcell bilgisini sout ile yazdirip excel deki 1. satir 1.hucredeki veriyi gorebiliriz.
        System.out.println(cell);


    }

    @Test
    public void test02() throws IOException {
        //PRATİK COZUM
        //1.satir ve 1.sutundaki bilgileri yazdiralim
        FileInputStream fis= new FileInputStream("src/test/java/techproed/resources/Capitals.xlsx");
        Workbook workbook=WorkbookFactory.create(fis);
        String satir1Sutun1=workbook.getSheet("Sheet1").getRow(0).getCell(0).toString();
        System.out.println("1. Satir 1. Sutun Bilgisi : "+satir1Sutun1);


    }

    @Test
    public void test03() throws IOException {
        //Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        FileInputStream fis= new FileInputStream("src/test/java/techproed/resources/Capitals.xlsx");
        Workbook workbook=WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(1));

        //3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        String satir3Sutun1 = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println("3. satir 1.sutun Bilgisi : "+satir3Sutun1);
        Assert.assertEquals("France",satir3Sutun1);

        //Kullanılan satır sayısın bulun
        System.out.println(workbook.getSheet("Sheet1").getPhysicalNumberOfRows());
        //NOT:getPhysicalNumberOfRows() methodu kullanilan yani ici dolu olan satirlarin sayisini verir ve index 1 den baslar.
        //sAYFADİ SATİR SAYİSİNİ BELİRTİN
        System.out.println("Sayfadaki Satir Sayisi : "+workbook.getSheet("Sheet1").getLastRowNum());
        //NOT:getLastRowNum() methodu sayfadaki satır sayısını verir ve index 0(sıfır) dan başlar

        //Ülke-Başkent şeklinde verileri yazdırın
        for (int i = 0; i < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); i++) {
            for (int j = 0; j < workbook.getSheet("sheet1").getRow(0).getPhysicalNumberOfCells(); j++) {
                System.out.print(workbook.getSheet("Sheet1").getRow(i).getCell(j)+"\t");
            }
            System.out.println();
        }

    }
}
