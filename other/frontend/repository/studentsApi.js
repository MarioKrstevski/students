export const getStudentsFromApi = () => {
    return fetch('http://localhost:8080/students')
        .then(response => response.json());

};

export const getStudentByIndex = (index) => {
    return fetch('http://localhost:8080/students/{index}')
        .then(response => response.json());

};

export const getStudyProgramsFromApi = () => {
    return fetch('http://localhost:8080/study_programs')
        .then(response => response.json());

};

export const getFirstStudent = () => {
   return fetch('http://localhost:8080/students/161517');
};

export const createStudent = (student) => {
    return fetch('http://localhost:8080/students', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            studentName: student.studentName,
            studentSurname: student.studentSurname,
            index: student.index,
            program: student.program
        })
    });
};