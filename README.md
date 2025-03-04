# Jader Munoz Marzo

## Descripción General

Esta es una aplicación móvil desarrollada para la startup MY WALLET. La aplicación es una billetera virtual enfocada en mantener la moneda Bitcoin. La app está desarrollada en Kotlin e incluye características como una pantalla de bienvenida, inicio de sesión y obtención de valores de Bitcoin desde una API.

## Características

1. **Pantalla de Bienvenida**: Muestra una animación de bienvenida relacionada con indicadores económicos o la billetera virtual.
2. **Inicio de Sesión**: Permite a los usuarios iniciar sesión con un nombre de usuario y contraseña. La app muestra un mensaje de bienvenida con el nombre de usuario obtenido de las preferencias de usuario.
3. **Gestión de Sesiones**: Si el usuario ya ha iniciado sesión, la app no solicita credenciales nuevamente al reabrirla.
4. **Cerrar Sesión**: Proporciona un botón para cerrar sesión y borrar la sesión del usuario.
5. **Valores de Bitcoin**: Obtiene los valores de Bitcoin desde la API `https://mindicador.cl/api/bitcoin` y los muestra en una lista.

## Estructura del Proyecto

- **`MainActivity.kt`**: La actividad principal que configura el tema y la estructura básica de la interfaz de usuario.
- **`SplashScreenActivity.kt`**: Muestra la pantalla de bienvenida con una animación Lottie.
- **`LoginActivity.kt`**: Gestiona la pantalla de inicio de sesión donde los usuarios pueden ingresar sus credenciales.
- **`HomeActivity.kt`**: Muestra la pantalla principal después del inicio de sesión, incluyendo un mensaje de bienvenida y una lista de valores de Bitcoin.
- **`UserPreferences.kt`**: Maneja las preferencias de usuario para guardar, obtener y borrar el nombre de usuario.
- **`BitcoinData.kt`**: Define la estructura de los datos de Bitcoin obtenidos de la API.

## Dependencias

- **Lottie**: Para mostrar animaciones en la pantalla de bienvenida.
- **Kotlin Coroutines**: Para manejar tareas asíncronas como la obtención de datos desde la API.

## Configuración

1. Clona el repositorio.
2. Abre el proyecto en Android Studio.
3. Asegúrate de tener las dependencias necesarias en tu archivo `build.gradle`:
    ```groovy
    dependencies {
        implementation 'com.airbnb.android:lottie:5.2.0'
        implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2'
    }
    ```
4. Coloca tu archivo de animación Lottie (`anim.json`) en el directorio `src/main/assets`.
5. Compila y ejecuta el proyecto en un dispositivo o emulador Android.

## Uso

1. Inicia la aplicación para ver la pantalla de bienvenida.
2. Inicia sesión con tu nombre de usuario y contraseña.
3. Ve el mensaje de bienvenida y la lista de valores de Bitcoin.
4. Usa el botón de cerrar sesión para borrar la sesión.

## API

La app obtiene los valores de Bitcoin desde el siguiente endpoint de la API:
- `https://mindicador.cl/api/bitcoin`

## Licencia

Este proyecto está licenciado bajo la Licencia MIT.
