@Test public void testPrincipal() throws RepositoryException {
  assertEquals(EveryonePrincipal.getInstance(),everyone.getPrincipal());
}
