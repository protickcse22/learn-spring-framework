import { useState } from "react"
import { useNavigate } from "react-router-dom"

function LoginComponent() {

    const [userName, setUserName] = useState('protick')
    const [password, setPassword] = useState('')

    const [showSuccessMsg, setSuccessMsg] = useState(false)

    const [showErrorMsg, setErrorMsg] = useState(false)

    const navigate = useNavigate()


    function handleSubmit() {
        if (userName === 'protick' && password === '12345') {
            setSuccessMsg(true)
            setErrorMsg(false)
            navigate(`/welcome/${userName}`)
        } else {
            setErrorMsg(true)
            setSuccessMsg(false)
        }
    }


    return (
        <div className="Login">
            {showSuccessMsg && <div className='successMessage'>Authenticated successfully</div>}
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