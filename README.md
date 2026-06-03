# Ejr_Nro_15_Framework_JSON
Ejercicio numero 15 de la guia practica de Java
# Consigna
Es necesario representar una estructura de datos en formato Json. JSON, acrónimo de
JavaScript Object Notation, es un formato de texto ligero para el intercambio de datos.
JSON es un subconjunto de la notación literal de objetos de JavaScript aunque hoy,
debido a su amplia adopción como alternativa a XML, se considera un formato de
lenguaje independiente.
Los elementos en json pueden ser:
• Los objetos en notación json comienzan con { y terminan con } y pueden tener
atributos y sus valores (los valores pueden ser otro elemento json) puede contener n
atributos.
• Los arreglos en json comienzan con [ y terminan con ], pueden contener n elementos
json separados por coma.
• Un valor que es un string.
Se debe poder modelar una estructura en json e imprimirlo de manera correcta.
Un ejemplo de una estructura en json:
{“company” : “Example” ,
"employees":[
{"firstName":"John", "lastName":"Doe"},
{"firstName":"Anna", "lastName":"Smith"},
{"firstName":"Peter", "lastName":"Jones"}
]}
# Logica de Negocio Principal
Vamos a hacer un objeto JSON que tenga un diccionario que de clave posea un String y de valor un generico que pueda ser String, Int, otro JSON o un vector que sea combinacion de esos 3. Tenemos que ver como podemos hacer genericos que se limiten a tipos especificos de datos. Vamos a tener que crear la interfaz JSON para que sepa que puede poseerla y de ahi sacamos el composite de paso. 