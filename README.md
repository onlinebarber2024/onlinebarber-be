# Online Barber - Backend Service

Yazılım Tasarım ve Mimarisi dersi kapsamında, **online berber randevu sisteminin backend servisini** geliştirdim. Bu projede, kullanıcıların çevrim içi olarak hızlı ve kolay bir şekilde randevu alabilmelerini hedefledim. Servis, **SOLID prensiplerine** uygun bir şekilde **Spring Boot**, **MySQL** ve **Spring Security** kullanılarak yapılandırılmıştır. 

Proje gereklilikleri doğrultusunda, üç veya daha fazla tasarım deseni uygulanmıştır:
- **Singleton**: Mail bildirimleri için Kafka ile entegre edilen mail bağımlılığını yönetmek amacıyla lazy bir yapıda kullanıldı.
- **Factory**: DTO dönüşümlerinde generic bir yapı oluşturmak için uygulandı.
- **Builder**: Model ve DTO sınıflarında hızlı ve esnek nesne oluşturmayı sağlamak için entegre edildi.
- **Strategy**: JWT ve özel olarak geliştirilmiş token servislerini desteklemek amacıyla projeye dahil edildi.

---

## AppointmentController

### Appointment Endpoints
- **POST** `/api/v1/appointment/create/{customerId}/{modelId}` - Randevu oluştur
- **DELETE** `/api/v1/appointment/delete/{id}` - Randevu sil
- **GET** `/api/v1/appointment/list/barber/{id}` - Berber randevu listesini getir
- **GET** `/api/v1/appointment/customer/{id}` - Müşteri randevularını getir

---

## AuthController

### Authentication Endpoints
- **POST** `/api/v1/auth/login` - Kullanıcı girişi
- **POST** `/api/v1/auth/logout` - Kullanıcı çıkışı

---

## CustomerController

### Customer Endpoints
- **POST** `/api/v1/customer/save` - Müşteri kaydet
- **DELETE** `/api/v1/customer/delete` - Müşteri sil

---

## ShavingModelController

### Shaving Model Endpoints
- **POST** `/api/v1/model/add/{id}` - Model ekle
- **DELETE** `/api/v1/model/delete/{id}` - Model sil
- **PUT** `/api/v1/model/update/{id}` - Model güncelle
- **GET** `/api/v1/model/list/{shopId}` - Berber modellerini listele
- **GET** `/api/v1/model/{id}` - Model detaylarını getir

---

## ShopController

### Shop Endpoints
- **POST** `/api/v1/barber/save` - Berber kaydet
- **PUT** `/api/v1/barber/update/{id}` - Berber güncelle
- **DELETE** `/api/v1/barber/delete/{id}` - Berber sil
- **GET** `/api/v1/barber/list` - Tüm berberleri listele
- **GET** `/api/v1/barber/list/{value}` - Belirli kriterlere göre berberleri listele

---

## Proje Mimarisi

Proje mimarisi, geliştirme sürecine başlamadan önce örnek olsun diye tasarlanmıştır.Şu an daha gelişmiş halde.  
![App Screenshot](https://furkancan.dev/assets/assets/onlinebarber.png)

---

## Kullanılan Teknolojiler

- **Spring Boot**: Backend geliştirme için.
- **Spring Security**: Kimlik doğrulama ve yetkilendirme işlemleri için.
- **MySQL**: Veritabanı yönetimi için.
- **Kafka**: Asenkron iletişim ve mail bildirimleri için.
- **JWT (JSON Web Token)**: Kimlik doğrulama için.





