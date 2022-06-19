package hello.advanced.trace;

import lombok.Getter;

//로그 시작시 상태 정보 : 로그를 종료할 떄 사용하게 된다.
@Getter
public class TraceStatus {

    private TraceId traceId;
    private Long startTimeMs;
    private String message;

    public TraceStatus(TraceId traceId, Long startTimeMs, String message) {
        this.traceId = traceId;
        this.startTimeMs = startTimeMs;
        this.message = message;
    }

}
