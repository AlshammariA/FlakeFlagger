@Test public void addDoubleProperty() throws RepositoryException, IOException {
  Node parentNode=getNode(TEST_PATH);
  addProperty(parentNode,"double",getAdminSession().getValueFactory().createValue(42.2D));
}
