/** 
 * Moving and removing the moved node at destination should be treated like a simple removal at the original position.
 */
@Test public void testMoveAndRemoveDestination() throws Exception {
  allow(path,privilegesFromName(Privilege.JCR_REMOVE_CHILD_NODES));
  allow(childNPath,privilegesFromName(Privilege.JCR_REMOVE_NODE));
  testSession.move(nodePath3,siblingDestPath);
  Node destNode=testSession.getNode(siblingDestPath);
  destNode.remove();
  testSession.save();
}
