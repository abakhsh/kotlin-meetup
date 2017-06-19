### Summary

Definitely a step in the right direction. However, there are several problems with this approach:

- Once we translate from the CreateMembershipRequest to Membership, there is no way to insure that the Membership fields
remain non-null
- Translator code is quickly starting to smell
- Membership class makes it unclear as to what is allowed to be null
  - We could fix this by using ```@NotNull``` annotation or ```Optional<>```, but since neither of these options present out of the box compile-time enforcement, we can do better