@Test public void addStringProperty() throws RepositoryException, IOException {
  Node parentNode=getNode(TEST_PATH);
  addProperty(parentNode,"string",getAdminSession().getValueFactory().createValue("string value"));
}
