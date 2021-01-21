/** 
 * @since oak 1.0
 */
public void testUpdateMixins() throws RepositoryException {
  Node n=testRootNode.addNode("foo","nt:folder");
  ((JackrabbitNode)n).setMixins(new String[]{"test:A","test:AA"});
  superuser.save();
  assertTrue(n.isNodeType("test:AA"));
  assertTrue(n.isNodeType("test:A"));
  ((JackrabbitNode)n).setMixins(new String[]{"test:A","test:AA",JcrConstants.MIX_REFERENCEABLE});
  superuser.save();
  assertTrue(n.isNodeType("test:AA"));
  assertTrue(n.isNodeType("test:A"));
  assertTrue(n.isNodeType(JcrConstants.MIX_REFERENCEABLE));
  assertTrue(n.hasProperty(JcrConstants.JCR_UUID));
  ((JackrabbitNode)n).setMixins(new String[]{JcrConstants.MIX_REFERENCEABLE});
  superuser.save();
  assertFalse(n.isNodeType("test:AA"));
  assertFalse(n.isNodeType("test:A"));
  assertTrue(n.isNodeType(JcrConstants.MIX_REFERENCEABLE));
  assertTrue(n.hasProperty(JcrConstants.JCR_UUID));
}
