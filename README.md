# Low Level Design (LLD) — Java Notes

Concepts, design-pattern notes, and learnings collected while practicing Low
Level Design in Java.

## How patterns are organized

Design patterns live as **Java packages** under the three classic GoF
categories, each pattern in its own sub-package so the code stays isolated:

- `com.lld.creational.*` — how objects are created.
- `com.lld.structural.*` — how objects are composed into larger structures.
- `com.lld.behavioral.*` — how objects communicate and share responsibility.

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

### Observer (behavioral) — `com.lld.behavioral.ObserverPattern`
- **Idea:** Define a one-to-many dependency so that when one object (the
  *subject*) changes state, all its dependents (*observers*) are notified
  automatically — without the subject knowing their concrete types.
- **Here:** `Subject` keeps a `List<Observer>` (`addObserver`/`removeObserver`/
  `notifyObservers`). `WeatherData extends Subject`; its `setMeasurements(...)`
  calls `notifyObservers(this)`. `Observer` implementations `PhoneDisplay` and
  `TVDisplay` register themselves in their constructor (`addObserver(this)`) and,
  on `update(WeatherData)`, pull the latest values and re-`display()`.
- **Key move:** observers **register** with the subject and the subject only
  depends on the `Observer` interface — so new displays can be added without
  touching `WeatherData`.

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

### Singleton (creational) — `com.lld.creational.singleton`
- **Idea:** Guarantee a single instance with a global access point.
- **Here:** `AppConfig` uses the thread-safe *initialization-on-demand holder*
  idiom (`getInstance()` returns the one `Holder.INSTANCE`).

---

## Key learnings & gotchas

### Java packages & imports
- A class's `package` must match its folder path under `src/main/java`.
- **A sub-package is a *different* package.** `...DecoratorPattern.Decorator` is
  NOT automatically visible to `...DecoratorPattern`, and vice versa. You must
  `import` across every package boundary (this caused repeated
  `cannot find symbol` errors). Classes in the *same* package need no import.
- A broken parent class causes **cascading errors** in children — e.g. when
  `ToppingsDecorator extends BasePizza` failed to compile, the compiler also
  reported "CheeseToppings cannot be converted to BasePizza". Fix the root
  (missing import) and the downstream errors disappear.

### `abstract` class vs normal class
- **Normal (concrete):** can be `new`-ed; all methods have bodies.
- **Abstract:** cannot be `new`-ed; may have abstract methods (no body) that
  subclasses must implement, but can *also* have fields, constructors, and
  concrete methods. Use it as a shared, incomplete base (e.g. `BasePizza`).
- **Interface vs abstract class:** interface = pure capability contract, no
  constructors/instance state (e.g. `DriveStrategy`). Abstract class = shared
  state/implementation + contract (e.g. `BasePizza`, `ToppingsDecorator`).

### `extends` vs `implements`
- `extends` — inherit from **one** class (its code + state); "is a kind of".
- `implements` — adopt **many** interfaces (only a contract); "can do".
- Implementing an interface means you must define **every** method it declares
  (all overloads too) or the class stays abstract → compile error.
- Example: `WeatherData extends Subject`; `PhoneDisplay implements Observer`.

### Observer wiring
- Observer only works if observers actually **register** with the subject
  (`addObserver(this)`) *and* the `update(...)` method **copies the new data**.
  Forgetting either makes the notifications silently do nothing.

### Naming convention
- Java classes start with an uppercase letter (`Main`, not `main`). It compiles
  either way, but uppercase is idiomatic.

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
