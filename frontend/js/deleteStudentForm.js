document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("delete-student");
    form.onsubmit = function (event) {
      event.preventDefault()

      const formData = new FormData(event.target);
      const id = formData.get("id");

      fetch(`http://localhost:8080/students/${id}`, {
        method: "DELETE"
      }).then(response => {

        const errors = document.getElementsByClassName("error");
        while (errors.length > 0) {
          errors[0].parentNode.removeChild(errors[0]);
        }

        if (!response.ok) {
          response.json().then(result => {
            const errorMessage = document.createElement("p");
            errorMessage.className = "error"
            errorMessage.textContent = result.message;

            document.getElementById("delete-student").after(errorMessage)
          })
        } else {
          form.reset();
        }
      })
    }
  }
);


