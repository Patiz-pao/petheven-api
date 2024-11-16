# Pet Haven API

⚠️ คำเตือน / Warning
Free Hosting Auto-Sleep
- เนื่องจาก API ถูก deploy ด้วยบริการโฮสติ้งฟรี อาจมีการเข้าสู่โหมดพัก (auto-sleep) หลังจากไม่มีการใช้งานเป็นเวลานาน เมื่อมีการเรียกใช้ API ครั้งแรกหลังจากโหมดพัก อาจต้องรอประมาณ 5-10 นาที เพื่อให้ API กลับมาทำงานอีกครั้ง
Free Hosting Auto-Sleep
- The API is deployed using a free hosting service, which may enter an auto-sleep mode after being idle for a while. The first API call after the sleep mode may require a wait time of 5-10 minutes for the API to resume operation.

Pet Haven API เป็นโปรเจค **Java Spring Boot** สำหรับให้บริการ API ที่เชื่อมต่อกับ [Pet Haven Frontend Repository](https://github.com/Patiz-pao/pethaven-frontend)  
โดยเป็นโปรเจค backend ที่สนับสนุนการทำงานของเว็บไซต์ [Pet Haven Shop](https://pet-haven-shop.netlify.app) ทั้งหมด  
เช่น การจัดการสินค้า, การทำคำสั่งซื้อ, และการจัดการผู้ใช้งาน  

Pet Haven API is a **Java Spring Boot** project that provides an API connecting with the [Pet Haven Frontend Repository](https://github.com/Patiz-pao/pethaven-frontend).  
This backend project supports the entire functionality of the [Pet Haven Shop](https://pet-haven-shop.netlify.app) website,  
including product management, order management, and user management.

## 🛠 คุณสมบัติ (Features) / Features
- **การจัดการสินค้า (Products Management):** เพิ่ม, แก้ไข, ลบ และเรียกดูสินค้าทั้งหมด  
- **การจัดการคำสั่งซื้อ (Order Management):** จัดการคำสั่งซื้อของลูกค้า  
- **การจัดการผู้ใช้งาน (User Management):** ระบบการสมัครสมาชิก, ล็อกอิน และจัดการโปรไฟล์  

- **Products Management:** Add, edit, delete, and view all products  
- **Order Management:** Manage customer orders  
- **User Management:** User registration, login, and profile management  

## 🌐 เว็บไซต์ที่เกี่ยวข้อง / Related Websites
- เว็บไซต์โปรเจค: [Pet Haven Shop](https://pet-haven-shop.netlify.app)  
- Repository Frontend: [Pet Haven Frontend](https://github.com/Patiz-pao/pethaven-frontend)

- Project Website: [Pet Haven Shop](https://pet-haven-shop.netlify.app)  
- Frontend Repository: [Pet Haven Frontend](https://github.com/Patiz-pao/pethaven-frontend)

## 🚀 การเริ่มต้นใช้งาน (Getting Started)
API จะพร้อมใช้งานหลังจากเริ่มเซิร์ฟเวอร์ที่:  
`[http://localhost:8080] หรือ (https://petheven-api.onrender.com)`  

API will be available after the server starts at:  
`[http://localhost:8080] or (https://petheven-api.onrender.com)`

คุณสามารถใช้เครื่องมือเช่น Postman หรือ cURL ในการทดสอบ API  
You can use tools like Postman or cURL to test the API

## 🙏 ขอบคุณ (Thank You)
ขอบคุณที่ใช้โปรเจค Pet Haven API!
Thank you for using Pet Haven API!
