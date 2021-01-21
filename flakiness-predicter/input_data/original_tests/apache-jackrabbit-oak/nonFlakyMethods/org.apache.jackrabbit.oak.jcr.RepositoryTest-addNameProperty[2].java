@Test public void addNameProperty() throws RepositoryException, IOException {
  Node parentNode=getNode(TEST_PATH);
  addProperty(parentNode,"name",getAdminSession().getValueFactory().createValue("jcr:something\"",PropertyType.NAME));
}
