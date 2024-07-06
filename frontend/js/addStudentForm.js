document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("add-student");
  form.onsubmit = function (event) {

    event.preventDefault();

    const formData = new FormData(event.target);
    const data = {
      name: formData.get('name'),
      lastname: formData.get('lastname'),
      surname: formData.get('surname'),
      birthday: formData.get('birthday'),
      group: formData.get('group')
    };

    fetch("http://localhost:8080/api/students", {
      method: "POST",
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
    })
      .then(response => {
        const errors = document.getElementsByClassName("error");

        while (errors.length > 0) {
          errors[0].parentNode.removeChild(errors[0]);
        }

        if (!response.ok) {
          console.log(response);
          response.json().then(result => {
            result.errors.forEach(error => {
              const errorMessage = document.createElement("p");
              errorMessage.className = "error"
              errorMessage.textContent = error.defaultMessage;

              document.getElementById(error.field).after(errorMessage);
            });
          });
        } else {
          form.reset();
        }
      })
  };
});
