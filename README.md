# ApiNews
Описание проекта: API для получения данных из БД:
  Обрабатываемых источниках
  Тематиках новостей
  Новостях: всех, всех по источнику, всех по тематике
Статистическая выгрузка, запускающаяся по cron-рассписанию. Для каждого источника создаётся файл csv формата: Тема,Количество новостей. 
Файл называется названием источника.
Миграции для базы данных
