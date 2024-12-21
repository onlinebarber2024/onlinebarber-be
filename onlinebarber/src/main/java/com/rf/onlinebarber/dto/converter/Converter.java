package com.rf.onlinebarber.dto.converter;
/*
* Factory Design Pattern
* Burada ilk olarak hangi türü çevireceğimizi bilmediğimiz için interface yazıyoruz
* ve generic bir yapı kuruyoruz
* sonrasında çevireceğimiz sınfıları implement ediyoruz
* design patterni uygulamak için bir tane factory sınıfı oluşturuyoruz ->DtoConverterFactory
* bu sınıfta ise bir map oluşturyoruz bu map bize hangi sınıf için hangi implement ettiğimiz dönüştürücüyü
* kullanacağımız belirtiyoruz
* getConvert methodu ile sınıfı alıyoruz
* DtoConverterde ise getConver(Example.class).convert(source); şeklimde dönğştürme işlemini yapıyoruz
*
* */
public interface Converter <T,U>{
    U convert(T source);
}
