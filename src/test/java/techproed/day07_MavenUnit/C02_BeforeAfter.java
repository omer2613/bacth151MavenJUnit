package techproed.day07_MavenUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {
    /*
        Notasyonlara sahip methodlar olusturabilmek icin mose+sag tik+generate8kisayol alt+insert) yaparak
         after methodu icin teardown seceriz
         before methodu icin de setup u seceriz
         test method u icin de test i seceriz

         junit freamworkunde testlerinizi siralama yapabilmek icin ekstra bir notasyon yoktur
         Eger belli bir siralamada calistirmak istersek method isimlerini alfabetik ve sayisal olarak belirtmemiz gerekir.
         */
    @After
    public void tearDown() {
        System.out.println("Her test methodundan sonra bir kez calisir ");

    }

    @Before
    public void setUp()  {
        System.out.println("her test methodundan once birrrrr kez calisir");

    }

    @Test
    public void test1() {
        System.out.println("Test1 methodu calisti");
    }

    @Test
    public void test2() {
        System.out.println("Test2 methodu calisti");
    }

    @Test
    public void test3() {
        System.out.println("Test3 methodu calisti");
    }
}
