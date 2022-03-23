import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class URLENCODEDTEST {

    public static void main(String ... a) throws UnsupportedEncodingException {
        System.out.println("http://127.0.0.1/resource?message=Доброе утро, студенты?");
        System.out.println(
                "http://127.0.0.1/resource?message=" + URLEncoder.encode("Доброе утро, студенты?", "UTF-8")
        );
    }

}
