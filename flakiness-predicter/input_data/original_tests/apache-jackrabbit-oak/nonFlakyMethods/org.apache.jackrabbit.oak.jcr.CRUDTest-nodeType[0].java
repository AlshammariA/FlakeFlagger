@Test(expected=ConstraintViolationException.class) public void nodeType() throws RepositoryException {
  Session s=getAdminSession();
  s.getRootNode().addNode("a","nt:folder").addNode("b");
  s.save();
}
