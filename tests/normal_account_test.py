import requests
import json

def test_creation():
    url = "http://localhost:8080/api/auth/register"

    payload = json.dumps({
    "loginName": "Tim",
    "password": "tim",
    "email": "tlh@tlharken.de"
    })
    headers = {
    'Content-Type': 'application/json'
    }

    response = requests.request("POST", url, headers=headers, data=payload)

    res = json.loads(response.text)
    assert res["loginName"] == "Tim"
    assert res["email"] == "tlh@tlharken.de"
    assert res["Id"]
    assert not res["flags"]
    assert not res["roles"]
