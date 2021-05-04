# sob

code ชุดแรกเขียนเป็นรับ parameter แต่การแสดงผลจะแสดงที่ console หรือ terminal นะครับ
สามารถทดสอบได้บน Postman หรือ tool อื่นๆ ที่มีความสามารถเหมือนๆกันครับ

# Environment Develop
- Java version "11.0.8" 2020-07-14 LTS
- Apache Maven 3.6.3
- Postman

#วิธีการ Run Program

```javascript
 mvn spring-boot:run
 ```

#วิธีทดสอบ Section แรก

#ข้อ 1.1

	----Start  Solution A -----
	loclhost:8080/section/a?n=1
	 X
	-----End-----

	----Start  Solution A -----
	loclhost:8080/section/a?n=2
	
	 X O X
	 O X O
	 X O X
	-----End-----

	----Start  Solution A -----
	loclhost:8080/section/a?n=3
	
	 X O X O X
	 O X O X O
	 O O X O O
	 O X O X O
	 X O X O X
	-----End-----

	----Start  Solution A -----
	loclhost:8080/section/a?n=4
	
	 X O X O X O X
	 O X O X O X O
	 O O X O X O O
	 O O O X O O O
	 O O X O X O O
	 O X O X O X O
	 X O X O X O X
	-----End-----

	----Start  Solution A -----
	loclhost:8080/section/a?n=5
	
	 X O X O X O X O X
	 O X O X O X O X O
	 O O X O X O X O O
	 O O O X O X O O O
	 O O O O X O O O O
	 O O O X O X O O O
	 O O X O X O X O O
	 O X O X O X O X O
	 X O X O X O X O X
	-----End-----

#ข้อ 1.2

	----Start  Solution B -----
	loclhost:8080/section/b?n=1
	
	 X
	-----End-----

	----Start  Solution B -----
	loclhost:8080/section/b?n=2
	
	 XX
	 XX
	-----End-----

	----Start  Solution B -----
	loclhost:8080/section/b?n=3
	
	 X X
	 XXX
	 X X
	-----End-----

	----Start  Solution B -----
	loclhost:8080/section/b?n=4
	
	 X  X
	 XXXX
	 XXXX
	 X  X
	-----End-----

	----Start  Solution B -----
	loclhost:8080/section/b?n=5
	
	 X   X
	 XX XX
	 XXXXX
	 XX XX
	 X   X
	-----End-----

#ข้อ 1.3

	----Start  Solution C -----
	loclhost:8080/section/c?n=1
	
	 X
	-----End-----

	----Start  Solution C -----
	loclhost:8080/section/c?n=2
	
	XX
	XX
	-----End-----

	----Start  Solution C -----
	loclhost:8080/section/c?n=3
	
	 XXX
	 YYX
	 XXX
	-----End-----

	----Start  Solution C -----
	loclhost:8080/section/c?n=4
	
	 XXXX
	 YYYX
	 XXYX
	 XXXX
	-----End-----

	----Start  Solution C -----
	loclhost:8080/section/c?n=5
	
	 XXXXX
	 YYYYX
	 XXXYX
	 XYYYX
	 XXXXX
	-----End-----

#ข้อ 3 Create a page for display and searching users by using API from “https://jsonplaceholder.typicode.com/users” Response data must be in JSON format only.

***  ทดสอบบน web browser นะครับ 

```javascript 

** กรณีเข้าไมาครั้งแรก ระบบจะโหลดข้อมูล User มาแสดงใน Format JSON
http://localhost:8080/section/users
{
  "id" : 1,
  "name" : "Leanne Graham",
  "username" : "Bret",
  "email" : "Sincere@april.biz",
  "address" : {
    "street" : "Kulas Light",
    "suite" : "Apt. 556",
    "city" : "Gwenborough",
    "zipcode" : "92998-3874",
    "geo" : {
      "lat" : "-37.3159",
      "lng" : "81.1496"
    }
  },
  "phone" : "1-770-736-8031 x56442",
  "website" : "hildegard.org",
  "company" : {
    "name" : "Romaguera-Crona",
    "catchPhrase" : "Multi-layered client-server neural-net",
    "bs" : "harness real-time e-markets"
  }
}
```

```javascript

** กรณี Search ระบบจะโหลดข้อมูล User ที่ถูกค้าหา มาแสดงใน Format JSON
	- รองรับ METHOD POST  only
	- ค้นหาได้จาก
		- id
		- username
		
http://localhost:8080/section/users

แสดงข้อมูล

[{
  "id" : 4,
  "name" : "Patricia Lebsack",
  "username" : "Karianne",
  "email" : "Julianne.OConner@kory.org",
  "address" : {
    "street" : "Hoeger Mall",
    "suite" : "Apt. 692",
    "city" : "South Elvis",
    "zipcode" : "53919-4257",
    "geo" : {
      "lat" : "29.4572",
      "lng" : "-164.2990"
    }
  },
  "phone" : "493-170-9623 x156",
  "website" : "kale.biz",
  "company" : {
    "name" : "Robel-Corkery",
    "catchPhrase" : "Multi-tiered zero tolerance productivity",
    "bs" : "transition cutting-edge web services"
  }
}]

