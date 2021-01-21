@Test public void saveContainsAllChanges() throws RepositoryException {
  foo.addNode("child");
  foo.save();
}
