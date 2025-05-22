
To-Do App (Evaluación Técnica Android)

Aplicación Android desarrollada en Kotlin que consume y almacena tareas (`ToDos`) utilizando arquitectura MVVM, persistencia local con Room, consumo de API con Retrofit y buenas prácticas de diseño de código y UI.

---

🎯 Objetivo

Mostrar tus habilidades técnicas en Android con Kotlin, MVVM, consumo de API REST, Room, ViewBinding y Hilt para inyección de dependencias.

---

📱 Características Funcionales

- Consume el API de ToDos desde: https://jsonplaceholder.typicode.com/todos
- Muestra las tareas en tarjetas (RecyclerView) con CheckBox editable
- Cachea los datos en Room: si ya existen localmente, no vuelve a llamar al API
- Permite marcar/desmarcar tareas como completadas (actualización local)
- Permite eliminar tareas con una pulsación larga
- Muestra un mensaje claro si no hay conexión, y permite seguir en modo offline

---

🧱 Arquitectura y Organización del Código

El proyecto sigue el patrón MVVM + Repository con separación de capas y responsabilidades.

## 📂 Estructura

```text
prueba.practica/
├── data/
│   ├── local/        # Room (DAO, Entity, Database)
│   ├── remote/       # API, Retrofit, DTO
│   └── repository/   # ToDoRepository.kt
│
├── ui/
│   ├── adapter/      # ToDoAdapter (RecyclerView)
│   ├── screen/       # ToDoScreen.kt (controlador de UI)
│   └── viewmodel/    # ToDoViewModel.kt
│
├── MainActivity.kt   # Entrada de la app, delega a ToDoScreen
└── MyApplication.kt  # Inicializa Hilt
```


---
⚙️ Tecnologías y Librerías

Componente         | Librería
-------------------|---------------------------------------------
Arquitectura       | MVVM, ViewModel, LiveData
Persistencia       | Room (room-runtime, room-ktx)
Red/API            | Retrofit + Moshi + OkHttp
UI                 | RecyclerView, MaterialCardView, ViewBinding
Inyección de dependencias | Hilt (dagger-hilt)
Asincronía         | Kotlin Coroutines
Diseño             | Material Design + Theme.MaterialComponents

---

🛠️ Decisiones Técnicas

- ViewBinding: para mayor seguridad de tipo y claridad en la UI.
- Hilt: para inyección limpia de repositorios y DAOs.
- DiffUtil + ListAdapter: para un RecyclerView eficiente y fluido.
- ToDoScreen.kt: separamos la lógica de UI de MainActivity para cumplir con el principio de responsabilidad única (SRP).
- Modo offline: mediante caché local y verificación de conectividad antes de consumir la API.

---

🧪 Cómo probar la app

1. Compilar y ejecutar en un dispositivo real o emulador con API 23 o superior.
2. Permisos necesarios:
   - INTERNET
   - ACCESS_NETWORK_STATE
3. Al iniciar:
   - Si hay conexión: se descargan los datos.
   - Si no hay conexión: se carga la base local.
4. Interacciones:
   - Tocar CheckBox para marcar tarea completada.
   - Mantener pulsado para eliminar tarea.

---

🧯 Problemas encontrados y soluciones

❌ Checkboxes se marcaban/desmarcaban al hacer scroll
- Causa: setOnCheckedChangeListener reaccionaba a cambios programáticos.
- Solución: se desasoció el listener antes de actualizar isChecked.

❌ Lag y parpadeo en scroll
- Causa: uso de notifyDataSetChanged().
- Solución: se implementó DiffUtil con ListAdapter.

❌ Crash al inflar MaterialCardView
- Causa: tema incorrecto (AppCompat).
- Solución: el tema fue cambiado a Theme.MaterialComponents.DayNight.

❌ SecurityException por permisos
- Faltaban:
  - INTERNET
  - ACCESS_NETWORK_STATE
- Solución: agregados en el AndroidManifest.xml.

---

💡 ¿Qué haría diferente en un proyecto real?

- Implementaría capa de dominio (clean architecture).
- Usaría Flow o StateFlow para reactividad más robusta.
- Incluiría creación y edición de tareas con formularios.
- Modo oscuro, accesibilidad, animaciones y diseño más responsive.

---

📦 Entregables

- APK firmado (con clave de release, no de debug)
- Código fuente
- Este README.md

---

🙌 Gracias

Proyecto realizado como parte de una evaluación técnica Android con Kotlin.
