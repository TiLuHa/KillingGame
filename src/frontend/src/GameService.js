import axios from 'axios'

const url = 'http://localhost:3000/api/games'

export default {
  createGame(data){
    return axios
      .post(url + '', data)
      .then(response => response.data)
  },
  joinGameAsLeader(data, code){
    return axios
    .post(url + '/join', data, { params: {code}})
    .then(response => response.data)
  }
}
