/** 
 * @since OAK 1.0 : Renaming a node requires the same permission as moving itaround. This behavior differs from Jackrabbit 2.x where renaming just required the ability to change the child collection of the parent.
 */
@Test public void testRename3() throws Exception {
  allow(path,privilegesFromNames(new String[]{Privilege.JCR_ADD_CHILD_NODES,Privilege.JCR_NODE_TYPE_MANAGEMENT,Privilege.JCR_REMOVE_CHILD_NODES,Privilege.JCR_REMOVE_NODE}));
  Node child=testSession.getNode(childNPath);
  ((JackrabbitNode)child).rename("rename");
  testSession.save();
}
