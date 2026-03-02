# Copilot Instructions - Refactoring Project

This repository contains refactoring exercises in Java. This file provides quick navigation to all AI agent guidance documents.

## Documentation Structure

### **Start Here: Project Context**
→ [**Tech Onboarding**](context/tech-onboarding.md)  
**Purpose**: Complete project overview, build instructions, and refactoring exercise specifics  
**When to use**: First time working in this codebase; understanding the project architecture, test requirements, and legacy code constraints

### **Coding Standards & Guidelines**

#### [**Core Standards**](guidelines/core-standards.md)
**Purpose**: Universal coding principles applicable to all languages and projects  
**What it covers**:
- General principles (KISS, YAGNI, DRY, Boy Scout Rule)
- SOLID design principles
- Code smell detection and elimination
- Method/class size guidelines
- Naming conventions and readability requirements

**When to consider**: 
- Before writing any new code or refactoring
- When reviewing code quality
- Resolving design decisions (should I extract this method? is this class doing too much?)

#### [**Java Spring Boot Standards**](guidelines/java-springboot.md)
**Purpose**: Java-specific and Spring Boot best practices  
**What it covers**:
- Java 17+ conventions
- Package-by-feature organization
- Spring Boot layer patterns (Controller → Service → Repository)
- Exception handling strategies
- Testing patterns (unit, integration, mocking)
- Database and API conventions

**When to consider**:
- Building Spring Boot applications (Note: current exercises use plain Java)
- Structuring multi-layer applications
- Writing REST controllers or service layers
- Future reference if exercises evolve to Spring Boot


## Recommended Workflow

1. **First visit**: Read [tech-onboarding.md](context/tech-onboarding.md) for project context
2. **Before coding**: Reference [core-standards.md](guidelines/core-standards.md) for refactoring principles
3. **While refactoring**: Apply small, incremental changes following SOLID and code smell guidelines
4. **Always**: Run `mvn test` to verify behavior preservation

## Project-Specific Reminders

- This is a **refactoring workshop**, not feature development
- Preserve exact test outputs (string formatting matters!)
- One exercise: `gildedrose`
- Java 11, Maven, JUnit 4.12
- Incremental changes > big rewrites

## Additional Resources

- Martin Fowler's "Refactoring: Improving the Design of Existing Code" (methodology basis)
- See [README.md](../README.md) for project overview and build instructions
