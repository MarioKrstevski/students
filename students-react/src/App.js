import React, { Component } from 'react';
import createBrowserHistory from "history/createBrowserHistory";
import { Router, Route } from 'react-router-dom';
import 'font-awesome/css/font-awesome.css'
import StudentsList from "./components/StudentsList/StudentsList";
import EdiStudentDetails from "./components/EditStudentDetails/EditStudentDetails";
import NewStudent from "./components/NewStudent";
import { getStudentsFromApi, getStudyProgramsFromApi } from "./repository/studentsApi";
import StudyProgramsList from "./components/StudyProgramsList/StudyProgramsList";

import './App.css';
import { listStudents } from "./repository/studentsReposotory";

class App extends Component {
    constructor(props) {
        super(props);

        this.state = {
            students: [],
            studyPrograms: [],
            showEdit: false,
            index: null
        };

        console.log(this.state.students);


    }

    render() {

        const toggleEdit = (passedIndex) => {
            let toEdit = this.state.showEdit;
            this.setState({ showEdit: !toEdit })
            this.setState({ index: passedIndex });
        }

        const deleteStudent = (index) => {
            let previous = this.state.students;
            previous.splice(index, 1);

            this.setState({ students: previous })


        }

        const addStud = (newStudent) => {
            console.log("Jjas raboptam");
            const oldStudents = this.state.students;
            console.log("OLD ", oldStudents);
            oldStudents.unshift(newStudent);
            console.log("NEW ", oldStudents);
            this.setState({ students: oldStudents })
            console.log(" state students", this.state.students);
        }
        const applyData = (newStudent) => {

            const oldStudents = this.state.students;
            oldStudents[this.state.index] = newStudent;

            this.setState({ students: oldStudents })

            this.setState({ showEdit: false })
        }
        const customHistory = createBrowserHistory()


        let button = "";

        if (this.state.showEdit) {
            button = < EdiStudentDetails apply={applyData} selectedStudent={this.state.students[this.state.index]} />;
        } else {

        }
        return (
            <div>
                Test extra text
               <hr />
                <Router history={customHistory} >
                    <div>
                        <Route exact={true} path='/' render={() => (
                            <div className="container">
                                <h3>Laboratoriska 1</h3>

                                {button}

                                <div className="row">

                                    <h2>Students</h2>

                                    <StudentsList students={this.state.students} edit={toggleEdit} delete={deleteStudent} />


                                    <h2>Study Programs</h2>
                                    <StudyProgramsList studyPrograms={this.state.studyPrograms}/>
                                </div>
                            </div>
                        )} />
                        <Route exact={true} path='/insert' render={() => (
                            <NewStudent add={addStud} />
                        )} />
                        <Route exact={true} path='/**' render={() => (
                            <span>Error posto mopnika taka kazawwwwwww</span>
                        )} />



                    </div>
                </Router>
            </div>


        );
    }

    loadStudents = () => {
        getStudentsFromApi()
            .then(response => response.json())
            .then((data) => {
                console.log('data: ', data)
                this.setState({
                    students: data
                })
            });

    };

    loadStudyPrograms = () => {
        getStudyProgramsFromApi()
            .then(response => response.json())
            .then((data) => {
                console.log('data: ', data)
                this.setState({
                    studyPrograms: data
                })
            });
    };

    componentDidMount(){
        this.loadStudents()
        this.loadStudyPrograms();
    }
}

export default App;
