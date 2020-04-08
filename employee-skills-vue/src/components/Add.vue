<template>
  <div id='main'>
      
     <div id='input-section'> 
        <form>
            First Name:<input id='employee-firstname' v-model='employee.firstName' /> <br><br>
            Last Name:  <input id='employee-lastname' v-model='employee.lastName' /> <br><br>
            Company Email: <input id='employee-company-email' v-model='employee.companyEmail' /> <br><br>
            Date of Birth: <input id='employee-birthDate' v-model='employee.birthDate' /> <br><br>
            Hire Date: <input id='employee-hireDate' v-model='employee.hireDate' /> <br><br>
            Role:  <select id='employee-role' v-model='employee.role'>   
                <option value='Technical Consultant' v-bind='employee.role'>Technical Consultant</option>    
                <option value='Project Manager' v-bind='employee.role'>Project Manager</option>
                <option value='Director' v-bind='employee.role'>Director</option>   
                <option value='Chief ' v-bind='employee.role'>Chief </option>                
            </select> <br> <br>  
            <button id='emp-add-btn' v-on:click='saveEmployee'>Add Employee</button>
        </form>
      </div>
  </div>
</template>

<script>
export default {

    data() {
        return { 
            employee: {
              
                firstName: '',
                lastName:'',  
                companyEmail: '',
                birthDate: '',
                hireDate: '',
                role: ''   
            }
        };
    },
    methods: {
        saveEmployee() {
            fetch('http://localhost:8080/EmployeeSkills/api/employees',
                {
                method: 'POST',
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(this.employee)
            })
            .then (
                () => {window.alert('employee added');}
            )
            .catch(
                (err) => {console.error(err + 'ERROR. Employee was not added'); }
            )
        }

    }
}
</script>

<style>
    #input-section {
        display: inline-block;
        background-color: rgba(189, 0, 0, 0.952);
        text-align:center;
        color: white;
        margin: 20px;
        padding: 20px;
        width: 30%;
    }
</style>