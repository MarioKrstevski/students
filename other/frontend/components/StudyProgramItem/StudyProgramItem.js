/**
 * Created by Angela on 23.12.2018.
 */
import React from 'react';

const StudyProgramItem = (props) => {

    return (

        <div className="row">


            <div className="col-md-3">
                {props.studyProgram.name}
            </div>
            {/*<div className="col-md-3">*/}
            {/*{props.student.lastName}*/}
            {/*</div>*/}
            {/*<div className="col-1"> <button onClick={() => props.edit(props.index)}> <i className="fa fa-edit"></i> </button> </div>*/}

            {/*<div className="col-1"> <button onClick={() => props.delete(props.index)}> <i className="fa fa-trash"></i> </button> </div>*/}
        </div>
    )
};

export default StudyProgramItem;