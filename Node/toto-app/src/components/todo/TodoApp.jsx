import { BrowserRouter, Routes, Route, useNavigate, useParams, Link } from 'react-router-dom'
import HeaderComponent from './HeaderComponent'
import LoginComponent from './LoginComponent'
import LogoutComponent from './LogoutComponent'
import TodoComponent from './TodoComponent'
import ErrorComponent from './ErrorComponent'
import WelcomeComponent from './WelcomeComponent'
import FooterComponent from './FooterComponent'
import './TodoApp.css'
export default function TodoApp() {
    return (
        <div className="TodoApp">
            <BrowserRouter>
            <HeaderComponent />
                <Routes>
                    <Route path='/' element={<LoginComponent />} />
                    <Route path='/login' element={<LoginComponent />} />
                    <Route path='/logout' element={<LogoutComponent />} />
                    <Route path='/welcome/:username' element={<WelcomeComponent />} />
                    <Route path='/todos' element={<TodoComponent />} />
                    <Route path='*' element={<ErrorComponent />} />
                </Routes>
                <FooterComponent />
            </BrowserRouter>
    
        </div>
    )
}











