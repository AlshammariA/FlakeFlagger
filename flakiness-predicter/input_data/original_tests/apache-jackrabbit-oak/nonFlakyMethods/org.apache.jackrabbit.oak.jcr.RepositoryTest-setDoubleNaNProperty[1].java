@Test public void setDoubleNaNProperty() throws RepositoryException, IOException {
  Node parentNode=getNode(TEST_PATH);
  addProperty(parentNode,"NaN",getAdminSession().getValueFactory().createValue(Double.NaN));
  Session session2=createAnonymousSession();
  try {
    Property property2=session2.getProperty(TEST_PATH + "/NaN");
    assertTrue(Double.isNaN(property2.getDouble()));
  }
  finally {
    session2.logout();
  }
}
