@Test public void testRemoveMember() throws Exception {
  for (  Authorizable a : authorizables) {
    assertFalse(everyoneGroup.removeMember(a));
  }
}
