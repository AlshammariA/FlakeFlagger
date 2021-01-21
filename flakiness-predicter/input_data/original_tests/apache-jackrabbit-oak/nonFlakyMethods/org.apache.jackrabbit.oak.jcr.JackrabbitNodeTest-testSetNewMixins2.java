/** 
 * @since oak 1.0
 */
public void testSetNewMixins2() throws RepositoryException {
  Node n=testRootNode.addNode("foo","nt:folder");
  ((JackrabbitNode)n).setMixins(new String[]{"test:A","test:AA"});
  superuser.save();
  assertTrue(n.isNodeType("test:A"));
  assertTrue(n.isNodeType("test:AA"));
  assertTrue(n.hasProperty(JcrConstants.JCR_MIXINTYPES));
}
