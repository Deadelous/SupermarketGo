
import Rest.RestServer;
import io.restassured.RestAssured;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class ProductEndpointTest {
    @BeforeClass
    public static void setUpBeforeClass(){
        RestServer server = new RestServer();
        server.startRestServer();
    }

    @AfterClass
    public static void TearDownAfterClass(){
        RestServer server = new RestServer();
        server.stopServer();
    }

    @Before
    public void setUp(){
        RestAssured.baseURI  = "http://localhost:8090";
        RestAssured.basePath = "/";
    }

}
