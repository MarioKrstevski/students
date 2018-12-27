import React from 'react';

const StudentItem = (props) => {

    return (

        <div className="row">


            <div className="col-md-3">
                {props.student.studentName}
            </div>
            <div className="col-md-3">
                {props.student.studentSurname}
            </div>
            <div className="col-1"> <button onClick={() => props.edit(props.index)}> <i className="fa fa-edit"></i> </button> </div>

            <div className="col-1"> <button onClick={() => props.delete(props.index)}> <i className="fa fa-trash"></i> </button> </div>
        </div>
    )
};

export default StudentItem;