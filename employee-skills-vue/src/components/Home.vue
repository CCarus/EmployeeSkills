<template>
<div>
      <div class='employee-info' v-for='employee in allEmployees' :key='employee.id'>

       Employee First Name: {{employee.firstName}} <br>
        Employee Last Name: {{employee.lastName}} <br>
        Employee Email: {{employee.companyEmail}} <br>
        Employee Date of Birth: {{employee.birthDate}} <br>
        Employee Hire Date: {{employee.hireDate}} <br>
        Role:  {{employee.role}} <br>
        
        <router-link :to="{name: 'display-detail', params: {id: employee.id}}"> update Employee </router-link><br><br>
    
    </div>
</div>
</template>

<script>
export default {
  name: 'Home',

}
</script>
