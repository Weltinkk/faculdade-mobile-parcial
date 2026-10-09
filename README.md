# Mobile Parcial

## Objetivo do aplicativo

Aplicativo Android de ficha de treino. A tela inicial exibe uma lista de exercícios e, ao selecionar um item, o aplicativo abre uma tela de detalhe com um contador de séries.

## Como rodar localmente

### Pré-requisitos

- Android Studio Quail 2 (2026.1.2) ou mais recente. É a versão mínima compatível com o Android Gradle Plugin 9.3.3 usado no projeto, conforme a documentação oficial do Android (developer.android.com/build/releases/about-agp).
- JDK 25. O arquivo `gradle/gradle-daemon-jvm.properties` define `toolchainVersion=25` para o daemon do Gradle, e o `settings.gradle.kts` usa o plugin `org.gradle.toolchains.foojay-resolver-convention` para baixar o JDK automaticamente caso ele não esteja instalado.
- Gradle 9.5.0, baixado automaticamente pelo Gradle Wrapper (`gradle-wrapper.properties`).
- Emulador ou aparelho com Android API 24 (Android 7.0) ou superior, pois `minSdk = 24`. O projeto compila e tem como alvo a API 37 (`compileSdk = 37`, `targetSdk = 37`).

### Passos

1. Clonar o repositório.
2. Abrir a pasta do projeto no Android Studio (File > Open).
3. Aguardar o Gradle sync terminar.
4. Escolher um emulador ou aparelho na barra de dispositivos.
5. Clicar em Run.

O aplicativo não usa API externa, chaves de acesso nem arquivo `.env`. A internet só é necessária no primeiro sync, para baixar o Gradle, o JDK e as dependências.

## Bibliotecas externas

Dependências declaradas com `implementation` em `app/build.gradle.kts`:

| Biblioteca | Versão | Uso neste projeto |
|---|---|---|
| `androidx.appcompat:appcompat` | 1.8.0 | Fornece a `AppCompatActivity`, base das telas de lista e de detalhe. |
| `androidx.core:core-ktx` | 1.19.1 | Extensões Kotlin e utilitários de compatibilidade, como `ContextCompat`, `WindowInsetsCompat`, `isVisible` e `updatePadding`. |
| `com.google.android.material:material` | 1.14.0 | Fornece o tema `Theme.MaterialComponents.DayNight.DarkActionBar` usado pelo aplicativo. |
| `androidx.recyclerview:recyclerview` | 1.4.0 | Exibe a lista de exercícios na tela inicial, com `RecyclerView` e `LinearLayoutManager`. |
| `androidx.fragment:fragment-ktx` | 1.9.1 | Fornece `Fragment` e a extensão `commit`, usados para carregar o `DetalheFragment` na tela de detalhe. |
