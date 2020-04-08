<template>

<div id='main'>
  Selected Employee:
 {{employee.firstName + ""}}{{employee.lastName}}<br>

 Employee First Name: <input type='text' v-model='employee.firstName'/> <br>
 Employee Last Name:<input type='text' v-model='employee.lastName'/> <br>
 Email: <input type='text' v-model='employee.companyEmail'/> <br>
 Birth Date: <input type='text' v-model='employee.birthDate'/> <br>
 Hire Date:<input type='text' v-model='employee.hireDate'/> <br>
 Role: <select id='employee-role' v-model='employee.role'>
        <option value='Technical Consultant' selected v-bind='employee.role'>Technical Consultant</option>    
          <option value='Project Manager' v-bind='employee.role' >Project Manager</option>
                <option value='Director' v-bind='employee.role'>Director</option>   
                <option value='Chief ' v-bind='employee.role'>Chief </option>    
    </select> <br><br>


    <button id='update-btn' v-on:click='updateEmployee (employee.employeeID)'>Update Employee</button>
    <!-- Delete button - could not get to fully function -->
  <!-- <button id='delete-btn' v-on:click='deleteEmployee (employee.employeeID)'>Delete Employee</button> -->
    </div>

</template>


<script>
export default {
    data() {
        
        return {
            employee : {}
        }
    },
    methods: 
    {
        getEmployee(employeeID) {

            fetch(`http://localhost:8080/EmployeeSkills/api/employees/${employeeID}`)
            .then (
                (response) => {return response.json();}
            )
            .then ( 
                (employeeData) => {this.employee = employeeData;}
            )
            .catch(
                (err) => {console.error(err + ' No employee found'); }
            )
        },

        updateEmployee(employeeID) {
             fetch(`http://localhost:8080/EmployeeSkills/api/employees/${employeeID}`,
                {
                method: 'PUT',
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(this.employee)
            })
            .then(
                () => {window.alert('Employee information updated');}
            )
            .catch(
                (err) => {console.error(err + 'Cannot update Emloyee'); }
            )
        },
        

    },
     //  deleteEmployee(employeeID) {
        //  fetch(`http://localhost:8080/EmployeeSkills/api/employees/${employeeID}`,
        //    {
        //      method: 'DELETE',
        //     headers: {
        //         "Content-Type": "application/json"
        //     },
        //   body: JSON.stringify(this.employee)
        //    })
        //    .then(
        // () => {window.alert('Employee has been deleted');}
        //    )
        //   .catch(
        //        (err) => {console.error(err + 'ERROR. Employee can not be deleted'); }
        //     )
        //    },

    
    created() {
        console.log(this.$route.params.employeeID);
        this.getEmployee(this.$route.params.employeeID);
    }
}
</script>