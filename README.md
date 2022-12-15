Тестовое задание
===========================================================
Создать веб-приложение с использованием следующих технологий:
•	Java 1.8
•	Spring
•	Maven
•	BPMN 2.0 (https://ru.wikipedia.org/wiki/BPMN)
•	Activity (https://www.activiti.org/userguide/)
•	H2 database

1.	Создать бизнес-процесс в нотации bpmn следующего вида:
![image](https://user-images.githubusercontent.com/92391770/207922025-44807dfa-9d15-47ae-9bff-d27cc1ac83c5.png)

 2. Создать Spring Boot приложение для управления bpmn процессом.
3. Создать REST контроллер для запуска процесса(/start), получения списка задач(/tasks) и выполнения задачи (/completetask).
- При запуске бизнес-процесса ему должно передаваться некое число (postValue)
- ServiceTask генерирует случайное число (реализация с помощью интерфейса JavaDelegate https://www.activiti.org/userguide/index.html#bpmnJavaServiceTask) (randomData)
- Если postValue + randomData >= 100, то выполняется задача А, в противном случае задача B.
4. Создать REST контроллер (/result) для получения результата исполненных процессов. В результате должны присутствовать – входной параметр(postValue), случайное число(randomData), их сумма(postValue + randomData), а также некий признак задачи, которая была выполнена(A или B).

Исходный код приложения разместить на github или bitbucket. Создать файл readme c инструкцией по запуску и тестированию приложения.

_________________________________________________
Выполнено.
=================================================
В среде разработки запустить ru.golikov.activity_example.Application.java, приложение запустится на дефолтном порту 8080.

Далее, для отправки запросов по эндпоинтам необходимо использовать Postman / Insomnia или другой API клиент.

  1. Чтобы запустить процесс необходимо отправить POST запрос c телом на адрес http://localhost:8080/start
  
    {
      "post_value":"90"
    } 
    
  2. Для получения списка текущих задач, отправить GET запрос на адрес http://localhost:8080/tasks    
  3. Для того чтобы выполнить задачу, отправить PUT запрос на адрес http://localhost:8080/completetask
    с телом
    
    {
      "id": "20"
    }
    
   в теле указать id задачи которую необходимо выполнить.
   
  4. Для получения результата исполненных процессов отправить GET запрос на адрес http://localhost:8080/result
  
--------------------------------------------------------------------------------------
Старт 3-х процессов с разным post_value

![image](https://user-images.githubusercontent.com/92391770/202876338-394404e2-9429-4faf-ba17-f869845d82f1.png)
![image](https://user-images.githubusercontent.com/92391770/202876359-499e4aaa-4a4d-486e-87b0-0545453f94c5.png)
![image](https://user-images.githubusercontent.com/92391770/202876371-4483b6ad-80ca-449a-ba95-e53c180099e5.png)

Текущие задачи

![image](https://user-images.githubusercontent.com/92391770/202876410-75ecc849-1a56-44dd-a593-bae54a074b22.png)

Выполняю задачу с id = 12 

![image](https://user-images.githubusercontent.com/92391770/202876442-7684b1ba-8bb7-49bb-b221-5ab30393af89.png)

Получаю результат

![image](https://user-images.githubusercontent.com/92391770/202876487-b996c841-173f-433b-9b89-0e0ad179b4a7.png)

Выполнил остальные задачи, получил результат

![image](https://user-images.githubusercontent.com/92391770/202876547-b3575a20-20f1-47d9-9e9b-7a9edf423aa1.png)









