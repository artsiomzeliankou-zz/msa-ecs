package by.artsiom.demo.schoolservice.delegates;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class SchoolServiceDelegate {

    @Autowired
    RestTemplate restTemplate;

    private final static String STUDENT_SERVER_URL_DISCOVERY = "http://student-service/getStudents/{schoolname}";

    @HystrixCommand(fallbackMethod = "callStudentServiceAndGetData_Fallback")
    public String callStudentServiceAndGetData(String schoolname) {

        String response = restTemplate
                .exchange(
                        STUDENT_SERVER_URL_DISCOVERY,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<String>() {
                        },
                        schoolname)
                .getBody();

        System.out.println("Response Received as " + response + " -  " + new Date());

        return "NORMAL FLOW !!! - School Name -  " + schoolname + " :::  " +
                " Student Details " + response + " -  " + new Date();
    }

    private String callStudentServiceAndGetData_Fallback(String schoolname) {

        System.out.println("Student Service is down!!! fallback route enabled...");

        return "CIRCUIT BREAKER ENABLED!!! No Response From Student Service at this moment. " +
                " Service will be back shortly - " + new Date();
    }
}
