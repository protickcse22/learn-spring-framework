import axios from "axios"
import { useState } from "react"
import { Link, useParams } from "react-router-dom"
import { retrieveHelloWorld, retrieveHelloWorldBean, retrieveHelloWorldPathVariable } from "./api/HelloWorldApiService"

function WelcomeComponent() {
    const { username } = useParams()

    const [message, setMessage] = useState(null)


    function callHelloWorldRestApi() {

        retrieveHelloWorldPathVariable('protick')
            .then(
                (response) => successFulResponse(response)
            )
            .catch(
                (error) => errorResponse(error)
            )
            .finally(
                console.log('cleanup')
            )


        // retrieveHelloWorld()
        //     .then(
        //         (response) => successFulResponse(response)
        //     )
        //     .catch(
        //         (error) => errorResponse(error)
        //     )
        //     .finally(
        //         console.log('cleanup')
        //     )
    }

    function successFulResponse(response) {
        console.log(response.data.message)
        setMessage(response.data.message)
    }

    function errorResponse(error) {
        console.log(error)
    }





    return (
        <div className="Welcome">
            <h1>Welcome to {username}</h1>
            <div>
                Manage your todos - <Link to='/todos'>Go here</Link>
            </div>
            <div>
                <button className="btn btn-success m-5" onClick={callHelloWorldRestApi}>Call Hello World</button>
            </div>
            <div className="text-info">{message}</div>
        </div>
    )
}

export default WelcomeComponent