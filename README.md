# Spring Base - A template for RESTful web services

This project serves as a robust foundation for building RESTful web services, particularly tailored for scenarios involving multiple entities with simple CRUD (Create, Read, Update, Delete) operations. With a modular architecture it enables rapid prototyping and efficient implementation of backend services.

## Table of Contents
- [Structure](#structure)
- [Usage](#usage)
- [Future work](#future-work)

## Structure
This project has a package by feature architecture. By organizing code by feature, we define clear boundaries between different parts of the system. While also following Dependency Inversion Principles (DIP) and using either interfaces or abstract classes to define contracts between features we reduce direct dependencies on concrete implementations and promoting loose coupling. Features tend to be cohesive units of functionality. By organizing code around features, we're more likely to have modules that are focused on a single responsibility which reduces the likelihood of other parts of the system depending directly on internal details of a different feature.

We promote the use of `api` and `internal` packages for each feature. Wherein `api` packages contain interfaces or abstract classes of a feature defining a contract it needs to fulfill. Subsequently leading to reduced coupling and improved modularity.

By having an `api` package that contains interfaces or abstract classes defining the contract for a feature, you establish a clear boundary between the external interface of the feature and its internal implementation details. This allows other parts of the system to interact with the feature through its public interface without needing to know about its internal implementation. As a result, changes to the internal implementation of a feature are less likely to have cascading effects on other parts of the system, reducing coupling and making the system more maintainable.

The `internal` package, on the other hand, contains the concrete implementations and internal details of the feature. This separation of concerns ensures that implementation details are hidden from external dependencies, promoting encapsulation and reducing the risk of exposing unnecessary details or creating tight coupling between components.

![structure](https://github.com/solely-flerken/SpringBase/assets/154287017/f0a15641-9dc0-484a-9c59-18e121b4ddf2)

> [!NOTE]
> `BaseCRUDController`, `EntityDtoConverter` and `EntityDtoEditor` are defined contracts which need an implementation for each feature.

## Usage
A simple application feature with CRUD functionality can be created in few steps.

For each of your features:
* Create the feature entity and data transfer object (DTO)
> [!IMPORTANT]
> Both entity and dto need to extends their base class either `BaseEntity` or `BaseDto`
* Implement `BaseCRUDController`, `EntityDtoConverter`, `EntityDtoEditor` and a `JPARepository` with the respectives types of the entity and dto
> [!TIP]
> To use Spring Boots build in dependency injection we've to annotate implementations of `BaseCRUDController`, `EntityDtoConverter` and `EntityDtoEditor` with `@Service`

To create other functionalities besides CRUD operations while following our structure we start by defining a contract for the controller of the desired feature. We then also implement this contract in our implementation of the `BaseCRUDController`. From there on we follow the basic Spring Boot workflow for creating controllers. We can use the implementation of `EntityDtoConverter` and `EntityDtoEditor` for the custom controller functionality.

## Future work
[ ] Export as library
[ ] Extend functionality
