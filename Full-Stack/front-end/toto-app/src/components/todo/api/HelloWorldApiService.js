import axios from "axios";
import { BASE_URL } from "./Endpoints";



const apiClient = axios.create(
    {
        baseURL: BASE_URL
    }
)

export const retrieveHelloWorldBean
    = () => apiClient.get('/hello-world-bean')


export const retrieveHelloWorld
    = () => apiClient.get('/hello-world')


export const retrieveHelloWorldPathVariable
    = (username) => apiClient.get(`/hello-world-bean/path-variable/${username}`)