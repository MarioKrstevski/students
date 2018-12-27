import React, { Component } from 'react';
import StudyProgram from '../StudyProgram/StudyProgram';
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
        const offset = this.state.pageNum * this.state.pageSize;
        const nextPageOffset = offset + this.state.pageSize;
        const pageCount = Math.ceil(this.props.studyPrograms.length / this.state.pageSize);

        const studyPrograms = this.getStudyProgramsPage(offset, nextPageOffset);
        return (
            <div className="col-md-12">
                <div>
                    {studyPrograms}
                </div>
                <ReactPaginate previousLabel={"previous"}
                               nextLabel={"next"}
                               breakLabel={<a href="#">...</a>}
                               breakClassName={"break-me"}
                               pageCount={pageCount}
                               marginPagesDisplayed={2}
                               pageRangeDisplayed={5}
                               onPageChange={this.handlePageClick}
                               containerClassName={"pagination"}
                               subContainerClassName={"pages pagination"}
                               activeClassName={"active"} />

            </div>
        );
    }
    handlePageClick = (data) => {
        let selected = data.selected;

        // console.log('New selected: ', selected);
        this.setState({ pageNum: selected });
    };


    getStudyProgramsPage = (offset, nextPageOffset) => {
            return this.props.studyPrograms
            .map((studyProgram, index) => {

                return <StudyProgram key={index} studyProgram={studyProgram} index={index}
                                    edit={this.props.edit} delete={this.props.delete}
                />
            })
            // the filter is after the map function, so that the index attribute in map function is not reset for each page
            .filter((studyProgram, index) => {
                return index >= offset
                    && index < nextPageOffset;
            });
    };
}




export default StudyProgramsList;