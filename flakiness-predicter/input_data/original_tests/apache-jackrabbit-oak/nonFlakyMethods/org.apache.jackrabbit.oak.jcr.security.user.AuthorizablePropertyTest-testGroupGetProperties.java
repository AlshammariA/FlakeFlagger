@Test public void testGroupGetProperties() throws RepositoryException, NotExecutableException {
  Node n=getNode(group,superuser);
  for (PropertyIterator it=n.getProperties(); it.hasNext(); ) {
    Property prop=it.nextProperty();
    if (prop.getDefinition().isProtected()) {
      assertFalse(group.hasProperty(prop.getName()));
      assertNull(group.getProperty(prop.getName()));
    }
 else {
      assertTrue(group.hasProperty(prop.getName()));
      assertNotNull(group.getProperty(prop.getName()));
    }
  }
}
