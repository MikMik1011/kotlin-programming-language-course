package exercise9

import common.FileReader

fun parseEmployees(employeesCSVLines: List<String>): List<Employee> {
    return employeesCSVLines.
            drop(1).
            map {
                val components = it.split(",")
                val id = EmployeeID(components[0].trim())
                val name = components[1].trim()
                val department = Department(components[2].trim())
                val salary = components[3].trim().toInt()
                val skills = components[4].split("|")
                Employee(id, name, department, salary, skills)
            }
}

fun newEmployeeApi(employees: List<Employee>): EmployeeApi {
    return Employees(employees)
}

fun main() {
    val employeesCSVLines = FileReader.readFileInResources("exercise9/employees.csv")
    val employees = parseEmployees(employeesCSVLines)

    val employeeApi : EmployeeApi = newEmployeeApi(employees)
}
