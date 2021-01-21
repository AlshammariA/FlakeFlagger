public void testWeakReferencesAddLater() throws Exception {
  Node ref=testRootNode.addNode(nodeName2,testNodeType);
  ref.addMixin(mixReferenceable);
  superuser.save();
  String path=ref.getPath();
  String id=ref.getIdentifier();
  ByteArrayOutputStream out=new ByteArrayOutputStream();
  superuser.exportSystemView(path,out,false,false);
  ref.remove();
  superuser.save();
  Node n=testRootNode.addNode(nodeName1,testNodeType);
  n.setProperty("myref",id,PropertyType.WEAKREFERENCE);
  superuser.save();
  try {
    n.getProperty("myref").getNode();
    fail("deref of not-existing reference target must fail.");
  }
 catch (  RepositoryException e) {
  }
  superuser.importXML(Text.getRelativeParent(path,1),new ByteArrayInputStream(out.toByteArray()),ImportUUIDBehavior.IMPORT_UUID_COLLISION_THROW);
  superuser.save();
  assertEquals("ref",path,n.getProperty("myref").getNode().getPath());
  checkReferences("refs",ref.getWeakReferences(),n.getPath() + "/myref");
}
