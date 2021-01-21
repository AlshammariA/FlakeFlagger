@Test public void saveOnRoot() throws RepositoryException {
  root.addNode("child");
  root.save();
}
