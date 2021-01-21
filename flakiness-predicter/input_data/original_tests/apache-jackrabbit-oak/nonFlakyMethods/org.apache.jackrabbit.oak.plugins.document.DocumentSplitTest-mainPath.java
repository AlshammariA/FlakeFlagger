@Test public void mainPath(){
  Revision r=Revision.fromString("r1-0-1");
  for (  String path : new String[]{"/","/test","/test/path"}) {
    DocumentStore store=mk.getDocumentStore();
    NodeDocument doc=new NodeDocument(store);
    String id=Utils.getPreviousIdFor(path,r,0);
    doc.put(NodeDocument.ID,id);
    assertEquals(path,doc.getMainPath());
  }
}
