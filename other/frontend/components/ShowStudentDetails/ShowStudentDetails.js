/**
 * Created by Angela on 24.12.2018.
 */

import React, { Component } from 'react';


class ShowStudentDetails extends Component {
    constructor(props) {
        super(props);


    }


    render() {



        return (
            <div className="row">

                {/*<div>*/}
                     {/*<div><label>Name: {props.selectedStudent.name}</label></div>*/}
                {/*</div>*/}
                    <div className="col-2"><label htmlFor="name">Name: </label></div>
                    <div className="col-2"><label htmlFor="surname" >Surname: </label></div>
                    <div className="col-2"><label htmlFor="index">Index: </label></div>
                    <div className="col-2"><label htmlFor="nasoka">Nasoka: </label></div>

            </div >
        );
    }
}



export default ShowStudentDetails;