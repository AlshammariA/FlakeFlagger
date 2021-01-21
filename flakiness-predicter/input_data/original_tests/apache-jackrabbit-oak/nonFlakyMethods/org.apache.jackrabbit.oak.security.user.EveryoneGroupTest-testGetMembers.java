@Test public void testGetMembers() throws Exception {
  Set<Authorizable> members=ImmutableSet.copyOf(everyoneGroup.getMembers());
  assertFalse(members.contains(everyoneGroup));
  for (  Authorizable a : authorizables) {
    assertTrue(members.contains(a));
  }
}
