java -jar staging/Backend.jar &
pid=$!

sleep 10

pytest tests/normal_account_test.py --junitxml=tests/repo.xml

kill $pid
