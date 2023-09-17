package com.ruoyi.system.service;


import com.ruoyi.system.domain.RentUser;
import com.ruoyi.system.domain.SysNotice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    private IRentUserService rentUserService;
    @Autowired
    private ISysNoticeService noticeService;
    @Scheduled(cron = "0 0 0 * * ?")  //表示：秒 分 时 日 月 星期几
    public void initBirthDayNotice() throws ParseException {
//        System.out.println("hello,你被执行了");
        List<RentUser> rentUsers = rentUserService.list();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
//        System.out.println(formatter.format(date));
        for(RentUser rentUser:rentUsers){
//            System.out.println(formatter.format(rentUser.getRentBirthdayAsDate()));
            if(rentUser.getRentBirthday()!=null) {
                if (formatter.format(rentUser.getRentBirthdayAsDate()).equals(formatter.format(date))) {
//                    System.out.println(rentUser.getRentUsername() + "生日快乐");
                    String noticeTitle = "今天是" + rentUser.getRentUsername() + "的生日";
                    SysNotice ifExist = new SysNotice();
                    ifExist.setNoticeTitle(noticeTitle);
                    List<SysNotice> sysNotices=noticeService.selectNoticeList(ifExist);
                    if(sysNotices.size()==0){
                        SysNotice notice = new SysNotice();
                        notice.setNoticeTitle("今天是" + rentUser.getRentUsername() + "的生日");
                        notice.setNoticeContent("请及时联系 "+rentUser.getPhoneNum()+" 送上生日祝福");
                        notice.setNoticeType("1");
                        notice.setRemark("自动生日提醒");
                        notice.setCreateBy("Console");
                        notice.setUpdateBy("Console");
                        notice.setStatus("0");
                        notice.setCreateTime(new Date());
                        notice.setUpdateTime(new Date());
                        noticeService.save(notice);
                    }else{
                        System.out.println("已进行生日提醒");
                    }
                }
            }
        }
    }
}
