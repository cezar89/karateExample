package com.example.demo.integration;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.intuit.karate.junit4.Karate;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Karate.class)
public class KarateUnitTest {
    private static WireMockServer wireMockServer
            = new WireMockServer(WireMockConfiguration.options().port(8081));

    @BeforeClass
    public static void setUp() throws Exception {

        System.out.println("TEST HERE!");

        wireMockServer.start();
        WireMock.configureFor("localhost", 8081);
        WireMock.stubFor(
                WireMock.get(WireMock.urlEqualTo("/"))
                        .willReturn(WireMock.aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody("{ \"response\": \"hello world\"}")));
    }

    @AfterClass
    public static void tearDown() throws Exception {
        wireMockServer.stop();
    }
//    @Karate.Test
//    Karate testAll() {
//        return Karate.run().relativeTo(getClass());
//    }

}