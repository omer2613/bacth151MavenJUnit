package techproed.day14_Actions_Faker;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C04_Faker  {
    @Test
    public void faker() {

        /*
        Faker class indan sahte verileri kullanabilmek icinobje olusturmamiz gerekir
         */
        Faker faker=new Faker();
        //faker objesini kullanarak bir isim yazdiriniz.
        System.out.println("isim : " +faker.name().firstName());

        ////faker objesini kullanarak bir isim yazdiriniz
        System.out.println("soyİsim : " +faker.name().lastName());

        //faker objesini kullanarak bir lastName yazdiriniz
        System.out.println("isim : " +faker.name().firstName());

        //faker objesini kullanarak bir fullName yazdiriniz
        System.out.println("isim_soyisim : " +faker.name().fullName());

        //faker objesini kullanarak bir adress yazdiriniz
        System.out.println("Adres : " +faker.address().fullAddress());

        //faker objesini kullanarak bir tel_no yazdiriniz
        System.out.println("Tel_No : "+faker.phoneNumber().phoneNumber());
        System.out.println("Cep_No : "+faker.phoneNumber().cellPhone());

        //Rastgele 15 haneli bir numara yaziniz
        System.out.println("Rastgele 15 haneli bir numara : " +faker.number().digits(15));

        //meslek pozisyonu
        System.out.println(faker.job().position());


    }
}
