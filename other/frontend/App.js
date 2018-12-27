import React, { Component } from 'react';
import createBrowserHistory from "history/createBrowserHistory";
import { Router, Route } from 'react-router-dom';
import 'font-awesome/css/font-awesome.css'
import StudentsList from "./components/StudentsList/StudentsList";
import StudyProgramsList from "./components/StudyProgramsList/StudyProgramsList";
import ShowStudentDetails from "./components/ShowStudentDetails/ShowStudentDetails"
import EdiStudentDetails from "./components/EditStudentDetails/EditStudentDetails";
import NewStudent from "./components/NewStudent";

import './App.css';
import { listStudents } from "./repository/studentsReposotory";
import {getStudentsFromApi} from "./repository/studentsApi";
import {getStudyProgramsFromApi} from "./repository/studentsApi";
import {getStudentByIndex} from "./repository/studentsApi";

class App extends Component {
    constructor(props) {
        super(props);

        this.state = {

            students: [],
            studyPrograms: [],
            showStudentDetails: false,
            index: null,
            selectedStudent: []
        };

        // console.log(this.state.students);

    }

    // loadData = () => {
    //     getStudentsFromApi()
    //         .then((response) => {
    //             console.log(response[0]);
    //             console.log('data', response);
    //             this.setState({students:response[0]})
    //         });
    // };
    loadData = () => {
        getStudentsFromApi()
            .then((response) => {
                console.log('data: ', response)
                this.setState({
                    students: response
                })
            });
    };

    loadPrograms = () => {
        getStudyProgramsFromApi()
            .then((response) => {
                console.log('data: ', response)
                this.setState({
                    studyPrograms: response
                })
            });
    };

    loadSelectedStudent = () =>{
        getStudentByIndex(this.state.selectedStudent)
            .then((response) => {
                console.log('data: ', response)
                this.setState({
                    selectedStudent: response
                })
            });
    };


    render() {

        const toggleDetails = (passedIndex) => {
            let toDetails = this.state.showStudentDetails;
            this.setState({ showStudentDetails: !toDetails })
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
            oldStudents[this.state.studentIndex] = newStudent;
            this.setState({ students: oldStudents })
            this.setState({ showStudentDetails: false })
        }
        const customHistory = createBrowserHistory()


        let button = "";

        if (this.state.showStudentDetails) {
            button = <ShowStudentDetails apply={applyData} selectedStudent={this.state.students[this.state.index]} />;
        } else {

        }
        return (
            <div className="row">
                <table>
                    {button}
                    <tr>
                        <th>Students</th>
                        <th>Study Programs</th>
                    </tr>
                    <tr>
                        <td><StudentsList students={this.state.students} detail={toggleDetails}/></td>
                        <td><StudyProgramsList studyPrograms={this.state.studyPrograms}/></td>
                    </tr>
                </table>


                  {/*<li>{this.state.students.index}</li>*/}


            </div>

            // <div>{this.state.students.name}</div>

        );
    }
    componentDidMount() {
        this.loadData();
        this.loadPrograms();
        this.loadSelectedStudent();
    }
}

export default App;
