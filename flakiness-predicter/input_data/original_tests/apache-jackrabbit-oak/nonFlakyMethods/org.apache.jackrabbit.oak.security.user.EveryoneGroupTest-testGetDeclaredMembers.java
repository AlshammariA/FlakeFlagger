@Test public void testGetDeclaredMembers() throws Exception {
  Set<Authorizable> members=ImmutableSet.copyOf(everyoneGroup.getDeclaredMembers());
  assertFalse(members.contains(everyoneGroup));
  for (  Authorizable a : authorizables) {
    assertTrue(members.contains(a));
  }
}
