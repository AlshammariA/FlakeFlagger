@Test public void testRootType() throws RepositoryException {
  assertEquals(testNodeTypeTestRoot,testRootNode.getDefinition().getDeclaringNodeType().getName());
}
