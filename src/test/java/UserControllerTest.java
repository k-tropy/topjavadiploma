//import com.bolgov.TopJavaDiploma;
//import io.restassured.RestAssured;
//import org.hamcrest.Matchers;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static io.restassured.RestAssured.get;
//import static io.restassured.RestAssured.preemptive;
//import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = { TopJavaDiploma.class }, webEnvironment = RANDOM_PORT)
public class UserControllerTest {

//    @Value("${local.server.port}")
    private int port = 9090;

//    @Before
//    public void setUp() {
//        RestAssured.authentication = preemptive().basic("admin", "passw0rd");
//    }

//    @Test
//    public void shouldSayHello() {
////        get("http://localhost:" + port + "/user/johnsmith")
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .body("firstname", Matchers.equalTo("John"))
//                .and()
//                .body("lastname", Matchers.equalTo("Smith"));
//    }
}
