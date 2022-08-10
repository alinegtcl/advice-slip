# advice-slip

Advice app using the public Advice Slip JSON API for practice.

And what's interesting about that?

- Dependency injection using Koin
- MVVM
- Clean Architecture
- Coroutines
- Monade Either, I made a Result with Success and Error, it's in a common directory
- LiveData and I took the opportunity to migrate to StateFlow
- Domain entity, shaping the response payload as I would need (mapper provided by interface and
  implemented in the data layer)

[comment]: <> (- Update improving the use case, I created a UseCase Interface so that it is necessary to implement the contract, thus injecting with qualifier and my viewmodel not knowing the implementation)

[comment]: <> (- Unit Testing &#40;including the UI&#41;)
