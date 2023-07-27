import { BrowserRouter, Routes, Route, useNavigate, useParams, Link, Navigate } from 'react-router-dom'
import HeaderComponent from './HeaderComponent'
import LoginComponent from './LoginComponent'
import LogoutComponent from './LogoutComponent'
import ListTodoComponent from './ListTodoComponent'
import ErrorComponent from './ErrorComponent'
import WelcomeComponent from './WelcomeComponent'
import FooterComponent from './FooterComponent'
import './TodoApp.css'
import AuthProvider, { useAuth } from './security/AuthContext'
import TodoComponent from './TodoComponent'


function AuthenticatedRoute({ children }) {
    const authContext = useAuth()
    if (authContext.isAuthenticated) {
        return children
    } else {
        return <Navigate to="/" />
    }
}

export default function TodoApp() {
    return (
        <div className="TodoApp">
            <AuthProvider>
                <BrowserRouter>
                    <HeaderComponent />
                    <Routes>
                        <Route path='/' element={<LoginComponent />} />
                        <Route path='/login' element={<LoginComponent />} />
                        <Route path='/logout' element={

                            <AuthenticatedRoute>
                                <LogoutComponent />
                            </AuthenticatedRoute>
                        } />
                        <Route path='/welcome/:username' element={
                            <AuthenticatedRoute>
                                <WelcomeComponent />
                            </AuthenticatedRoute>

                        } />
                        <Route path='/todos' element={
                            <AuthenticatedRoute>
                                <ListTodoComponent />
                            </AuthenticatedRoute>
                        } />

                        <Route path='/todo/:id' element={
                            <AuthenticatedRoute>
                                <TodoComponent />
                            </AuthenticatedRoute>

                        } />
                        <Route path='*' element={<ErrorComponent />} />
                    </Routes>
                    <FooterComponent />
                </BrowserRouter>
            </AuthProvider>

        </div>
    )
}











