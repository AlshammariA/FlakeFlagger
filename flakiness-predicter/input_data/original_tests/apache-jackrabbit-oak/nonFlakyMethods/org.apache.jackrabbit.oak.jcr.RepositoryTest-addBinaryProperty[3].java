@Test public void addBinaryProperty() throws RepositoryException, IOException {
  Node parentNode=getNode(TEST_PATH);
  InputStream is=new ByteArrayInputStream("foo\"".getBytes());
  Binary bin=getAdminSession().getValueFactory().createBinary(is);
  addProperty(parentNode,"binary",getAdminSession().getValueFactory().createValue(bin));
}
