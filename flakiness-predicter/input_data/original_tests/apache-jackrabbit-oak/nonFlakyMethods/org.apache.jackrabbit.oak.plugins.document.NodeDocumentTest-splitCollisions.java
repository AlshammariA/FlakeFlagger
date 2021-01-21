@Test public void splitCollisions() throws Exception {
  MemoryDocumentStore docStore=new MemoryDocumentStore();
  String id=Utils.getPathFromId("/");
  NodeDocument doc=new NodeDocument(docStore);
  doc.put(Document.ID,id);
  UpdateOp op=new UpdateOp(id,false);
  for (int i=0; i < NodeDocument.NUM_REVS_THRESHOLD + 1; i++) {
    Revision r=Revision.newRevision(1);
    NodeDocument.setRevision(op,r,"c");
    NodeDocument.addCollision(op,r);
  }
  UpdateUtils.applyChanges(doc,op,StableRevisionComparator.INSTANCE);
  doc.split(CONTEXT);
}
