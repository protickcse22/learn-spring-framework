import { apiClient } from "./ApiClient";


export const retrieveHelloWorldBean
    = () => apiClient.get('/hello-world-bean')


export const retrieveHelloWorld
    = () => apiClient.get('/hello-world')


export const retrieveHelloWorldPathVariable
    = (username) => apiClient.get(`/hello-world-bean/path-variable/${username}`)

export const executeBasicAuthenticationService
    = (token) => apiClient.get('/basicauth', {
        headers: {
            Authorization: token
        }
    })


export const executeJWTAuthenticationService
    = (username, password) => apiClient.post('/authenticate', {
        username, password
    })