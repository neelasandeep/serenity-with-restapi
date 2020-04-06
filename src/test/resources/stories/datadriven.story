Meta:
@test1
Narrative:
As a user
I want to navigate vto the Group head Dashboard page
So that I can pervform all the validation on the dashboard page.


Lifecycle:
Before:
Scope: STEP
Given user have a request for posting student data



Scenario: GH_0777To datadriven test
Meta:

When user perform post operation on given request DataDriven way from external source:
| firstName    | lastName       | email                                     | programme        | course |
| Declann       | Smithh          | nnon.aniouittpre.blrlduflscchum@risusDonecegestas.edu  | Computer Science | Java    |


Then user will verify status code as 201

Scenario: Put update method checking for studnet record
Meta:

When user perform put operation on Student id:
| firstName    | lastName       | email                                     | programme        | course |
| Neelakatreraja       | Sandeep          | nnon.anddtrie.biernhdum@risuttsDonecegestas.edu  | Computer Science | Java    |
Then Student record should update in the application
And statusCode shpuld be 200

Scenario: deleting the studenet based on id
Meta:

When user delete the student based on id 156
Then statusCode shpuld be 204