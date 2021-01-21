/** 
 * @since oak 1.0
 */
public void testSetEmptyMixins() throws RepositoryException {
  Node n=testRootNode.addNode("foo","nt:folder");
  n.addMixin("test:AA");
  superuser.save();
  ((JackrabbitNode)n).setMixins(new String[0]);
  superuser.save();
  assertFalse(n.isNodeType("test:AA"));
  assertTrue(n.hasProperty(JcrConstants.JCR_MIXINTYPES));
  assertEquals(0,n.getProperty(JcrConstants.JCR_MIXINTYPES).getValues().length);
}
