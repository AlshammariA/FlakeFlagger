@Test public void testUserGetProperties() throws RepositoryException, NotExecutableException {
  Node n=getNode(user,superuser);
  for (PropertyIterator it=n.getProperties(); it.hasNext(); ) {
    Property p=it.nextProperty();
    if (p.getDefinition().isProtected()) {
      assertFalse(user.hasProperty(p.getName()));
      assertNull(user.getProperty(p.getName()));
    }
 else {
      assertTrue(user.hasProperty(p.getName()));
      assertNotNull(user.getProperty(p.getName()));
    }
  }
}
