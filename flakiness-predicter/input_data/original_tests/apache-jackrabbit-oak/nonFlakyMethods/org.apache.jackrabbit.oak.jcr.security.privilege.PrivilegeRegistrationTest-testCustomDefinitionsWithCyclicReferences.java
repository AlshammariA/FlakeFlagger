@Test public void testCustomDefinitionsWithCyclicReferences() throws RepositoryException {
  try {
    privilegeManager.registerPrivilege("cycl-1",false,new String[]{"cycl-1"});
    fail("Cyclic definitions must be detected upon registration.");
  }
 catch (  RepositoryException e) {
  }
}
