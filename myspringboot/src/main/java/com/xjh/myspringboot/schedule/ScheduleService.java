package com.xjh.myspringboot.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @autor xujianhong
 * @date 2020/2/6 19:53
 * 定时任务
 */

@Service
public class ScheduleService {


    /**
     * *  <li>second</li> 秒
     * 	 * <li>minute</li> 分
     * 	 * <li>hour</li> 时
     * 	 * <li>day of month</li> 天
     * 	 * <li>month</li>  月
     * 	 * <li>day of week</li> 星期几  (0-7) 0和7都表示星期天
     *
     * 	 , 表示枚举
     *   - 表示区间
     *   * 表示任意
     *   / 表示步长
     *   ？ 表示日和星期冲突匹配
     *   L 表示最后
     *   W 表示工作日
     *   # 星期 4#2 表示第二个星期三
     *
     */
    @Scheduled(cron = "0 * * * * MON-FRI")
    public void scheduleTask(){
        System.out.println("定时任务执行..........");
    }
}
