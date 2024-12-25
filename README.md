Таск 4. System Design:
1. Архитектура приложения
MVVM (Model-View-ViewModel):

Model: отвечает за работу с данными (API, локальная база через Room).
ViewModel: управляет состоянием, обеспечивает бизнес-логику и связывает данные с интерфейсом.
View: Jetpack Compose для построения интерфейса. Этот подход обеспечит четкое разделение слоев, поддержку модульности и тестируемости.
2. Используемые технологии
Jetpack Compose: для построения современного декларативного интерфейса.
Room: для локального хранения сообщений и чатов.
WebSocket (OkHttp): для работы в реальном времени.
Retrofit: для REST-запросов (например, авторизация, загрузка списка чатов).
Kotlin Coroutines + Flow: для управления асинхронными потоками данных.
Dagger Hilt: для внедрения зависимостей.
3. Основные экраны
Экран списка чатов:

UI: Список чатов через LazyColumn в Jetpack Compose.
Данные: Загружаются из Room (для оффлайна) и синхронизируются с сервером через REST API.
Элементы списка: аватар, имя собеседника, последнее сообщение, время.
Экран чата:

UI: Лента сообщений через LazyColumn (с разделением на входящие и исходящие).
Поле ввода: для текста и кнопки отправки.
Данные: Подгружаются из Room и обновляются через WebSocket в реальном времени.
4. Хранение данных
Для хранения чатов и сообщений я использую Room:

Чаты: Таблица с последними сообщениями, временем и статусом.
Сообщения: Таблица с деталями сообщений (текст, отправитель, время).
Room обеспечивает оффлайн-доступ к истории чатов. При восстановлении соединения данные синхронизируются с сервером.

5. Сетевое взаимодействие
REST API (Retrofit):

Для получения списка чатов и истории сообщений.
Для обработки авторизации и синхронизации данных.
WebSocket (OkHttp):

Используется для передачи сообщений в реальном времени.
При получении новых сообщений они сохраняются в Room, а UI обновляется через Flow.
6. Логика работы с сообщениями
Отправка сообщений:

Пользователь вводит сообщение.
Сообщение сначала сохраняется в Room с временным статусом.
Затем оно отправляется на сервер через WebSocket.
После подтверждения от сервера статус обновляется.
Получение сообщений:

Сервер отправляет сообщение через WebSocket.
Оно сохраняется в Room и отображается в интерфейсе через Flow.
7. Управление состоянием
Для управления состоянием я использую Kotlin Coroutines и Flow:

Flow обеспечивает потоковые обновления данных в реальном времени.
Например, новые сообщения автоматически подгружаются из Room и передаются в UI.
8. Навигация
Навигация между экранами реализована через Jetpack Navigation:

Экран списка чатов → Экран сообщений передает chatId как аргумент.
Поддерживается глубокая ссылка для открытия конкретного чата из уведомлений.
9. Внедрение зависимостей
Я использую Dagger Hilt для внедрения зависимостей:

ViewModel, репозитории, DAO и сетевые клиенты настраиваются через Hilt.
Это делает код модульным, понятным и легко тестируемым.

10. Поддержка работы в оффлайне
Сообщения и чаты хранятся в локальной базе Room.
При восстановлении сети данные синхронизируются с сервером через REST API.