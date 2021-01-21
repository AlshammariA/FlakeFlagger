@Test(expected=PathNotFoundException.class) public void getNonExistingNode() throws RepositoryException {
  getNode("/qoo");
}
