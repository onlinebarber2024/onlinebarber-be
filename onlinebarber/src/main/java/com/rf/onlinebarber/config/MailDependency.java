package com.rf.onlinebarber.config;

import org.springframework.mail.SimpleMailMessage;
//Singleton Design Pattern
public class MailDependency {
    // parametreyi volalite yaptık ki tüm iş parçacıkları tarafından tutarlı şekilde işlenmesi
    private static volatile MailDependency instance;
    private SimpleMailMessage mailMessage;

    private MailDependency(){
        this.mailMessage=new SimpleMailMessage();
        mailMessage.setFrom("noreply@myonlinebarber-app.com");
    }

    /* burada çift kontrol yaparak performans artırrıyoruz ve
    synchronized kullanarak eğer birden fazla sınıf buna erişmek isterse sadece bir örneğini oluşturmasını
    sağlıyoruz
     */
    public static MailDependency getInstance(){
        if(instance==null){
            synchronized (MailDependency.class){
                if(instance==null){
                    instance=new MailDependency();
                }
            }
        }
        return instance;
    }
    public SimpleMailMessage getMailMessage(){
        return mailMessage;
    }
}
