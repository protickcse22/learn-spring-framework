// 1 Create a context

import { createContext, useContext, useState } from "react";

const AuthContext = createContext()

export const useAuth = () => useContext(AuthContext)

// 2. Share the created context with other component

export default function AuthProvider({ children }) {
    // Put some state in the context


    const [isAuthenticated, setAuthenticated] = useState(false)

    const [username, setUserName] = useState(null)

    function login(userName, passowrd) {
        if(userName === 'protick' && passowrd === '12345') {
            setAuthenticated(true)
            setUserName('protick')
            return true
        } else {
            setAuthenticated(false)
            return false
        }
    }

    function logout() {
        setAuthenticated(false)
    }

    return (
        <AuthContext.Provider value={{ isAuthenticated, login, logout, username}}>
            {children}
        </AuthContext.Provider>
    )
}