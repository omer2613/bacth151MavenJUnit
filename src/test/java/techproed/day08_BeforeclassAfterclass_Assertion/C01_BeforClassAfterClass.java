package techproed.day08_BeforeclassAfterclass_Assertion;

import org.junit.*;

public class C01_BeforClassAfterClass {
    /*
    @beforclass ve @AfterClass methodlari static olmak zorundadir
     */

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Her class'tan once BeforClass Method'u  bir kez calisir");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Her class'tan sonra AfterClass Method'u bir kez calisir");

    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her method tan once Befor(setup) method u bir kez calisir");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her method tan sonra After(teardown) method u bir kez calisir");
    }

    @Test
    public void test01() {
        System.out.println("Test01 methodu calisti");
    }

    @Test
    public void test02() {
        System.out.println("Test02 methodu calisti");
    }

    @Test
    public void test03() {
        System.out.println("Test03 methodu calisti");
    }
}
