/** 
 * @since oak 1.0
 */
public void testSetNewMixins() throws RepositoryException {
  Node n=testRootNode.addNode("foo","nt:folder");
  ((JackrabbitNode)n).setMixins(new String[]{"test:AA","test:A"});
  superuser.save();
  assertTrue(n.isNodeType("test:AA"));
  assertTrue(n.isNodeType("test:A"));
  assertTrue(n.hasProperty(JcrConstants.JCR_MIXINTYPES));
}
