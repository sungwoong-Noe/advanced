package hello.advanced.trace.threadLoclaCode;

import hello.advanced.trace.threadLoclaCode.code.FieldService;
import hello.advanced.trace.threadLoclaCode.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {

//    private FieldService fieldService = new FieldService();
    private ThreadLocalService fieldService = new ThreadLocalService();


    @Test
    void field(){
        log.info("main start");
        Runnable userA = () -> {
            fieldService.logic("userA");
        };
        Runnable userB = () -> {
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");

        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
//        sleep(2000); //동시성 문제 x
        sleep(100); //동시성 문제 발생
        threadB.start();

        sleep(3000);
        log.info("main exit");
    }

    private void  sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
