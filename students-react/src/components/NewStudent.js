import React, { Component } from 'react';

class NewStudent extends Component {
    constructor(props) {
        super(props);
        this.state = {

        };
    }
    render() {
        let newStudent;

        const addNewStudent = (formSubmitEvent) => {
            formSubmitEvent.preventDefault();

            newStudent = {
                studentName: formSubmitEvent.target.name.value,
                studentSurname: formSubmitEvent.target.surname.value,
                index: formSubmitEvent.target.index.value,
                program: formSubmitEvent.target.nasoka.value
            };
            console.log("nov student", newStudent);
            addStudent();
        };

        const addStudent = () => {
            this.props.add(newStudent)
        }

        return (
            <div className="row">
                <form onSubmit={addNewStudent}>
                    <div className="col-2"><label htmlFor="name">Name: </label><input type="text" name="name" id="name" />
                    </div>
                    <div className="col-2"><label htmlFor="surname" >Surname: </label><input type="text" name="surname" id="surname" /></div>
                    <div className="col-2"><label htmlFor="index">Index: </label><input type="text" name="index" id="index" /></div>
                    <div className="col-2"><label htmlFor="nasoka">Nasoka: </label><input type="text" name="nasoka" id="nasoka" /></div>

                    <div className="col-1"> <button type="submit"> <i className="fa fa-plus"></i> </button> </div>
                </form>

            </div >
        );
    }
}

export default NewStudent;