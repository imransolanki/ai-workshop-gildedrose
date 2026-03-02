
This repository contains two small, self-contained refactoring exercises in Java:
- `gildedrose` (legacy imperative logic in `updateQuality()`)

Follow these targeted rules when generating or changing code:

**Build & test**
- Project uses Maven and Java 11. Build and run tests with: `mvn test`.
- Test reports appear under `target/surefire-reports`.
- The `pom.xml` sets `source`/`target` to 11. See [pom.xml](pom.xml#L1-L40).

**Big picture & intent**
- Two separate exercises live under `src/main/java`: [gildedrose](src/main/java/gildedrose) .
- The objective is to refactor for clarity while preserving existing behavior and test outputs — this repo is a refactoring workshop, not a feature app.

**Key files to reference**
- Gilded Rose example: [src/main/java/gildedrose/GildedRose.java](src/main/java/gildedrose/GildedRose.java#L1-L200) and [src/main/java/gildedrose/Item.java](src/main/java/gildedrose/Item.java#L1-L120).

**Project-specific patterns & constraints**
- Tests (and exercises) expect exact string outputs and legacy behaviors. Preserve literal formatting in `Customer.statement()` (e.g. the header "Rental Record for <name>", tab spacing and footer lines) unless you update tests accordingly.
- The `gildedrose` codebase relies on string equality checks against `Item.name` (e.g. "Aged Brie", "Backstage passes..."). If refactoring these checks, provide an adapter that preserves current behavior.

**Coding style & workflow expectations**
- Prefer small, well-named methods when extracting behavior from large switch/case blocks (examples: `Customer.statement()` in [movierental/Customer.java](src/main/java/movierental/Customer.java#L23-L64) and `GildedRose.updateQuality()` in [gildedrose/GildedRose.java](src/main/java/gildedrose/GildedRose.java#L10-L60)).
- Follow incremental refactoring: make small, verifiable changes tested between each step. This aligns with Martin Fowler's "Refactoring" methodology.
- Always run `mvn test` after edits and include tests or updated assertions with refactor commits.

**Testing guidance**
- Tests use JUnit 4.12 (pom declares junit:4.12). Run all tests with `mvn test`. To run a single test class: `mvn -Dtest=movierental.CustomerTest test`.
- Tests verify exact string outputs. For example, [CustomerTest.java](src/test/java/movierental/CustomerTest.java#L18-L27) expects precise formatting including tab characters, newlines, and specific wording.
- Test reports are generated in `target/surefire-reports` after running `mvn test`.
- If you modify public method signatures, update the tests in the same change to keep the commit self-consistent.

**What to avoid**
- Do not change string outputs or numeric behaviors in separate commits without updating tests; the exercises rely on preserved behavior.
- Avoid global renames that mix both exercises in one PR — keep `gildedrose` and `movierental` changes scoped.

If anything here is unclear or you'd like more examples (e.g., suggested refactor steps for `Customer.statement()` or `GildedRose.updateQuality()`), tell me which file to expand with inline guidance.
