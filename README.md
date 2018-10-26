# Parcial 2 corte


[Link a Heroku](https://damp-mountain-86548.herokuapp.com/).
[Link a github](https://github.com/nicoga97/Parcial-ARSW).

 

# Diseño

  - El diseño de esta  aplicacion implementa el principio open closed  por lo que presenta una gran facilidad al momento de extender ya que se utilizaron abstracciones al momento de la creacion lo que permite un bajo acoplamiento por ejemplo en el caso de la persistencia hay una interface llamada WeatherAppPersistence, por lo tanto al moemnto de cambiar de persistencia (en memoria, base de datos, etc) solo se implementa esta clase al nuevo modelo de persistencia y gracias a la injeccion de dependencias implementada con las antaciones en springboot  solo cambiando una anotacion se cambia la persistencia lo cual lo hace altamente extendible y este caso se presenta en los servicios del api creado es una interface.
