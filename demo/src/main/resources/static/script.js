// This file is for the JavaScript code that will run on the webpage
// Step 1 find the button on webpage
const submitButton = document.getElementById("submit");

// Step 2 wait for the click event on the button
submitButton.addEventListener("click", function(event) {

    // Stop button from refreshing the page
    event.preventDefault();

    // Step 3 take the data
    const studentName = document.getElementById("name").value;
    const studentMajor = document.getElementById("major").value;
    const studentRole = document.getElementById("targetRole").value;

    // print it to prove we caught it
    console.log("Caught the data:" + studentName + " " + studentMajor + " " + studentRole);

    // Step 4 Configure the data for spring boot
    // We create a Java Script object to hold the data
    // The keys on the left must match the variable names in the Student class in Spring Boot
    const newStudent = {
   
    name: studentName,
    major: studentMajor,
    targetRole: studentRole,
    };
    // Springboot dosent speak in JavaScript, so we need to convert our JavaScript object into a JSON string
    // We use a built in tool called JSON.stringify to do this
    const payload = JSON.stringify(newStudent);
    // Print the payload to prove we made it
    console.log("JSON Payload: " + payload);

    // Step 5 Send the data to Spring Boot
    // We use a built in tool called fetch to send the data to Spring Boot
    // The first parameter is the URL we want to send the data to
    // Update we will be making a switch POST vs PUT based on if we are adding a new student or updating an existing one, we can check the hidden studentId input field to see if it has a value. If it does, we are updating an existing student and we will use the PUT method and include the student ID in the URL. If it doesn't, we are adding a new student and we will use the POST method and send the data to the /api/students endpoint without an ID in the URL.
    const hiddenID = document.getElementById("studentId").value; // Get the value of the hidden studentId input field
    
    // Default to creating a new student with POST
    let httpMethod = "POST"; // We will send the data to this URL by default, but if we are updating an existing student, we will change this URL to include the student ID
    let fetchURL = "http://localhost:8082/api/students"; 

    // But if the hidden ID exists we flip the switch to update the student with PUT
    if (hiddenID) {
        httpMethod = "PUT"; // Change the HTTP method to PUT for updating an existing student the differnce between POST and PUT is that POST is used to create a new resource and PUT is used to update an existing resource
        fetchURL = `http://localhost:8082/api/students/${hiddenID}`; // Change the URL to include the student ID for updating an existing student
    }

    // Now we send the fetch using our smart variables!, a fetch is a tool that allows us to send HTTP requests from JavaScript to a server, in this case we will send the student data to our Spring Boot server
    fetch(fetchURL, { // We send the request to the URL we configured above, it will be different based on if we are adding a new student or updating an existing one
        method: httpMethod, // We use the HTTP method we configured above, it will be different based on if we are adding a new student or updating an existing one
        headers: {
            "Content-Type": "application/json" // We need to include this header to tell Spring Boot that we are sending JSON data in the request body
        },
        body: payload // We include the JSON payload we created above in the body of the request
    })
    
.then(function(response) { // This is a callback function that will run when we get a response from Spring Boot
    if (response.ok) { // If the response is successful (status code 200-299)
        console.log("Success! Database updated.");

        // Clean up reset everything back to normal
        document.getElementById("studentId").value = ""; // Clear the hidden studentId input field
        document.getElementById("submit").innerText = "Submit"; // Reset the button

        // Clear boxes so they are empty for the next person
        document.getElementById("name").value = "";
        document.getElementById("major").value = "";
        document.getElementById("targetRole").value = "";

        loadStudents(); // rebuild the table
    } else {
        console.error("The server rejected our data");
    }
});     
});

// A new method to grab all students from the database
function loadStudents() {
    // Reach out to Spring Boot server aka GET request pull from JSON array of students
    fetch("http://localhost:8082/api/students") // We send a GET request to this URL to get all students
    .then(function(response) { // This is a callback function that will run when we get a response from Spring Boot
        return response.json(); // We take the response and convert it from JSON string back into a JavaScript array of student objects
    })
    .then(function(data) { // This is another callback function that will run after we have converted the response to a JavaScript array}
        // print the array to the console to prove we got it
        console.log("Database Data: " , data);

        // Find the empty table body we made in HTML
        const tableBody = document.getElementById("studentTableBody");

        // Clear it out so we dont have duplicates when we load students multiple times
        tableBody.innerHTML = "";

        // Loop through every student in the array
        data.forEach(function(student) {

            // Create a brand new, empty HTML row
            const row = document.createElement("tr");

            // Build the HTML for the collumns using Template Literals, which are a way to create strings that can have variables inside them
            // Must be the same variable names as the ones in the Student class in Spring Boot
            row.innerHTML = `
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.major}</td>
            <td>${student.targetRole}</td>
            <td><button onclick="editStudent(${student.id}, '${student.name}', '${student.major}', '${student.targetRole}')">Edit</button> <!-- When the edit button is clicked, it will call the editStudent function and pass the student's information as parameters so we can populate the form with the existing student data to edit it -->
            <td><button onclick="deleteStudent(${student.id})">Delete</button>  <!-- student.id is the unique identifier for each student, we will use it to tell Spring Boot which student to delete when the button is clicked -->
            </td>
            `;
            // Drop the finished row into the HTML table body
            tableBody.appendChild(row);
        });
    });
}

// Run the function immediately as soon as the page loads to populate the table with students from the database
loadStudents();

// A new method to delete a student from the database
function deleteStudent(studentId) {

    fetch(`http://localhost:8082/api/students/${studentId}`, {
        method: "DELETE"
     })
     .then(function(response) {
        if (response.ok) {
            console.log("Student deleted successfully!");
            loadStudents(); // Call the function to refresh the list of students in the table to show that the student was deleted
        } else {
            console.error("Failed to delete student");
        }
     }); // We send a DELETE request to this URL to delete the student with the specified ID
}
// This function will be called when the edit button is clicked, it will populate the form with the existing student data so we can edit it and then submit the updated data to Spring Boot to update the student in the database
function editStudent(id, name, major, targetRole) {
    // Put the data back into visible text boxes so the user can edit it
    document.getElementById("name").value = name; 
    document.getElementById("major").value = major;
    document.getElementById("targetRole").value = targetRole;
    
    // Secretly save the ID into our hidden input box
    document.getElementById("studentId").value = id;

    // Change the text on the submit button to know we editing 
    document.getElementById("submit").innerText = "Update Student";

}


