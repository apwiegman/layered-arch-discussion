# Layered Arch Discussion
The purpose of this application is to facilitate discussion around the finer points of implementing a layered architecture.
The following points I would like clarified from the "layered architecture gurus":
* service to service call. An example is shown in transaction service where we need to call the fee service to 
calculate the fee for that specific transaction. Service to service calls return a DTO per previous weeks conversations - 
Is this correct? If a service needs an entity and not a DTO it goes via the repository (also shown in transaction service with retrieval of a bank account entity)?
* I understand clients are cross-cutting in layered architecture - although I really struggle to see a scenario where they 
would be called from anywhere other than a service. Here I've set up a few reasonable examples - get rates, publish kafka 
event etc. Is this a reasonable set up?
* Mapping for DTOs - where should these mappers reside. There may be better ways of doing mapping - happy to hear suggestions.
* Schedulers - where would they sit. I've set up a example scheduler for sake of discussion. 
* Async consumers (Kafka or SQS pollers). I've put them in the api folders cause they are technically async apis. Thoughts/ 
what do layered gurus say? Should they rather go in clients although I like to see clients as something we depend on and call out to.


Disclaimer - lets not get distracted by the quality of the Java code (still trying adapt from Kotlin), but rather focus 
on the principals, structure and layout.

