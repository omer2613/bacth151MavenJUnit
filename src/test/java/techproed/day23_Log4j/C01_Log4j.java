package techproed.day23_Log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class C01_Log4j {

    @Test
    public void log4j() {
        /*
        Log4j system.out.println gibi her test adiminda bilgilendirme yapmamiza yarayan bir api dir.
        Log4j ile bu bilgilendirmeleri hem konsolda tarih saat olarak hem de src>main>resources icine
         koydugumuz log4j.xml file da belirttigimiz .log uzantili doyada yine tarih-saat olrak kayit altina almis olacagiz.
         Log4j kullanabilmek icin oncelikle log4j.api ve log4j.core dependency lerini mavenrepostory.com adresinden
         ayni versiyonlar olacak sekilde pom.xml dosyasina koymaliyiz
         src>main>resources icine koydugumuz log4j.xml dosyasindaki kodlra pdf deki adresten ulasabilirsiniz.

         */
        /*Root level kismina "DEBUG"  yazarsak ==> konsolda hepsi
        "INFO" yazarsak ==> debug haric hepsi
        "ERROR" yazarsak ==> error ve fatal gorunur*/

        Logger logger= LogManager.getLogger(C01_Log4j.class);
        logger.info("INFO");
        logger.debug("DEBUG");
        logger.error("ERROR");
        logger.fatal("FATAL");
        logger.warn("WARNİNG");

    }
}
