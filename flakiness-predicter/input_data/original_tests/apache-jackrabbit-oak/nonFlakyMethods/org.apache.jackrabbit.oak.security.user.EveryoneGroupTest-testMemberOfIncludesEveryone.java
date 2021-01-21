@Test public void testMemberOfIncludesEveryone() throws Exception {
  for (  Authorizable a : authorizables) {
    Set<Group> groups=ImmutableSet.copyOf(a.memberOf());
    assertTrue(groups.contains(everyoneGroup));
  }
}
