@Test public void testEveryoneGroup() throws RepositoryException, NotExecutableException {
  assertEquals(EveryonePrincipal.NAME,everyone.getPrincipal().getName());
}
