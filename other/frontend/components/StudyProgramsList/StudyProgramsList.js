/**
 * Created by Angela on 23.12.2018.
 */
import React, { Component } from 'react';
import StudyProgramItem from '../StudyProgramItem/StudyProgramItem';
import ReactPaginate from 'react-paginate';


class StudyProgramsList extends Component {
    constructor(props) {
        super(props);

        this.state = {
            pageNum: 0,
            pageSize: 3
        }
    }

    render() {


        const studyPrograms = this.mapPrograms();
        return (
            <div>
                {studyPrograms}
            </div>
        );
    }
    handlePageClick = (data) => {
        let selected = data.selected;

        // console.log('New selected: ', selected);
        this.setState({ pageNum: selected });
    };

    // mapStudents = () =>{
    //     return this.props.students
    //         .map((student, index) => {
    //             return <StudentItem key={index} student={student}
    //                                 edit={this.props.edit} delete={this.props.delete}
    //                                 />
    //         })
    // };
    mapPrograms = () => {
        return this.props.studyPrograms
            .map((studyProgram, index) => {
                return <StudyProgramItem studyProgram={studyProgram}
                                    key={index}
                                    index={index}/>
            });
    };

    // getStudentsPage = (offset, nextPageOffset) => {
    //     return this.props.students
    //         .map((student, index) => {
    //
    //             return <StudentItem key={index} student={student} index={index}
    //                                 edit={this.props.edit} delete={this.props.delete}
    //             />
    //         })
    //         // the filter is after the map function, so that the index attribute in map function is not reset for each page
    //         .filter((student, index) => {
    //             return index >= offset
    //                 && index < nextPageOffset;
    //         });
    // };
}




export default StudyProgramsList;
