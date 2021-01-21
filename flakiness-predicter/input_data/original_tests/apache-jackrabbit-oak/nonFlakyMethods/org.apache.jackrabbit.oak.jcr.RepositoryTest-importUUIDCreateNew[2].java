@Test public void importUUIDCreateNew() throws Exception {
  Session session=getAdminSession();
  Node node=session.getRootNode().addNode("node");
  node.addMixin("mix:referenceable");
  session.save();
  String uuid=node.getIdentifier();
  ByteArrayOutputStream out=new ByteArrayOutputStream();
  session.exportSystemView("/node",out,true,false);
  node.remove();
  session.save();
  session.importXML("/",new ByteArrayInputStream(out.toByteArray()),ImportUUIDBehavior.IMPORT_UUID_CREATE_NEW);
  session.save();
  node=session.getNode("/node");
  assertFalse(uuid.equals(node.getIdentifier()));
}
