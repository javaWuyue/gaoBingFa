package disrupptor;

import com.lmax.disruptor.WorkHandler;

public class Consumer implements WorkHandler<PCData> {

    @Override
    public void onEvent(PCData event)throws Exception{
        System.out.println(Thread.currentThread().getId() + "event事件 --" + event.get() * event.get() + "    END ");
    }
	// 无用
	}
