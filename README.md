# Spring Base - A template for RESTful web services

This project serves as a robust foundation for building RESTful web services, particularly tailored for scenarios involving multiple entities with simple CRUD (Create, Read, Update, Delete) operations. With a modular architecture, it enables rapid prototyping and efficient implementation of backend services.

## Table of Contents
- [Structure](#structure)
- [Usage](#usage)
- [Future work](#future-work)

## Structure
This project follows a package-by-feature architecture. By organizing code by feature, we establish clear boundaries between different parts of the system while adhering to the Dependency Inversion Principle (DIP). Using interfaces or abstract classes to define contracts between features helps reduce direct dependencies on concrete implementations, promoting loose coupling.

Features are structured as cohesive units of functionality. By organizing code around features, we ensure that modules have a single responsibility, reducing the likelihood of interdependencies on internal details of other features.

We encourage the use of api and internal packages for each feature:
- The api package contains interfaces or abstract classes that define the contract a feature must fulfill. This approach reduces coupling and improves modularity.
- The internal package contains the concrete implementations and internal details of the feature. This separation of concerns ensures encapsulation and prevents unnecessary details from being exposed, reducing tight coupling between components.

By defining contracts within the api package, we create a clear boundary between a feature's external interface and its internal implementation details. Other parts of the system can interact with a feature through its public interface without needing knowledge of its internal workings. As a result, changes to a feature’s implementation have minimal impact on other parts of the system, enhancing maintainability.

![structure](https://github.com/solely-flerken/SpringBase/assets/154287017/f0a15641-9dc0-484a-9c59-18e121b4ddf2)

> [!NOTE]
> `BaseCRUDController`, `EntityDtoConverter` and `EntityDtoEditor` are predefined contracts which need an implementation for each feature.

## Usage
A simple application feature with CRUD functionality can be created in just a few steps.

For each of your features:
* Create the feature entity and data transfer object (DTO).
> [!IMPORTANT]
> Both **Entity** and **DTO** must extend their respective base classes: `BaseEntity` or `BaseDto`.
* Implement `BaseCRUDController`, `EntityDtoConverter`, `EntityDtoEditor` and a `JPARepository` with the respective types of the **Entity** and **DTO**
> [!TIP]
> To use Spring Boot's build-in dependency injection annotate implementations of `BaseCRUDController`, `EntityDtoConverter` and `EntityDtoEditor` with `@Service`

To create additional functionalities beyond CRUD operations while maintaining this structure: 
1. Define a contract for the controller of the desired feature.
2. Implement this contract in the corresponding `BaseCRUDController` implementation.
3. Follow the standard Spring Boot workflow for creating controllers.
4. Use the `EntityDtoConverter` and `EntityDtoEditor` implementations to support custom controller functionality.

## Future work
* [ ] Export as library
* [ ] Extend functionality
