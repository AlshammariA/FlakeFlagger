@Test public void addBooleanProperty() throws RepositoryException, IOException {
  Node parentNode=getNode(TEST_PATH);
  addProperty(parentNode,"boolean",getAdminSession().getValueFactory().createValue(true));
}
