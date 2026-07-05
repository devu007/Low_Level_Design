# Low Level Design (LLD) — Java Practice

A workspace for learning Low Level Design and design patterns in Java.

## Prerequisites

- **JDK 21** (Eclipse Temurin) — installed portably (no admin) at
  `%USERPROFILE%\tools\jdk-21.0.11+10`, exposed via the `JAVA_HOME` user variable.
- **Maven 3.9.9** — installed portably at `%USERPROFILE%\tools\apache-maven-3.9.9`
  and on the user `PATH`. The project also ships the **Maven Wrapper** (`mvnw`),
  so builds are self-contained.
- **Cursor Java extensions** — recommended in `.vscode/extensions.json`
  (open the Extensions panel and install the recommended ones when prompted).

> After the tools were installed, **reload Cursor** (Command Palette →
> "Developer: Reload Window") once so terminals pick up `JAVA_HOME`/`PATH`.

## Project structure

```
LLD/
├── pom.xml                         # dependencies (JUnit) + build config
├── src/
│   ├── main/java/com/lld/
│   │   ├── Main.java               # playground entry point
│   │   ├── creational/             # Singleton, Factory, Builder, ...
│   │   │   └── singleton/          # AppConfig (Singleton example)
│   │   ├── structural/             # Adapter, Decorator, Proxy, ...
│   │   │   └── DecoratorPattern/   # BasePizza + Decorator/ toppings
│   │   └── behavioral/             # Strategy, Observer, Command, ...
│   │       └── StrategyPattern/    # Vehicle + Strategy/ drive strategies
│   └── test/java/com/lld/          # JUnit tests mirror the main structure
└── .vscode/                        # Cursor editor + extension config
```

Design patterns are organized as **Java packages** under the three classic
categories (creational / structural / behavioral). Each pattern lives in its
own sub-package so the code stays isolated and easy to browse.

## Common commands

Run these from the `LLD` folder:

```bash
# Compile everything
./mvnw compile

# Run the Main playground
./mvnw -q compile exec:java

# Run a specific class
./mvnw -q compile exec:java -Dexec.mainClass="com.lld.creational.singleton.AppConfig"

# Run all tests
./mvnw test
```

On Windows PowerShell, use `.\mvnw.cmd` instead of `./mvnw`.

Inside Cursor you can also just click the **Run** / **Debug** code lens that
appears above any `main` method or `@Test`.

## Adding a new pattern

1. Create a package, e.g. `src/main/java/com/lld/behavioral/strategy/`.
2. Add your classes/interfaces there.
3. (Optional) Add a matching test under `src/test/java/com/lld/behavioral/strategy/`.
4. Demo it from `Main.java` or run its own `main` method.

---

## Patterns implemented

### Strategy (behavioral) — `com.lld.behavioral.StrategyPattern`
- **Idea:** Define a family of interchangeable algorithms behind a common
  interface and let a class delegate to one at runtime (favor **composition
  over inheritance**).
- **Here:** `DriveStrategy` (interface) → `NormalDriveStrategy`,
  `SportsDriveStrategy`. A `Vehicle` *holds a* `DriveStrategy` and calls
  `driveStrategyObject.drive()`. `GoodsVehicle`/`SportsVehicle` pick a strategy.
- **Why it beats inheritance:** without Strategy, every new vehicle type that
  shares behavior forces you to duplicate/override methods. Strategy swaps
  behavior by plugging in a different object.
- **Run:** `.\mvnw.cmd -q compile exec:java "-Dexec.mainClass=com.lld.behavioral.StrategyPattern.main"`

### Decorator (structural) — `com.lld.structural.DecoratorPattern`
- **Idea:** Attach responsibilities to an object dynamically by wrapping it.
  Both the concrete object and the wrappers share the same base type, so
  wrappers can be stacked endlessly.
- **Here:** abstract `BasePizza` (defines `cost()`) → concrete `MargheritaPizza`,
  `VeggiePizza`; abstract `ToppingsDecorator extends BasePizza` →
  `CheeseToppings`, `MushroomTopping`. Each topping *wraps a* `BasePizza` and
  adds to `cost()`. `new MushroomTopping(new CheeseToppings(new MargheritaPizza()))`
  → 100 + 10 + 15 = **125**.
- **Key move:** the decorator both **extends** the base type (so it *is-a*
  pizza) and **holds** one (so it can *wrap* a pizza).
- **Run:** `.\mvnw.cmd -q compile exec:java "-Dexec.mainClass=com.lld.structural.DecoratorPattern.main"`

### Singleton (creational) — `com.lld.creational.singleton`
- **Idea:** Guarantee a single instance with a global access point.
- **Here:** `AppConfig` uses the thread-safe *initialization-on-demand holder*
  idiom (`getInstance()` returns the one `Holder.INSTANCE`). See `AppConfigTest`.

---

## Key learnings & gotchas

### Java packages & imports (the #1 thing that bit me)
- A class's `package` must match its folder path under `src/main/java`.
- **A sub-package is a *different* package.** `...DecoratorPattern.Decorator` is
  NOT automatically visible to `...DecoratorPattern`, and vice versa. You must
  `import` across every package boundary (this caused repeated
  `cannot find symbol` errors).
- A broken parent class causes **cascading errors** in children — e.g. when
  `ToppingsDecorator extends BasePizza` failed to compile, the compiler also
  reported "CheeseToppings cannot be converted to BasePizza". Fix the root
  (missing import) and the downstream errors disappear.
- Tip: install the Red Hat Java extension so imports auto-complete and errors
  surface live in the editor instead of at `mvn compile` time.

### `abstract` class vs normal class
- **Normal (concrete):** can be `new`-ed; all methods have bodies.
- **Abstract:** cannot be `new`-ed; may have abstract methods (no body) that
  subclasses must implement, but can *also* have fields, constructors, and
  concrete methods. Use it as a shared, incomplete base (e.g. `BasePizza`).
- **Interface vs abstract class:** interface = pure capability contract, no
  constructors/instance state (e.g. `DriveStrategy`). Abstract class = shared
  state/implementation + contract (e.g. `BasePizza`, `ToppingsDecorator`).

### Running & environment
- The main class is always `<package>.<ClassName>`, e.g.
  `com.lld.structural.DecoratorPattern.main`.
- `-Dexec.mainClass` only overrides the default because `pom.xml` uses
  `<mainClass>${exec.mainClass}</mainClass>` (a hardcoded value would ignore it).
- **"JAVA_HOME is not defined correctly"** just means the terminal was opened
  before the tools were installed. Open a new terminal / reload Cursor, or set
  it for the current session:
  ```powershell
  $env:JAVA_HOME = "$env:USERPROFILE\tools\jdk-21.0.11+10"; $env:Path = "$env:JAVA_HOME\bin;$env:USERPROFILE\tools\apache-maven-3.9.9\bin;$env:Path"
  ```
- **Java naming convention:** classes start with an uppercase letter
  (`Main`, not `main`). It compiles either way, but uppercase is idiomatic.

---

## Design pattern cheat sheet

The three GoF categories:

- **Creational** — *how objects are created.* Singleton, Factory Method,
  Abstract Factory, Builder, Prototype.
- **Structural** — *how objects are composed into larger structures.* Adapter,
  Bridge, Composite, Decorator, Facade, Flyweight, Proxy.
- **Behavioral** — *how objects communicate/share responsibility.* Strategy,
  Observer, Command, State, Template Method, Iterator, Chain of Responsibility,
  Mediator, Memento, Visitor, Interpreter.

Guiding principles worth keeping in mind (SOLID):
- **S**ingle Responsibility · **O**pen/Closed · **L**iskov Substitution ·
  **I**nterface Segregation · **D**ependency Inversion.
- Recurring themes: *favor composition over inheritance*, *program to an
  interface, not an implementation*, *encapsulate what varies*.
