public void testMVReferences() throws RepositoryException {
  Node ref0=testRootNode.addNode(nodeName2,testNodeType);
  ref0.addMixin(mixReferenceable);
  Node ref1=testRootNode.addNode(nodeName3,testNodeType);
  ref1.addMixin(mixReferenceable);
  superuser.save();
  Node n=testRootNode.addNode(nodeName1,testNodeType);
  Value[] vs=new Value[]{superuser.getValueFactory().createValue(ref0),superuser.getValueFactory().createValue(ref1)};
  n.setProperty("myref",vs);
  superuser.save();
  assertEquals("ref0",ref0.getIdentifier(),n.getProperty("myref").getValues()[0].getString());
  assertEquals("ref1",ref1.getIdentifier(),n.getProperty("myref").getValues()[1].getString());
  checkReferences("refs",ref0.getReferences(),n.getPath() + "/myref");
  checkReferences("refs",ref1.getReferences(),n.getPath() + "/myref");
}
