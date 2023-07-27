import axios from "axios";
import { BASE_URL } from "./Endpoints";



const apiClient = axios.create(
    {
        baseURL: BASE_URL
    }
)

export const retrieveAllTodos
    = (username) => apiClient.get(`/users/${username}/todos`)

export const deleteTodo
    = (username,id) => apiClient.delete(`/users/${username}/todos/${id}`)

export const retrieveTodoResource
    = (username,id) => apiClient.get(`/users/${username}/todos/${id}`)