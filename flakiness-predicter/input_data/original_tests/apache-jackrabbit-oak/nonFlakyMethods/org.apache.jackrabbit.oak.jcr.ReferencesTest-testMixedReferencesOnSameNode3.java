public void testMixedReferencesOnSameNode3() throws RepositoryException {
  Node ref=testRootNode.addNode(nodeName2,testNodeType);
  ref.addMixin(mixReferenceable);
  superuser.save();
  Node n0=testRootNode.addNode(nodeName1,testNodeType);
  n0.setProperty("strong_reference",ref);
  n0.setProperty("mv_strong_reference",new Value[]{superuser.getValueFactory().createValue(ref,false)});
  n0.setProperty("weak_reference",superuser.getValueFactory().createValue(ref,true));
  n0.setProperty("mv_weak_reference",new Value[]{superuser.getValueFactory().createValue(ref,true)});
  superuser.save();
  checkReferences("refs",ref.getReferences(),n0.getPath() + "/strong_reference",n0.getPath() + "/mv_strong_reference");
  checkReferences("refs",ref.getWeakReferences(),n0.getPath() + "/weak_reference",n0.getPath() + "/mv_weak_reference");
}
