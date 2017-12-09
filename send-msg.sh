curl -kv -X POST -H 'Content-Type: application/json' \
  -d '{ "domain":"rambler", "author":{ "email": "oneuse@rambler.ru", "password": "Qeaszzasqe013!" }, "recipients": ["novokrest013@gmail.com"], "subject": "TestSubject", "message": "Test Message" }' \
  http://localhost:8080/send
