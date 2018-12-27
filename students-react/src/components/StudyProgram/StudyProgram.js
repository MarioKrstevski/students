import React from 'react';

const StudyProgram = (props) => {

    return (

        <div className="row">


            <div className="col-md-3">
                {props.studyProgram.name}
            </div>
            <div className="col-md-3">
                {props.studyProgram.id}
            </div>

        </div>
    )
};

export default StudyProgram;