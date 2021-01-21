/** 
 * @since oak 1.0
 */
public void testSetRemoveMixins() throws RepositoryException {
  Node n=testRootNode.addNode("foo","nt:folder");
  ((JackrabbitNode)n).setMixins(new String[]{"test:A","test:AA"});
  superuser.save();
  ((JackrabbitNode)n).setMixins(new String[]{"test:A"});
  superuser.save();
  assertTrue(n.isNodeType("test:A"));
  assertFalse(n.isNodeType("test:AA"));
}
