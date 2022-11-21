В среде разработки запустить ru.golikov.activity_example.Application.java, приложение запустится на дефолтном порту 8080.

Далее, для отправки запросов по эндпоинтам необходимо использовать Postman / Insomnia или другой API клиент.

  1. Чтобы запустить процесс необходимо отправить POST запрос c телом
    {
      "post_value":"90"
    }
    на адрес http://localhost:8080/start
  2. Для получения списка текущих задач, отправить GET запрос на адрес http://localhost:8080/tasks    
  3. Для того чтобы выполнить задачу, отправить PUT запрос на адрес http://localhost:8080/completetask
    с телом
    {
		"id": "20"
    }
    , в теле указать номер задачи которую необходимо выполнить.
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









