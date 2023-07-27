import { useParams } from "react-router-dom"
import { useAuth } from "./security/AuthContext"
import { retrieveTodoResource } from "./api/TodoApiService"
import { useEffect, useState } from "react"

function TodoComponent() {
    const {id} = useParams()

    const auth = useAuth()

    useEffect(
        () => retrieveTodo(),[id]
    )

    const [description,setDescription]  = useState()

    function retrieveTodo() {
        retrieveTodoResource(auth.username,id)
        .then(
            response => setTodo(response.data.description)
        )
        .catch(
            error => console.log(error)
        )
    }

    return (
        <div className="LogoutComponent">
            <h1>Enter toto details</h1>
            <div>
                {description}
            </div>
        </div>
    )
}

export default TodoComponent