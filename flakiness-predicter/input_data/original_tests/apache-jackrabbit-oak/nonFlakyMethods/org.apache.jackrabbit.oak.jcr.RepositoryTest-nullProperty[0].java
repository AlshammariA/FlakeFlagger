@Test public void nullProperty() throws RepositoryException {
  Node parentNode=getNode(TEST_PATH);
  parentNode.setProperty("newProperty","some value");
  parentNode.getSession().save();
  Session session2=createAdminSession();
  try {
    session2.getProperty(TEST_PATH + "/newProperty").setValue((String)null);
    session2.save();
  }
  finally {
    session2.logout();
  }
  Session session3=createAnonymousSession();
  try {
    assertFalse(session3.propertyExists(TEST_PATH + "/newProperty"));
  }
  finally {
    session3.logout();
  }
}
