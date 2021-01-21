public void testMixedReferencesOnSameNode() throws RepositoryException {
  Node ref=testRootNode.addNode(nodeName2,testNodeType);
  ref.addMixin(mixReferenceable);
  superuser.save();
  Node n0=testRootNode.addNode(nodeName1,testNodeType);
  n0.setProperty("strong_reference",ref);
  n0.setProperty("weak_reference",superuser.getValueFactory().createValue(ref,true));
  superuser.save();
  checkReferences("refs",ref.getReferences(),n0.getPath() + "/strong_reference");
  checkReferences("refs",ref.getWeakReferences(),n0.getPath() + "/weak_reference");
}
