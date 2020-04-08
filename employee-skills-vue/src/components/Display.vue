<template>
<div id='main'>

    <div class='employee-info' v-for='employee in allEmployees' :key='employee.employeeID'>
     
        Employee First Name: {{employee.firstName}} <br>
        Employee Last Name: {{employee.lastName}} <br>
        Employee Email: {{employee.companyEmail}} <br>
        Employee Date of Birth: {{employee.birthDate}} <br>
        Employee Hire Date: {{employee.hireDate}} <br>
        Role:  {{employee.role}} <br>

      
    <router-link :to="{name: 'display-detail', params: {employeeID: employee.employeeID}}"> Edit Employee Data </router-link><br><br>
    </div>

</div>
  
</template>

<script>
export default {
    data() { 
        
        return { allEmployees : []}
    },

  created() {
    fetch( 'http://localhost:8080/EmployeeSkills/api/employees')
    .then (
      (response) => {return response.json();}
    )
    .then ( 
        (employee) => {this.allEmployees = employee;}
    )
    .catch(
        (err) => {console.error(err + 'ERROR!'); }
    )
  }
}

</script>
<style>

  #employee-info {
    margin: 20px;
    width: 50%;
    background-color: white;
  }

</style>