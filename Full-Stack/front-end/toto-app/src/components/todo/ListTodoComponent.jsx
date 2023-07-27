import { useEffect, useState } from "react"
import { deleteTodo, retrieveAllTodos } from "./api/TodoApiService"
import { useAuth } from "./security/AuthContext"
import { useNavigate } from "react-router-dom"


function ListTodoComponent() {

    useEffect(
        () => calltrieveTodosAPI(), []
    )

    const [todos, setTodos] = useState([])

    const [message, setMessage] = useState(null)

    const [showElement, setShowElement] = useState(true)

    const authContext = useAuth()

    const navigate = useNavigate()

    useEffect(
        () => {
            setTimeout(
                () => {
                    setShowElement(false)
                }, 10000
            )
        }, []
    )

    function calltrieveTodosAPI() {
        retrieveAllTodos(authContext.username)
        .then(
            response => successFulResponse(response)
        )
        .catch(
            error => console.log(error)
        )

    }

    function successFulResponse(response) {
        setTodos(response.data)
    }

    function callDeleteTodoAPI(id) {
        deleteTodo(authContext.username, id)
            .then(
                () => {
                    setMessage(`Delete of todo with id: ${id} successful`)
                    calltrieveTodosAPI()
                }
            )
            .catch()
    }

    function gotoUpdateTodoPage(id) {
        navigate(`/todo/${id}`)
    }




    return (
        <div className="container">
            <h1>Things you want to add</h1>
            {message && showElement && <div className="alert alert-warning">{message}</div>}
            <div>
                <table className='table'>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Description</th>
                            <th>Is Done?</th>
                            <th>Target Date</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            todos.map(
                                todo => (
                                    <tr key={todo.id}>
                                        <td>{todo.id}</td>
                                        <td>{todo.description}</td>
                                        <td>{todo.done.toString()}</td>
                                        <td>{todo.targetDate.toString()}</td>
                                        <td><button className="btn btn-warning" onClick={() => callDeleteTodoAPI(todo.id)}>Delete</button></td>
                                        <td><button className="btn btn-success" onClick={() => gotoUpdateTodoPage(todo.id)}>Update</button></td>
                                    </tr>
                                )
                            )
                        }
                    </tbody>
                </table>
            </div>
        </div>
    )
}

export default ListTodoComponent