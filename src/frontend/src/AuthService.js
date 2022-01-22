import axios from 'axios'

const url = 'http://localhost:3000/api/'

export default {
  login(credentials) {
    return axios
      .post(url + 'auth/login', credentials)
      .then(response => response.data)
  },
  signUp(credentials) {
    return axios
      .post(url + 'register/', credentials)
      .then(response => response.data)
  },
  getSecretContent() {
    return axios.get(url + 'test/')
      .then(response => response.data)
  }
}