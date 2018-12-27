import React, { Component } from 'react';


class EditStudentDetails extends Component {
    constructor(props) {
        super(props);


    }


    render() {

        let newStudent;

        const setStudent = (formSubmitEvent) => {
            formSubmitEvent.preventDefault();

            newStudent = {
                studentName: formSubmitEvent.target.name.value,
                studentSurname: formSubmitEvent.target.surname.value,
                index: formSubmitEvent.target.index.value,
                program: formSubmitEvent.target.nasoka.value
            };

            console.log("test", newStudent);
            onClick();
        };

        const onClick = () => { this.props.apply(newStudent) }

        return (
            <div className="row">

                <form onSubmit={setStudent}>
                    <div className="col-2"><label htmlFor="name">Name: </label><input type="text" name="name" id="name" />
                    </div>
                    <div className="col-2"><label htmlFor="surname" >Surname: </label><input type="text" name="surname" id="surname" /></div>
                    <div className="col-2"><label htmlFor="index">Index: </label><input type="text" name="index" id="index" /></div>
                    <div className="col-2"><label htmlFor="nasoka">Nasoka: </label><input type="text" name="nasoka" id="nasoka" /></div>

                    <div className="col-1"> <button type="submit"> <i className="fa fa-paper-plane"></i> </button> </div>
                </form>

            </div >
        );
    }
}


export default EditStudentDetails;
