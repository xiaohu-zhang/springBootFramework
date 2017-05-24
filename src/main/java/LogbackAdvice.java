import com.cmcc.mgr.controller.model.ThreadLocalModel;

import ch.qos.logback.classic.AdviceModel;
import ch.qos.logback.classic.ILogbackAdvice;
import ch.qos.logback.classic.Level;

public class LogbackAdvice implements ILogbackAdvice {

    @Override
    public AdviceModel before(String localFQCN, String msg, Level level) {
        // TODO Auto-generated method stub
        if(ThreadLocalModel.getThreadLocal() != null){
            AdviceModel adviceModel = new AdviceModel();
            adviceModel.setMsg("traceId:" + ThreadLocalModel.threadLocal.get().getTreceId() + " " + msg);
            return adviceModel;
        }
        return null;
    }

    @Override
    public AdviceModel before(String localFQCN, String msg, Level level, Throwable t) {
        // TODO Auto-generated method stub
        if(ThreadLocalModel.getThreadLocal() != null){
            AdviceModel adviceModel = new AdviceModel();
            adviceModel.setMsg("traceId:" + ThreadLocalModel.threadLocal.get().getTreceId() + " " + msg);
            return adviceModel;
        }
        return null;
    }

}
