export const getStudentsFromApi = () => {
    return fetch('http://localhost:8080/students');
};




export const getStudyProgramsFromApi = () => {
    return fetch('http://localhost:8080/study_programs');
};
