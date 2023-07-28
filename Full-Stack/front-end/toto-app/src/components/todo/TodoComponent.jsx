import { useNavigate, useParams } from "react-router-dom"
import { useAuth } from "./security/AuthContext"
import { retrieveTodoResource, updateTodoApi, createTodoApi } from "./api/TodoApiService"
import { useEffect, useState } from "react"
import { Formik, Form, Field, ErrorMessage } from "formik"
import moment from "moment/moment"

function TodoComponent() {
    const { id } = useParams()

    const auth = useAuth()
    const username = auth.username

    useEffect(
        () => retrieveTodo(), [id]
    )

    const navigate = useNavigate()

    const [description, setDescription] = useState('')
    const [targetDate, setTargetDate] = useState('')

    function retrieveTodo() {
        if (id != -1) {
            retrieveTodoResource(username, id)
                .then(
                    response => {
                        setDescription(response.data.description)
                        setTargetDate(response.data.targetDate)
                    }
                )
                .catch(
                    error => console.log(error)
                )
        }

    }

    function onSubmit(values) {
        const todo = {
            id: id,
            username: username,
            description: values.description,
            targetDate: values.targetDate,
            done: false
        }
        if (id == -1) {
            createTodoApi(username, todo)
                .then(response => {
                    navigate('/todos')
                })
                .catch(error => {
                    console.log(error)
                })
        } else {
            updateTodoApi(username, id, todo)
                .then(response => {
                    navigate('/todos')
                })
                .catch(error => {
                    console.log(error)
                })
        }
    }

    function validate(values) {
        let errors = {

        }
        if (values.description.length < 5) {
            errors.description = 'Enter at least 5 characters'
        }

        if (values.targetDate == null || values.targetDate == '' || !moment(values.targetDate).isValid()) {
            errors.targetDate = 'Enter a target date'
        }

        return errors
    }

    return (
        <div className="TodoComponent">
            <h1>Enter toto details</h1>
            <div>
                <Formik initialValues={{ description, targetDate }}
                    enableReinitialize={true}
                    onSubmit={onSubmit}
                    validate={validate}
                    validateOnChange={false}
                    validateOnBlur={false}
                >
                    {
                        (props) => (
                            <Form>
                                <ErrorMessage
                                    name="description"
                                    component="div"
                                    className="alert alert-warning"
                                />
                                <ErrorMessage
                                    name="targetDate"
                                    component="div"
                                    className="alert alert-warning"
                                />
                                <fieldset className="form-group">
                                    <label>Description</label>
                                    <Field type="text" className="form-control" name="description" />
                                </fieldset>
                                <fieldset className="form-group">
                                    <label>Target Date</label>
                                    <Field type="date" className="form-control" name="targetDate" />
                                </fieldset>
                                <div>
                                    <button className="btn btn-success m-3" type="submit">Save</button>
                                </div>
                            </Form>
                        )
                    }

                </Formik>
            </div>
        </div>
    )
}

export default TodoComponent