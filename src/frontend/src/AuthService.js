import axios from 'axios'
import store from './store'

const url = 'http://localhost:3000/api/'

export default {
  login(credentials) {
    return axios
      .post(url + 'auth/login', credentials)
      .then(response => response.data)
  },
  signUp(credentials) {
    return axios
      .post(url + 'auth/register', credentials)
      .then(response => response.data)
  },
  getSecretContent() {
    return axios.get(url + 'test/')
      .then(response => response.data)
  },
  isAuthenticated() {
    return store.getters.isLoggedIn
  },
  getUser() {
    console.log(store.getters.getUser)
    return store.getters.getUser
  }
}