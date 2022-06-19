package hello.advanced.trace;

import lombok.Getter;

import java.util.UUID;

@Getter
public class TraceId {

    private String id;
    private int level;

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    private TraceId(String id, int level){
        this.id = id;
        this.level = level;
    }


    private String createId(){
        return UUID.randomUUID().toString().substring(0, 8);
    }

    //id는 유지하지만 레벨을 증가 시킨다.

    public TraceId createNextId(){
        return new TraceId(id, level + 1);
    }

    public TraceId createPreviousId(){
        return new TraceId(id, level - 1);
    }

    //첫번째 레벨인지 확인
    public boolean isFirstLevel(){
        return level == 0;
    }
}
