@Test public void testDeclaredMemberOfIncludesEveryone() throws Exception {
  for (  Authorizable a : authorizables) {
    Set<Group> groups=ImmutableSet.copyOf(a.declaredMemberOf());
    assertTrue(groups.contains(everyoneGroup));
  }
}
