# Non-Blocking I/O
Two simple applications (it may be one application which operates in two modes) which
communicate with each other by saving and reading data from a shared file mapped with into memory.
One of the application saves some data – e.g. two integer values. The other application
retrieves the data and perform some operation – e.g. adding the values read – and then print out the result to the console.
