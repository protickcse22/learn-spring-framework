// 1 Create a context

import { createContext, useContext, useState } from "react";
import { executeJWTAuthenticationService } from "../api/HelloWorldApiService";
import { apiClient } from "../api/ApiClient";

const AuthContext = createContext()

export const useAuth = () => useContext(AuthContext)

// 2. Share the created context with other component

export default function AuthProvider({ children }) {
    // Put some state in the context


    const [isAuthenticated, setAuthenticated] = useState(false)

    const [username, setUserName] = useState(null)

    const [token, setToken] = useState(null)

    async function login(userName, passowrd) {

        try {
            const response = await executeJWTAuthenticationService(userName,passowrd)
            if (response.status === 200) {
                setAuthenticated(true)
                setUserName(userName)
                const jwtToken = 'Bearer '+response.data.token
                setToken(jwtToken)
                apiClient.interceptors.request.use(
                    (config) => {
                        console.log("Token set in header: "+jwtToken)
                        config.headers.Authorization=jwtToken
                        return config
                    }
                )
                return true
            } else {
                logout()
                return false
            }

        } catch (error) {
            logout()
            return false
        }

    
        
    }

    function logout() {
        setAuthenticated(false)
        setUserName(null)
        setToken(null)
    }

    return (
        <AuthContext.Provider value={{ isAuthenticated, login, logout, username, token }}>
            {children}
        </AuthContext.Provider>
    )
}