document.addEventListener("DOMContentLoaded", function () {
  function fetchStudents() {
    console.log("starting fetch")
    fetch("http://localhost:8080/api/students")
      .then(response => {
        if (!response.ok) {
          console.log(response)
          throw new Error(response.statusText)
        }
        return response.json();
      })
      .then(data => {
        const studentsList = document.getElementById("students-list");
        studentsList.innerHTML = "";
        data.forEach(student => {
          const listItem = document.createElement("li");
          listItem.textContent = `ID: ${student.id}, Name: ${student.name}, Lastname: ${student.lastname}, Surname: ${student.surname}, Birthday: ${student.birthday}, Group: ${student.group}`;
          studentsList.appendChild(listItem);
        });
      })
  }

  setInterval(fetchStudents, 1000);

  fetchStudents();
});
