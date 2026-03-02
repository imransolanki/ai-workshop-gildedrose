# Refactoring Backlog

## Completed Issues

### ✅ Issue #5 - Constructor Validation and Immutability (COMPLETED)
**File:** `src/main/java/gildedrose/GildedRose.java:10-12`  
**Priority:** Medium  
**Severity:** Medium  
**Status:** ✅ Resolved on 2026-03-02

**Description:**  
Constructor accepts `Item[]` array directly without validation or defensive copying, creating shared mutable state vulnerability.

**Resolution Applied:**
1. ✅ Added null validation: `if (items == null) throw new IllegalArgumentException("items cannot be null")`
2. ✅ Made field `final`: `private final Item[] items;`
3. ✅ Added test: `constructor_ThrowsExceptionWhenItemsNull()`

**Benefits:**
- Prevents NullPointerException
- Immutable field reference (can't be reassigned)
- Clear error message for invalid input
- 19/19 tests passing

**Note:** Defensive copy not implemented as it's a refactoring exercise with controlled test environment. For production code handling sensitive data, consider: `this.items = Arrays.copyOf(items, items.length);`

---

## Pending Issues

*No pending issues*

---

*Last updated: 2026-03-02*
