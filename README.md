<h1>This repo demonstrates issues while migrating a simple room project from KAPT to KSP when using inheritance/generics for Entity.</h1>

Branches:

`main` : This uses KAPT processor. No issues compiling

`dennym/migrate-to-ksp`: This attempts a migration to KSP processor. Compilation fails for using generic types.
Some of the errors for compiled dao impl file:

```
e: file:///Users/denny.mathew/../SampleDao_Impl.kt:109:44 Unresolved reference 'Entity'.
e: file:///Users/denny.mathew/../SampleDao_Impl.kt:112:26 Cannot infer type for type parameter 'Entity'. Specify it explicitly
```

