# Spring Base - A template for RESTful web services

This project can be used as a starting point for some RESTful web services, which are especially using mutiple entities which all implement simple CRUD operations.

## Usage
Simply fork this project or download the source code and change the code based on your needs.
A simple endpoint with complete CRUD functionality can be created in few steps.

Create an endpoint with CRUD functionality only:
* Create the entity extending BaseEntity
* Create the dto extending BaseDto
* Create a Repository for the entity
* (Optional) Create a package, for good structure
* Create a class extending BaseCRUDController<entity, dto> with the created dto and entity as the generic types. Annotate the controller with @RestController and @RequestMapping("/api/v1/your_path")
* Create a class annoted with @Service implementing EntityDtoConverter<entity, dto>
* Create a class annoted with @Service implementing EntityDtoEditor<entity, dto>

Create an endpoint with CRUD and custom functionality. Do everything mentioned above and the following additional steps.
* Create an interface in the controller package and define your custom functionalities
* In the created class which extends BaseCRUDController<dto, entity> implement the just created interface and implement the custom functions.

Create an endpoint without CRUD functionality (from the template, but it still can be implemented manually):
* Create the entity, optionally extending BaseEntity
* (Optional) Create the dto, optionally extending BaseDto
* Create a Repository for the entity
* (Optional) Create a package, for good structure)
* (Optional) Create an interface in the controller package and define your custom functionalities
* Create a class, optionally implementing the interface. Annotate the controller with @RestController and @RequestMapping("/api/v1/your_path")
* (Optional) Create a class annoted with @Service implementing EntityDtoConverter<entity, dto>
* (Optional) Create a class annoted with @Service implementing EntityDtoEditor<entity, dto>

## Structure
The project is structured in a specific way.
* src
  * api
    * controller
      * your_functionality_controller_api
        
        Here you define your custom controllers as interfaces.
    * dto
      * your_dto
        
        Here you define your custom dtos extending `BaseDto`. Annotate accordingly.
  * internal
    * model
      * your_entity
        
        Here you define your custom entity extending `BaseEntity`. Annotate accordingly.
    * your_functionality
      * api
        * your_functionality_service_api
          
          Here you define the outline of your custom business logic. Don't do that in your custom controllers.
      * internal
        * your_functionality_package   
          * your_functionality_controller
            
            Depending if you want to use basic CRUD functionality you extend this class with `BaseCRUDController<your_entity, your_dto>` or implement a custom interfaces. Should be annotated with `@RestController` and `@RequestMapping("/api/v1/your_path")`.
          * your_functionality_editor
            
            This class implements `EntityDtoEditor<your_entity, your_dto>` and is used to define specific behaviour when updating an entity. Should be annotated with `@Service`.
          * your_functionality_mapper
            
            This class implements `EntityDtoConverter<your_entity, your_dto>` and is used to keep the entity internal and to only expose the dto to the api. Should be annotated with `@Service`.
          * your_functionality_repository
            
            This is a simple JPA Repository with your_entity as the generic type. Should be annotated with `@Repository`.
          * your_functionality_service
            
            This class implements the your_functionality_service_api interface and holds the business logic of your applications custom functionality. Should be annotated with `@Service`.
