import { useState } from "react"
import { useNavigate } from "react-router-dom"
import { useAuth } from "./security/AuthContext"

function LoginComponent() {

    const [userName, setUserName] = useState('')
    const [password, setPassword] = useState('')

    const [showErrorMsg, setErrorMsg] = useState(false)

    const navigate = useNavigate()

    const authContext = useAuth()


    async function handleSubmit() {
        console.log(userName)
        if (await authContext.login(userName,password)) {
            navigate(`/welcome/${userName}`)
        } else {
            setErrorMsg(true)
        }
    }


    return (
        <div className="Login">
            {showErrorMsg && <div className='errorMessage'>Authenticated failed. Please check your credential!</div>}
            <div className="LoginForm">
                <div>
                    <label>User Name</label>
                    <input type="text" name="username" value={userName} onChange={(event) => setUserName(event.target.value)} />
                </div>
                <div>
                    <label>Password</label>
                    <input type="password" name="password" value={password} onChange={(event) => setPassword(event.target.value)} />
                </div>
                <div>
                    <button type="button" onClick={handleSubmit}>login</button>
                </div>
            </div>
        </div>
    )
}


export default LoginComponent